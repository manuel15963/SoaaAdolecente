package MsAdolescente.web;

import com.example.MsAdolescente.domain.dto.AdolescenteResponseDto;
import com.example.MsAdolescente.service.AdolescenteService;
import com.example.MsAdolescente.web.AdolescenteController;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

public class AdolescenteControllerFindByIdTest {

    private WebTestClient webTestClient;

    @MockBean
    private AdolescenteService adolescenteService;

    @BeforeEach
    public void setUp() {
        this.webTestClient = WebTestClient.bindToController(new AdolescenteController(adolescenteService)).build();
    }

    @Test
    public void testFindById() {
        AdolescenteResponseDto responseDto = new AdolescenteResponseDto(
                1, "Juan", "Perez", "Lopez", "DNI", "12345678", null,
                "987654321", "Calle Falsa 123", "M", "Robo", "Abogado Test"
        );

        Mockito.when(adolescenteService.findById(1)).thenReturn(Mono.just(responseDto));

        webTestClient.get()
                .uri("/v1/adolescente/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(AdolescenteResponseDto.class)
                .isEqualTo(responseDto);
    }

}
