package com.example.MsAdolescente.repository;

import com.example.MsAdolescente.domain.model.vista_adolescente_detalle;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ListadoRepository extends ReactiveCrudRepository<vista_adolescente_detalle,Long> {

}
