package com.botik.tffie.repository;

import com.botik.tffie.model.TipoTasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTasaRepository extends JpaRepository<TipoTasa, Integer> {
}
