package com.botik.tffie.service;

import com.botik.tffie.model.CostoFinal;
import com.botik.tffie.model.CostoInicial;
import com.botik.tffie.model.Factura;

import java.util.Date;
import java.util.List;

public interface FacturaService {

    Factura ingresarFactura(Factura f) throws Exception;
    int calcularFactura(Factura f) throws Exception;
    List<Factura> listarFacturas() throws Exception;
    List<CostoInicial> listarCostosInicialesDeFactura(Integer id) throws Exception;
    List<CostoFinal> listarCostosFinalesDeFactura(Integer id) throws Exception;


}
