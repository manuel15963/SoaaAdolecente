package com.example.MsAdolescente.service;

import com.example.MsAdolescente.domain.dto.AdolescenteRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface AdolescenteService {
    Mono<AdolescenteResponseDto> findById(Integer id);
    Flux<AdolescenteResponseDto> findAll();
    Mono<AdolescenteResponseDto> create(AdolescenteRequestDto request);
    Mono<AdolescenteResponseDto> update(AdolescenteRequestDto request, Integer id);
    Mono<Void> delete(Integer id);
}
