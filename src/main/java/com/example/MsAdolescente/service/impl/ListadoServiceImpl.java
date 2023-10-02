package com.example.MsAdolescente.service.impl;

import com.example.MsAdolescente.domain.dto.ListadoResponseDto;
import com.example.MsAdolescente.domain.mapper.ListadoMapper;
import com.example.MsAdolescente.repository.ListadoRepository;
import com.example.MsAdolescente.service.ListadoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListadoServiceImpl implements ListadoService {

    private final ListadoRepository listadoRepository;

    @Override
    public Flux<ListadoResponseDto> findAll() {
        return this.listadoRepository.findAll()
                .map(ListadoMapper::toDto);
    }
}
