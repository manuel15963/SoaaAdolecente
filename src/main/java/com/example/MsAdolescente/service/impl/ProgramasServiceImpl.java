package com.example.MsAdolescente.service.impl;

import com.example.MsAdolescente.domain.dto.ProgramasRequestDto;
import com.example.MsAdolescente.domain.dto.ProgramasResponseDto;
import com.example.MsAdolescente.domain.mapper.ProgramasMapper;
import com.example.MsAdolescente.exception.ResourceNotFoundException;
import com.example.MsAdolescente.repository.ProgramasRepository;
import com.example.MsAdolescente.service.ProgramasService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.MsAdolescente.domain.mapper.ProgramasMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProgramasServiceImpl implements ProgramasService {

    private final ProgramasRepository programasRepository;

    @Override
    public Mono<ProgramasResponseDto> findById(Integer id) {
        return this.programasRepository.findById(id)
                .map(ProgramasMapper::toDto);
    }

    @Override
    public Flux<ProgramasResponseDto> findAll() {
        return this.programasRepository.findAll()
                .map(ProgramasMapper::toDto);
    }

    @Override
    public Mono<ProgramasResponseDto> create(ProgramasRequestDto request) {
        return this.programasRepository.save(toModel(request))
                .map(ProgramasMapper::toDto);
    }

    @Override
    public Mono<ProgramasResponseDto> update(ProgramasRequestDto request, Integer id) {
        return this.programasRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id:" + id +"no fue encontrado")))
                .flatMap(programas -> this.programasRepository.save(toModel(programas.getId(),request)))
                .map(ProgramasMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return this.programasRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id : " + id + " no fue encontrado")))
                .then(this.programasRepository.deleteById(id))
                .doOnSuccess(unused -> log.info("Se elimino el usuario con id: {}", id));
    }
}
