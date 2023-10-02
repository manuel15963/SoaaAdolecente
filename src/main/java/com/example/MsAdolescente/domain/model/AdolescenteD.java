package com.example.MsAdolescente.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Table(name = "Adolescente_detalle")
@Getter
@Setter
@NoArgsConstructor
public class AdolescenteD {

    @Id
    private Integer id;
    private LocalDate scheduledDate;
    private String address;
    private Long adolescente_id;
    private Long programas_id;

    @Transient  // Otra anotación necesaria para R2DBC
    private Adolescente adolescente;

    public AdolescenteD(LocalDate scheduledDate, String address, Long adolescente_id, Long programas_id){
        this.scheduledDate = scheduledDate;
        this.address = address;
        this.adolescente_id = adolescente_id;
        this.programas_id = programas_id;
    }

    public AdolescenteD(Integer id, LocalDate scheduledDate, String address, Long adolescente_id, Long programas_id){
        this.id = id;
        this.scheduledDate = scheduledDate;
        this.address = address;
        this.adolescente_id = adolescente_id;
        this.programas_id = programas_id;
    }
}
