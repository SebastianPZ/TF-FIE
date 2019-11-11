package com.botik.tffie.repository;

import com.botik.tffie.model.Cartera;
import com.botik.tffie.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CarteraRepository extends JpaRepository<Cartera, Integer> {

    @Query("SELECT f FROM Cartera c JOIN Factura f ON c.id = f.cartera  WHERE c.id = ?1")
    List<Factura> listarFacturasDeCartera(Integer id) throws Exception;

    @Modifying
    @Query("UPDATE Cartera c SET c.tir = :tir WHERE c.id = :id")
    @Transactional
    int actualizarTir(@Param("tir") double tir, @Param("id") Integer id) throws Exception;

    @Modifying
    @Query("UPDATE Cartera c SET c.valorRecibido = :vtr WHERE c.id = :id")
    @Transactional
    int actualizarValorTotalRecibir(@Param("vtr") double vtr, @Param("id") Integer id) throws Exception;

    @Modifying
    @Query("UPDATE Cartera c SET c.tcea = :tcea WHERE c.id = :id")
    @Transactional
    int actualizarTcea(@Param("tcea") double tcea, @Param("id") Integer id) throws Exception;

}
