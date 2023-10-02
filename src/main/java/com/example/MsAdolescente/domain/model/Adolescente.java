package com.example.MsAdolescente.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;
@Table(name = "adolescente")
@Getter
@Setter
@NoArgsConstructor
public class Adolescente {
    @Id
    private Integer id;
    private String name;
    private String father_surname;
    private String mother_surname;
    private String document_type;
    private String document_number;
    private LocalDate  birthdate;
    private String cell_phone;
    private String address;
    private String gender;
    private String state;
    private String crime_committed;
    private String attorney;


    public Adolescente(String name, String father_surname, String mother_surname, String document_type, String document_number,LocalDate birthdate, String cell_phone, String address, String gender, String state, String crime_committed, String attorney) {
        this.name = name;
        this.father_surname = father_surname;
        this.mother_surname = mother_surname;
        this.document_type = document_type;
        this.document_number = document_number;
        this.birthdate = birthdate;
        this.cell_phone = cell_phone;
        this.address = address;
        this.gender = gender;
        this.state = state;
        this.crime_committed = crime_committed;
        this.attorney = attorney;
    }

    public Adolescente(Integer id, String name, String father_surname, String mother_surname, String document_type, String document_number,LocalDate birthdate, String cell_phone, String address, String gender, String state, String crime_committed, String attorney) {
        this.id = id;
        this.name = name;
        this.father_surname = father_surname;
        this.mother_surname = mother_surname;
        this.document_type = document_type;
        this.document_number = document_number;
        this.birthdate = birthdate;
        this.cell_phone = cell_phone;
        this.address = address;
        this.gender = gender;
        this.state = state;
        this.crime_committed = crime_committed;
        this.attorney = attorney;
    }
}
