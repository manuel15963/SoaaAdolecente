package com.example.MsAdolescente.web;

import com.example.MsAdolescente.domain.dto.AdolescenteRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteResponseDto;
import com.example.MsAdolescente.domain.model.Adolescente;
import com.example.MsAdolescente.repository.AdolescenteRepository;
import com.example.MsAdolescente.service.AdolescenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@RestController
@RequestMapping("/v1/adolescente")
@RequiredArgsConstructor
public class AdolescenteController {
    private final AdolescenteService adolescenteService;

    @Autowired
    AdolescenteRepository AdolescenteRepository;

    @CrossOrigin(origins = "*")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<AdolescenteResponseDto> findAll(){
        return this.adolescenteService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public Flux<Adolescente> getLegalGuardian() {
        return AdolescenteRepository.findAll()
                .sort(Comparator.comparing(Adolescente::getId));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/inactivos")
    public Flux<Adolescente> getAdolescenteInactivo(){
        return AdolescenteRepository.findAll()
                .sort(Comparator.comparing(Adolescente::getId))
                .filter(dLog -> dLog.getState().equals("I"));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/activo")
    public Flux<Adolescente> getAdolescenteActivo(){
        return AdolescenteRepository.findAll()
                .sort(Comparator.comparing(Adolescente::getId))
                .filter(dLog -> dLog.getState().equals("A"));
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<AdolescenteResponseDto> findById(@PathVariable Integer id){
        return this.adolescenteService.findById(id);
    }

    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<AdolescenteResponseDto> create(@RequestBody AdolescenteRequestDto dto){
        return this.adolescenteService.create(dto);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<AdolescenteResponseDto> update(@RequestBody AdolescenteRequestDto dto, @PathVariable Integer id){
        return this.adolescenteService.update(dto,id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/restaurar/{idA}")
    public Mono<Adolescente> reactivateLegalGuardian(@PathVariable("idA") int id) {
        return AdolescenteRepository.findById(id)
                .map((dLog) -> {
                    dLog.setState("A");
                    return dLog;
                }).flatMap(dLog -> AdolescenteRepository.save(dLog));
    }


    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id){
        return this.adolescenteService.delete(id);
    }

}
