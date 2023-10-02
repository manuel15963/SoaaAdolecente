package com.example.MsAdolescente.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ProgramasRequestDto implements Serializable {

    private static final long serialVersionUID = 8222253670338491507L;
    private String name;
    private String type;
    private String duration;
}
