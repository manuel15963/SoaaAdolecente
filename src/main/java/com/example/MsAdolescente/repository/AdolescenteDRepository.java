package com.example.MsAdolescente.repository;

import com.example.MsAdolescente.domain.model.AdolescenteD;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdolescenteDRepository extends ReactiveCrudRepository<AdolescenteD,Integer> {
}
