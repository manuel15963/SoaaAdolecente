package com.example.MsAdolescente.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "programas")
@Getter
@Setter
@NoArgsConstructor
public class Programas {

    @Id
    private Integer id;
    private String name;
    private String type;
    private String duration;

    public Programas(String name, String type, String duration){
        this.name = name;
        this.type = type;
        this.duration = duration;
    }

    public Programas(Integer id, String name, String type, String duration){
        this.id = id;
        this.name = name;
        this.type = type;
        this.duration = duration;
    }
}