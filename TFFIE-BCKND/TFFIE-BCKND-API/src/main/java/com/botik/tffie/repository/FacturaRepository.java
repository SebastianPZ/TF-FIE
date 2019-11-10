package com.botik.tffie.repository;

import com.botik.tffie.model.CostoFinal;
import com.botik.tffie.model.CostoInicial;
import com.botik.tffie.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    @Query("SELECT c FROM CostoInicial c JOIN Factura f ON f.id = c.facturaCI.id  WHERE f.id = ?1")
    List<CostoInicial> listarCostosInicialesDeFactura(Integer id) throws Exception;

    @Query("SELECT c FROM CostoFinal c JOIN Factura f ON f.id = c.facturaCF.id  WHERE f.id = ?1")
    List<CostoFinal> listarCostosFinalesDeFactura(Integer id) throws Exception;
}
