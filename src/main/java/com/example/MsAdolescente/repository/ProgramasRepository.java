package com.example.MsAdolescente.repository;

import com.example.MsAdolescente.domain.model.Programas;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramasRepository extends ReactiveCrudRepository<Programas,Integer> {
}
