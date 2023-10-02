package com.example.MsAdolescente.domain.mapper;

import com.example.MsAdolescente.domain.dto.ListadoResponseDto;
import com.example.MsAdolescente.domain.model.vista_adolescente_detalle;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ListadoMapper {

    public static ListadoResponseDto toDto(vista_adolescente_detalle model){
        return new ListadoResponseDto(
                model.getRegistroId(),
                model.getAdolescenteId(),
                model.getNombreCompleto(),
                model.getNombrePrograma(),
                model.getFecha(),
                model.getDuracion()
        );
    }
}
