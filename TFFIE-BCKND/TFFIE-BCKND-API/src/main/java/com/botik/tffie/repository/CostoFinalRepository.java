package com.botik.tffie.repository;

import com.botik.tffie.model.CostoFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoFinalRepository extends JpaRepository<CostoFinal, Integer> {
}
