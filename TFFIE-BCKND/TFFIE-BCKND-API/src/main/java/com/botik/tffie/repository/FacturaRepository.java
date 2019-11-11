package com.botik.tffie.repository;

import com.botik.tffie.model.CostoFinal;
import com.botik.tffie.model.CostoInicial;
import com.botik.tffie.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    @Query("SELECT c FROM CostoInicial c JOIN Factura f ON f.id = c.facturaCI.id  WHERE f.id = ?1")
    List<CostoInicial> listarCostosInicialesDeFactura(Integer id) throws Exception;

    @Query("SELECT c FROM CostoFinal c JOIN Factura f ON f.id = c.facturaCF.id  WHERE f.id = ?1")
    List<CostoFinal> listarCostosFinalesDeFactura(Integer id) throws Exception;

    @Modifying
    @Query("UPDATE Factura f SET f.dias = :dias WHERE f.id = :id")
    @Transactional
    int actualizarDias(@Param("dias") int dias, @Param("id") Integer id) throws Exception;

    @Modifying
    @Query("UPDATE Factura f SET f.tasaEfectivaFactura = :tef WHERE f.id = :id")
    @Transactional
    int actualizarTasaEfectivaFactura(@Param("tef") double tef, @Param("id") Integer id) throws Exception;

    @Modifying
    @Query("UPDATE Factura f SET f.tasaDescontada = :td WHERE f.id = :id")
    @Transactional
    int actualizarTasaDescontada(@Param("td") double td, @Param("id") Integer id) throws Exception;

    @Modifying
    @Query("UPDATE Factura f SET f.descuento = :d WHERE f.id = :id")
    @Transactional
    int actualizarDescuento(@Param("d") double d, @Param("id") Integer id) throws Exception;

    @Modifying
    @Query("UPDATE Factura f SET f.totalCostoInicial = :tci WHERE f.id = :id")
    @Transactional
    int actualizarTotalCostoInicial(@Param("tci") double tci, @Param("id") Integer id) throws Exception;


    @Modifying
    @Query("UPDATE Factura f SET f.totalCostoFinal = :tcf WHERE f.id = :id")
    @Transactional
    int actualizarTotalCostoFinal(@Param("tcf") double tcf, @Param("id") Integer id) throws Exception;

    @Modifying
    @Query("UPDATE Factura f SET f.valorNeto = :vn WHERE f.id = :id")
    @Transactional
    int actualizarValorNeto(@Param("vn") double vn, @Param("id") Integer id) throws Exception;

    @Modifying
    @Query("UPDATE Factura f SET f.valorRecibido = :valor WHERE f.id = :id")
    @Transactional
    int actualizarValorRecibido(@Param("valor") double valor, @Param("id") Integer id) throws Exception;

    @Modifying
    @Query("UPDATE Factura f SET f.valorEntregado = :ve WHERE f.id = :id")
    @Transactional
    int actualizarValorEntregado(@Param("ve") double ve, @Param("id") Integer id) throws Exception;

    @Modifying
    @Query("UPDATE Factura f SET f.tcea = :tcea WHERE f.id = :id")
    @Transactional
    int actualizarTcea(@Param("tcea") double tcea, @Param("id") Integer id) throws Exception;

}
