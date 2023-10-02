package com.example.MsAdolescente.web;

import com.example.MsAdolescente.domain.dto.AdolescenteRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteResponseDto;
import com.example.MsAdolescente.domain.dto.ProgramasRequestDto;
import com.example.MsAdolescente.domain.dto.ProgramasResponseDto;
import com.example.MsAdolescente.domain.model.Adolescente;
import com.example.MsAdolescente.domain.model.Programas;
import com.example.MsAdolescente.repository.AdolescenteRepository;
import com.example.MsAdolescente.repository.ProgramasRepository;
import com.example.MsAdolescente.service.ProgramasService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@RestController
@RequestMapping("/v1/programas")
@RequiredArgsConstructor
public class ProgramasController {

    private final ProgramasService programasService;

    @Autowired
    ProgramasRepository programasRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<ProgramasResponseDto> findAll(){
        return this.programasService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/list")
    public Flux<Programas> getLegalGuardian() {
        return programasRepository.findAll()
                .sort(Comparator.comparing(Programas::getId));
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<ProgramasResponseDto> findById(@PathVariable Integer id){
        return this.programasService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<ProgramasResponseDto> create(@RequestBody ProgramasRequestDto dto){
        return this.programasService.create(dto);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<ProgramasResponseDto> update(@RequestBody ProgramasRequestDto dto, @PathVariable Integer id){
        return this.programasService.update(dto,id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id){
        return this.programasService.delete(id);
    }

}
