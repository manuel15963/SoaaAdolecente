package MsAdolescente.web.impl;

import com.example.MsAdolescente.domain.dto.AdolescenteResponseDto;
import com.example.MsAdolescente.domain.model.Adolescente;
import com.example.MsAdolescente.repository.AdolescenteRepository;
import com.example.MsAdolescente.service.impl.AdolescenteServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AdolescenteServiceImplTest {

    @InjectMocks
    private AdolescenteServiceImpl adolescenteService;

    @Mock
    private AdolescenteRepository adolescenteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll_ReturnsListOfAdolescentes() {
        Adolescente adolescente = new Adolescente(
                1,
                "Juan",
                "Perez",
                "Lopez",
                "DNI",
                "12345678",
                null,
                "987654321",
                "Calle Falsa 123",
                "M",
                "A",
                "Robo",
                "Abogado Test"
        );
        when(adolescenteRepository.findAll()).thenReturn(Flux.just(adolescente));

        Flux<AdolescenteResponseDto> responseFlux = adolescenteService.findAll();

        StepVerifier.create(responseFlux)
                .assertNext(response -> {
                    assertEquals("Juan", response.getName());
                    // ... Add more assertions as needed ...
                })
                .expectComplete()
                .verify();

        verify(adolescenteRepository, times(1)).findAll();
    }

}
