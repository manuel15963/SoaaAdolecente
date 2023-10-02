package com.example.MsAdolescente.repository;

import com.example.MsAdolescente.domain.model.Adolescente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface AdolescenteRepository extends ReactiveCrudRepository<Adolescente,Integer> {

}


