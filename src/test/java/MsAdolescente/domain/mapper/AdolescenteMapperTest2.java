package MsAdolescente.domain.mapper;

import com.example.MsAdolescente.domain.dto.AdolescenteRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteResponseDto;
import com.example.MsAdolescente.domain.mapper.AdolescenteMapper;
import com.example.MsAdolescente.domain.model.Adolescente;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdolescenteMapperTest2 {

    @Test
    public void testToModelFromDto() {
        AdolescenteRequestDto dto = new AdolescenteRequestDto(
                "Juan", "Perez", "Lopez", "DNI", "12345678", LocalDate.of(2005, 5, 10),
                "987654321", "Calle Falsa 123", "M", "A", "Robo", "Abogado Test"
        );

        Adolescente model = AdolescenteMapper.toModel(dto);

        assertEquals(dto.getName(), model.getName());
        assertEquals(dto.getFather_surname(), model.getFather_surname());
        // ... Continue with other assertions ...
    }

    @Test
    public void testToModelFromIdAndDto() {
        AdolescenteRequestDto dto = new AdolescenteRequestDto(
                "Juan", "Perez", "Lopez", "DNI", "12345678", LocalDate.of(2005, 5, 10),
                "987654321", "Calle Falsa 123", "M", "A", "Robo", "Abogado Test"
        );

        Adolescente model = AdolescenteMapper.toModel(1, dto);

        assertEquals(Integer.valueOf(1), model.getId());
        assertEquals(dto.getName(), model.getName());
    }

    @Test
    public void testToDtoFromModel() {
        Adolescente model = new Adolescente(
                1, "Juan", "Perez", "Lopez", "DNI", "12345678", LocalDate.of(2005, 5, 10),
                "987654321", "Calle Falsa 123", "M", "A", "Robo", "Abogado Test"
        );

        AdolescenteResponseDto dto = AdolescenteMapper.toDto(model);

        assertEquals(model.getId(), dto.getId());
        assertEquals(model.getName(), dto.getName());
    }

}
