package com.example.MsAdolescente.domain.mapper;

import com.example.MsAdolescente.domain.dto.AdolescenteRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteResponseDto;
import com.example.MsAdolescente.domain.model.Adolescente;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdolescenteMapper {

    public static Adolescente toModel(AdolescenteRequestDto dto){
        return new Adolescente(
                dto.getName(),
                dto.getFather_surname(),
                dto.getMother_surname(),
                dto.getDocument_type(),
                dto.getDocument_number(),
                dto.getBirthdate(),
                dto.getCell_phone(),
                dto.getAddress(),
                dto.getGender(),
                dto.getState(),
                dto.getCrime_committed(),
                dto.getAttorney()
        );
    }

    public static Adolescente toModel(Integer id, AdolescenteRequestDto dto){
        return new Adolescente(
                id,
                dto.getName(),
                dto.getFather_surname(),
                dto.getMother_surname(),
                dto.getDocument_type(),
                dto.getDocument_number(),
                dto.getBirthdate(),
                dto.getCell_phone(),
                dto.getAddress(),
                dto.getGender(),
                dto.getState(),
                dto.getCrime_committed(),
                dto.getAttorney()
        );
    }

    public static AdolescenteResponseDto toDto(Adolescente model){
        return new AdolescenteResponseDto(
                model.getId(),
                model.getName(),
                model.getFather_surname(),
                model.getMother_surname(),
                model.getDocument_type(),
                model.getDocument_number(),
                model.getBirthdate(),
                model.getCell_phone(),
                model.getAddress(),
                model.getGender(),
                model.getCrime_committed(),
                model.getAttorney()
        );
    }
}
