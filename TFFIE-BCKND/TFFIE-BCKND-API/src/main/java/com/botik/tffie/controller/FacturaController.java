package com.botik.tffie.controller;


import com.botik.tffie.model.Factura;
import com.botik.tffie.model.Usuario;
import com.botik.tffie.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService){
        this.facturaService = facturaService;
    }


    @RequestMapping(path="/ingresar", method = RequestMethod.POST)
    public Factura registrarFactura(@RequestBody Factura factura) throws Exception {
        return facturaService.ingresarFactura(factura);
    }

    @RequestMapping
    public List<Factura> listarFacturas() throws Exception
    {
        return facturaService.listarFacturas();
    }

    @RequestMapping(path="/calcular", method = RequestMethod.PUT)
    public int calcularFactura(@RequestBody Factura factura) throws Exception
    {
        return facturaService.calcularFactura(factura);
    }
}
