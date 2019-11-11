package com.botik.tffie.service;

import com.botik.tffie.model.Cartera;
import com.botik.tffie.model.Factura;

import java.util.List;

public interface CarteraService {

    Cartera ingresarCartera(Cartera c) throws Exception;
    int calcularCartera(Cartera c) throws Exception;
    List<Cartera> listarCarteras() throws Exception;
    List<Factura> listarFacturasDeCartera(Integer id) throws Exception;
}
