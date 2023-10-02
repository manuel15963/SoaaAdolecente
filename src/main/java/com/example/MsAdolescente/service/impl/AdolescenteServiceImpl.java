package com.example.MsAdolescente.service.impl;

import com.example.MsAdolescente.domain.dto.AdolescenteRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteResponseDto;
import com.example.MsAdolescente.domain.mapper.AdolescenteMapper;
import com.example.MsAdolescente.exception.ResourceNotFoundException;
import com.example.MsAdolescente.repository.AdolescenteRepository;
import com.example.MsAdolescente.service.AdolescenteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.MsAdolescente.domain.mapper.AdolescenteMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdolescenteServiceImpl implements AdolescenteService {

    private  final AdolescenteRepository adolescenteRepository;
    @Override
    public Mono<AdolescenteResponseDto> findById(Integer id) {
        return this.adolescenteRepository.findById(id)
                .map(AdolescenteMapper::toDto);
    }

    @Override
    public Flux<AdolescenteResponseDto> findAll() {
        return this.adolescenteRepository.findAll()
                .filter(adolescente -> adolescente.getState().equals("A"))
                .map(AdolescenteMapper::toDto);
    }

    @Override
    public Mono<AdolescenteResponseDto> create(AdolescenteRequestDto request) {
        return adolescenteRepository.save(toModel(request))
               .map(AdolescenteMapper::toDto);
    }

    @Override
    public Mono<AdolescenteResponseDto> update(AdolescenteRequestDto request, Integer id) {
        return this.adolescenteRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id:" + id +"no fue encontrado")))
                .flatMap(adolescente -> this.adolescenteRepository.save(toModel(adolescente.getId(),request)))
                .map(AdolescenteMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return this.adolescenteRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id:" + id +"no fue encontrado")))
                .flatMap(adolescente -> {
                    adolescente.setState("I");
                    return this.adolescenteRepository.save(adolescente);
                })
                .doOnSuccess(unused -> log.info("Se elimino el siguiente ID " +id))
                .then();
    }
}
