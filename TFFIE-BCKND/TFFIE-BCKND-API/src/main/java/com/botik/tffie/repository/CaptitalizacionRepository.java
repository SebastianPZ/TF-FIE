package com.botik.tffie.repository;

import com.botik.tffie.model.Capitalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptitalizacionRepository extends JpaRepository<Capitalizacion, Integer> {
}
