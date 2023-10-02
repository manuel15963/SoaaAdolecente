package com.example.MsAdolescente.service;

import com.example.MsAdolescente.domain.dto.ProgramasRequestDto;
import com.example.MsAdolescente.domain.dto.ProgramasResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ProgramasService {

    Mono<ProgramasResponseDto> findById(Integer id);
    Flux<ProgramasResponseDto> findAll();
    Mono<ProgramasResponseDto> create(ProgramasRequestDto requestDto);
    Mono<ProgramasResponseDto> update(ProgramasRequestDto request, Integer id);
    Mono<Void> delete(Integer id);
}
