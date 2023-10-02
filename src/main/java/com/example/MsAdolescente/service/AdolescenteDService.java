package com.example.MsAdolescente.service;

import com.example.MsAdolescente.domain.dto.AdolescenteDRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescenteDResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface AdolescenteDService {

    Mono<AdolescenteDResponseDto> findById(Integer id);
    Flux<AdolescenteDResponseDto> findAll();
    Mono<AdolescenteDResponseDto> creatr(AdolescenteDRequestDto request);
    Mono<AdolescenteDResponseDto> update(AdolescenteDRequestDto request, Integer id);
    Mono<Void> delete(Integer id);
}
