package com.example.MsAdolescente.service;

import com.example.MsAdolescente.domain.dto.ListadoResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public interface ListadoService {

    Flux<ListadoResponseDto> findAll();
}
