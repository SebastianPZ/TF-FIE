package com.botik.tffie.repository;

import com.botik.tffie.model.PlazoTasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlazoTasaRepository extends JpaRepository<PlazoTasa, Integer> {
}
