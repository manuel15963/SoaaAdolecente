package com.example.MsAdolescente.domain.mapper;

import com.example.MsAdolescente.domain.dto.ProgramasRequestDto;
import com.example.MsAdolescente.domain.dto.ProgramasResponseDto;
import com.example.MsAdolescente.domain.model.Programas;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProgramasMapper {

    public static Programas toModel(ProgramasRequestDto dto){
        return new Programas(
                dto.getName(),
                dto.getType(),
                dto.getDuration()
        );
    }

    public static Programas toModel(Integer id, ProgramasRequestDto dto){
        return new Programas(
                id,
                dto.getName(),
                dto.getType(),
                dto.getDuration()
        );
    }

    public static ProgramasResponseDto toDto(Programas model){
        return new ProgramasResponseDto(
                model.getId(),
                model.getName(),
                model.getType(),
                model.getDuration()
        );
    }
}
