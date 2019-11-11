package com.botik.tffie.controller;

import com.botik.tffie.model.Cartera;
import com.botik.tffie.model.Factura;
import com.botik.tffie.service.CarteraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carteras")
public class CarteraController {

    private CarteraService carteraService;

    @Autowired
    public CarteraController(CarteraService carteraService) { this.carteraService = carteraService; }

    @RequestMapping(path="/ingresar", method = RequestMethod.POST)
    public Cartera registrarCartera(@RequestBody Cartera cartera) throws Exception {
        return carteraService.ingresarCartera(cartera);
    }

    @RequestMapping
    public List<Cartera> listarCarteras() throws Exception
    {
        return carteraService.listarCarteras();
    }

    @RequestMapping(path="/calcular", method = RequestMethod.PUT)
    public int calcularCartera(@RequestBody Cartera cartera) throws Exception
    {
        return carteraService.calcularCartera(cartera);
    }

    @RequestMapping(path = "/facturas/{id}", method = RequestMethod.GET)
    public List<Factura> listarFacturasdeCartera(@PathVariable Integer id) throws Exception
    {
        return carteraService.listarFacturasDeCartera(id);
    }


}
