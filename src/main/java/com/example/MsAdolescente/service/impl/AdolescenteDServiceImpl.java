package com.example.MsAdolescente.service.impl;

import com.example.MsAdolescente.domain.dto.AdolescenteDRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteDResponseDto;

import com.example.MsAdolescente.domain.mapper.AdolescenteDMapper;
import com.example.MsAdolescente.domain.mapper.AdolescenteMapper;
import com.example.MsAdolescente.domain.model.AdolescenteD;
import com.example.MsAdolescente.exception.ResourceNotFoundException;
import com.example.MsAdolescente.repository.AdolescenteDRepository;
import com.example.MsAdolescente.service.AdolescenteDService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.MsAdolescente.domain.mapper.AdolescenteDMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdolescenteDServiceImpl implements AdolescenteDService {

    private final AdolescenteDRepository adolescenteDRepository;

    @Override
    public Mono<AdolescenteDResponseDto> findById(Integer id) {
        return this.adolescenteDRepository.findById(id)
                .map(AdolescenteDMapper::toDto);
    }

    @Override
    public Flux<AdolescenteDResponseDto> findAll() {
        return this.adolescenteDRepository.findAll()
                .map(AdolescenteDMapper::toDto);
    }

    @Override
    public Mono<AdolescenteDResponseDto> creatr(AdolescenteDRequestDto request) {
        return adolescenteDRepository.save(toModel(request))
                .map(AdolescenteDMapper::toDto);
    }

    @Override
    public Mono<AdolescenteDResponseDto> update(AdolescenteDRequestDto request, Integer id) {
        return this.adolescenteDRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id:" + id +"no fue encontrado")))
                .flatMap(adolescenteD -> this.adolescenteDRepository.save(AdolescenteDMapper.toModel(adolescenteD.getId(),request)))
                .map(AdolescenteDMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return this.adolescenteDRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id : " + id + " no fue encontrado")))
                .then(this.adolescenteDRepository.deleteById(id))
                .doOnSuccess(unused -> log.info("Se elimino el usuario con id: {}", id));
    }
}
