package com.botik.tffie.repository;

import com.botik.tffie.model.Tasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasaRepository extends JpaRepository<Tasa, Integer> {
}
