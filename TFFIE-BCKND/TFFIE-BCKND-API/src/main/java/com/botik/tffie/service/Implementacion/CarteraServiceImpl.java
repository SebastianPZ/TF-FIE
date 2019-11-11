package com.botik.tffie.service.Implementacion;

import com.botik.tffie.model.Cartera;
import com.botik.tffie.model.Factura;
import com.botik.tffie.repository.CarteraRepository;
import com.botik.tffie.service.CarteraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarteraServiceImpl implements CarteraService {

    private CarteraRepository carteraRepository;

    @Autowired
    public CarteraServiceImpl(CarteraRepository carteraRepository){
        this.carteraRepository = carteraRepository;
    }

    @Override
    public Cartera ingresarCartera(Cartera c) throws Exception{
        c.setDescuentoxDias(0);
        c.setTcea(0);
        c.setTir(0);
        c.setValorEntregado(0);
        c.setValorNeto(0);
        c.setValorRecibido(0);
        return carteraRepository.save(c);
    }

    @Override
    public int calcularCartera(Cartera ca) throws Exception{

        double tir = 25;
        double tcea = 30;

        ArrayList<Factura> facturas = new ArrayList<Factura>();
        facturas = (ArrayList<Factura>) carteraRepository.listarFacturasDeCartera(ca.getId());

        double suma_vr = 0;

        for (Factura data : facturas) {
            suma_vr += data.getValorRecibido();
        }

        int F = 1;
        double a = 0;
        double b = 0.8;

        for( int k = 0; k < 1000; k++){
            double valc = 0;
            double c = (a + b) / 2;
            for(Factura data1 : facturas){
                valc += data1.getValorEntregado()/Math.pow(1 + c, data1.getDias());
            }
            if (valc < suma_vr){
                b = c;
            }else{
                a = c;
            }

            if( Math.abs(valc - suma_vr) < 0.001){
                tir = c;
                tcea = Math.pow( 1 + tir, ca.getTasa().getDiasAnio()) - 1;
                k = 1000;
            }
        }

        carteraRepository.actualizarValorTotalRecibir(suma_vr, ca.getId());
        carteraRepository.actualizarTir(tir*100, ca.getId());
        carteraRepository.actualizarTcea(tcea*100, ca.getId());

        return 1;
    }

    @Override
    public List<Cartera> listarCarteras() throws Exception{
        return carteraRepository.findAll();
    }

    @Override
    public List<Factura> listarFacturasDeCartera(Integer id) throws Exception{
        return carteraRepository.listarFacturasDeCartera(id);
    }
}
