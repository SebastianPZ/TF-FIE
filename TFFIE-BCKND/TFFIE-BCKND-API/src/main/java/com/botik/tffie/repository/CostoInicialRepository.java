package com.botik.tffie.repository;

import com.botik.tffie.model.CostoInicial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoInicialRepository extends JpaRepository<CostoInicial, Integer> {
}
