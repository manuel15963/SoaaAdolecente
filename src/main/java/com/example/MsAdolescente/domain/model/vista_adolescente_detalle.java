package com.example.MsAdolescente.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class vista_adolescente_detalle {
    @Id
    private Long registroId;
    private Long adolescenteId;
    private String nombreCompleto;
    private String nombrePrograma;
    private LocalDate fecha;
    private Integer duracion;

}
