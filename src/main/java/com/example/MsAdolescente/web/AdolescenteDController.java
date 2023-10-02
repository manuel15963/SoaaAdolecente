package com.example.MsAdolescente.web;

import com.example.MsAdolescente.domain.dto.AdolescenteDRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteDResponseDto;
import com.example.MsAdolescente.domain.dto.AdolescenteRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteResponseDto;
import com.example.MsAdolescente.domain.model.Adolescente;
import com.example.MsAdolescente.domain.model.AdolescenteD;
import com.example.MsAdolescente.repository.AdolescenteDRepository;
import com.example.MsAdolescente.repository.AdolescenteRepository;
import com.example.MsAdolescente.service.AdolescenteDService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@RestController
@RequestMapping("/v1/adolescenteD")
@RequiredArgsConstructor
public class AdolescenteDController {

    private final AdolescenteDService adolescenteDService;

    @Autowired
    AdolescenteDRepository adolescenteDRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<AdolescenteDResponseDto> findAll(){

        return this.adolescenteDService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/list")
    public Flux<AdolescenteD> getLegalGuardian() {
        return adolescenteDRepository.findAll()
                .sort(Comparator.comparing(AdolescenteD::getId));
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<AdolescenteDResponseDto> findById(@PathVariable Integer id){
        return this.adolescenteDService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<AdolescenteDResponseDto> create(@RequestBody AdolescenteDRequestDto dto){
        return this.adolescenteDService.creatr(dto);
    }
}
