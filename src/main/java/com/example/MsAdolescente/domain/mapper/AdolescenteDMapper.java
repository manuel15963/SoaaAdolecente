package com.example.MsAdolescente.domain.mapper;

import com.example.MsAdolescente.domain.dto.AdolescenteDRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteDResponseDto;
import com.example.MsAdolescente.domain.model.AdolescenteD;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdolescenteDMapper {

    public static AdolescenteD toModel(AdolescenteDRequestDto dto){
        return new AdolescenteD(
                dto.getScheduledDate(),
                dto.getAddress(),
                dto.getAdolescente_id(),
                dto.getProgramas_id()
        );
    }

    public static AdolescenteD toModel(Integer id, AdolescenteDRequestDto dto){
        return new AdolescenteD(
                id,
                dto.getScheduledDate(),
                dto.getAddress(),
                dto.getAdolescente_id(),
                dto.getProgramas_id()
        );
    }

    public static AdolescenteDResponseDto toDto(AdolescenteD model){
        return new AdolescenteDResponseDto(
                model.getId(),
                model.getScheduledDate(),
                model.getAddress(),
                model.getAdolescente_id(),
                model.getProgramas_id()
        );
    }
}
