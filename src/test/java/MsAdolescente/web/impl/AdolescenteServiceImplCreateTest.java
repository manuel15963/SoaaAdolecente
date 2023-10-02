package MsAdolescente.web.impl;

import com.example.MsAdolescente.domain.dto.AdolescenteRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteResponseDto;
import com.example.MsAdolescente.domain.mapper.AdolescenteMapper;
import com.example.MsAdolescente.domain.model.Adolescente;
import com.example.MsAdolescente.repository.AdolescenteRepository;
import com.example.MsAdolescente.service.impl.AdolescenteServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AdolescenteServiceImplCreateTest {

    @InjectMocks
    private AdolescenteServiceImpl adolescenteService;

    @Mock
    private AdolescenteRepository adolescenteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreate() {
        AdolescenteRequestDto requestDto = new AdolescenteRequestDto(
                "Juan", "Perez", "Lopez", "DNI", "12345678", null,
                "987654321", "Calle Falsa 123", "M", "A", "Robo", "Abogado Test"
        );

        Adolescente adolescente = AdolescenteMapper.toModel(requestDto);
        adolescente.setId(1);

        when(adolescenteRepository.save(any(Adolescente.class))).thenReturn(Mono.just(adolescente));

        Mono<AdolescenteResponseDto> responseMono = adolescenteService.create(requestDto);

        StepVerifier.create(responseMono)
                .assertNext(response -> {
                    assertEquals(Integer.valueOf(1), response.getId());
                    assertEquals("Juan", response.getName());
                    // ... Add more assertions as needed ...
                })
                .expectComplete()
                .verify();

        verify(adolescenteRepository, times(1)).save(any(Adolescente.class));
    }

}
