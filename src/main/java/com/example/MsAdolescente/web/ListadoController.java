package com.example.MsAdolescente.web;

import com.example.MsAdolescente.domain.dto.ListadoResponseDto;
import com.example.MsAdolescente.domain.model.vista_adolescente_detalle;
import com.example.MsAdolescente.repository.ListadoRepository;
import com.example.MsAdolescente.service.ListadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Comparator;

@RestController
@RequestMapping("/v1/Listado")
@RequiredArgsConstructor
public class ListadoController {

    private final ListadoService listadoService;

    @Autowired
    ListadoRepository listadoRepository;

    @CrossOrigin(origins = "*")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<ListadoResponseDto> findAll(){

        return this.listadoService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public Flux<vista_adolescente_detalle> getLegalGuardian() {
        return listadoRepository.findAll()
                .sort(Comparator.comparing(vista_adolescente_detalle::getAdolescenteId));
    }
}
