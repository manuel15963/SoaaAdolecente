package com.example.MsAdolescente.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AdolescenteDResponseDto implements Serializable {

    private static final long serialVersionUID = 8222253670338491507L;

    private Integer id;
    private LocalDate scheduledDate;
    private String address;
    private Long adolescente_id;
    private Long programas_id;

}
