package com.botik.tffie.repository;

import com.botik.tffie.model.Cartera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteraRepository extends JpaRepository<Cartera, Integer> {
}
