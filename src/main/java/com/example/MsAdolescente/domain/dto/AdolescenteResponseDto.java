package com.example.MsAdolescente.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AdolescenteResponseDto implements Serializable {
    private static final long serialVersionUID = 8735757125749188522L;

    private Integer id;
    private String name;
    private String father_surname;
    private String mother_surname;
    private String document_type;
    private String document_number;
    private LocalDate birthdate;
    private String cell_phone;
    private String address;
    private String gender;
    private String crime_committed;
    private String attorney;

}
