package com.botik.tffie.service;

import com.botik.tffie.model.CostoFinal;
import com.botik.tffie.model.CostoInicial;
import com.botik.tffie.model.Factura;

import java.util.Date;
import java.util.List;

public interface FacturaService {

    int calcularNumDias(Factura f) throws Exception;
    Factura ingresarFactura(Factura f) throws Exception;
    float calcularTasaEfectivaFactura(Factura f) throws Exception;
    float calcularTasaDescontada(Factura f) throws Exception;
    float calcularDescuento(Factura f) throws Exception;
    float calcularTotalCostoInicial(Factura f) throws Exception;
    float calcularTotalCostoFinal(Factura f) throws Exception;
    List<CostoInicial> listarCostosInicialesDeFactura(Integer id) throws Exception;
    List<CostoFinal> listarCostosFinalesDeFactura(Integer id) throws Exception;
    float calcularValorNeto(Factura f) throws Exception;
    float calcularValorRecibido(Factura f) throws Exception;
    float calcularValorEntregado(Factura f) throws Exception;
    float calcularTceaDeFactura(Factura f) throws Exception;

}
