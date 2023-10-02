package MsAdolescente.domain.mapper;

import com.example.MsAdolescente.domain.dto.AdolescenteRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteResponseDto;
import com.example.MsAdolescente.domain.mapper.AdolescenteMapper;
import com.example.MsAdolescente.domain.model.Adolescente;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AdolescenteMapperTest1 {

    private AdolescenteRequestDto requestDto;
    private Adolescente adolescente;

    @BeforeEach
    public void setUp() {
        requestDto = new AdolescenteRequestDto(
                "Juan",
                "Perez",
                "Lopez",
                "DNI",
                "12345678",
                LocalDate.of(2005, 1, 1),
                "987654321",
                "Calle Falsa 123",
                "M",
                "A",
                "Robo",
                "Abogado Test"
        );
        adolescente = new Adolescente(
                1,
                "Juan",
                "Perez",
                "Lopez",
                "DNI",
                "12345678",
                LocalDate.of(2005, 1, 1),
                "987654321",
                "Calle Falsa 123",
                "M",
                "A",
                "Robo",
                "Abogado Test"
        );
    }

    @Test
    public void toModel_ConvertsDtoToModel_Successfully() {
        Adolescente result = AdolescenteMapper.toModel(requestDto);
        assertEquals(requestDto.getName(), result.getName());
        assertEquals(requestDto.getFather_surname(), result.getFather_surname());
        // ... Add assertions for all other fields ...

        assertNull(result.getId()); // Since the ID is not set in the DTO
    }

    @Test
    public void toModel_WithId_ConvertsDtoToModel_Successfully() {
        Adolescente result = AdolescenteMapper.toModel(1, requestDto);
        assertEquals(1, result.getId());
        assertEquals(requestDto.getName(), result.getName());
        // ... Add assertions for all other fields ...
    }

    @Test
    public void toDto_ConvertsModelToDto_Successfully() {
        AdolescenteResponseDto result = AdolescenteMapper.toDto(adolescente);
        assertEquals(adolescente.getId(), result.getId());
        assertEquals(adolescente.getName(), result.getName());
        // ... Add assertions for all other fields ...
    }
}
