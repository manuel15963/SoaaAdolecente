package com.example.MsAdolescente.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ListadoResponseDto implements Serializable {

    private Long registroId;
    private Long adolescenteId;
    private String nombreCompleto;
    private String nombrePrograma;
    private LocalDate fecha;
    private Integer duracion;
}
