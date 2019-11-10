package com.botik.tffie.service.Implementacion;

import com.botik.tffie.model.CostoFinal;
import com.botik.tffie.model.CostoInicial;
import com.botik.tffie.model.Factura;
import com.botik.tffie.repository.FacturaRepository;
import com.botik.tffie.service.FacturaService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    FacturaRepository facturaRepository;

    @Autowired
    public FacturaServiceImpl(FacturaRepository facturaRepository){
        this.facturaRepository = facturaRepository;
    }

    @Override
    public Factura ingresarFactura(Factura f) throws Exception{
        f.setDias(calcularNumDias(f));
        f.setTasaEfectivaFactura(calcularTasaEfectivaFactura(f));
        f.setTasaDescontada(calcularTasaDescontada(f));
        f.setDescuento(calcularDescuento(f));
        f.setTotalCostoInicial(calcularTotalCostoInicial(f));
        f.setTotalCostoFinal(calcularTotalCostoFinal(f));
        f.setValorNeto(calcularValorNeto(f));
        f.setValorREcibido(calcularValorRecibido(f));
        f.setValorEntregado(calcularValorEntregado(f));
        f.setTcea(calcularTceaDeFactura(f));
        return facturaRepository.save(f);
    }

    @Override
    public List<CostoInicial> listarCostosInicialesDeFactura(Integer id) throws Exception{
        return facturaRepository.listarCostosInicialesDeFactura(id);
    }

    @Override
    public List<CostoFinal> listarCostosFinalesDeFactura(Integer id) throws Exception{
        return facturaRepository.listarCostosFinalesDeFactura(id);
    }


    //METODOS PARA CALCULAR VALORES

   //Numero de dias efectivo entre fecha de pago y fecha de descuento
    @Override
    public int calcularNumDias(Factura f) throws Exception{
        int numDias = 0;
        numDias =  (int) ((f.getFechaPago().getTime() - f.getCartera().getTasa().getFechaDescuento().getTime())/86400000);
        return numDias;
    }

    //Tasa efectiva del periodo
    @Override
    public float calcularTasaEfectivaFactura(Factura f) throws Exception{
        float te = 0;
        te = (float) Math.pow((1 + (f.getCartera().getTasa().getValor()/100)), (f.getDias()/f.getCartera().getTasa().getDiasAnio())) -1;
        return te;
    }

    //Tasa descontada del periodo
    @Override
    public float calcularTasaDescontada(Factura f) throws Exception{
        float td = 0;
        td = (float) f.getTasaEfectivaFactura()/(1 + f.getTasaEfectivaFactura());
        return td;
    }

    //Descuento total
    @Override
    public float calcularDescuento(Factura f) throws Exception{
        float desct = 0;
        desct = Math.round(f.getTasaDescontada() * f.getTotalFacturado()) * 100 / 100;
        return desct;
    }

    //Total Costo Inicial
    @Override
    public float calcularTotalCostoInicial(Factura f) throws Exception{
        float tci = 0;
        ArrayList<CostoInicial> costosIniciales = new ArrayList<CostoInicial>();
        costosIniciales = (ArrayList<CostoInicial>) facturaRepository.listarCostosInicialesDeFactura(f.getId());

        for (CostoInicial data : costosIniciales) {
            tci += data.getMontoCI();
        }
        return tci;
    }

    //Total Costo Final
    @Override
    public float calcularTotalCostoFinal(Factura f) throws Exception{
        float tci = 0;
        ArrayList<CostoFinal> costosFinales = new ArrayList<CostoFinal>();
        costosFinales = (ArrayList<CostoFinal>) facturaRepository.listarCostosFinalesDeFactura(f.getId());

        for (CostoFinal data : costosFinales) {
            tci += data.getMontoCF();
        }
        return tci;
    }


    //Valor neto
    @Override
    public float calcularValorNeto(Factura f) throws Exception{
        float vn = 0;
        vn = f.getTotalFacturado() - f.getDescuento();
        return vn;
    }

    //Valor recibido
    @Override
    public float calcularValorRecibido(Factura f) throws Exception{
        float vr = 0;
        vr = f.getValorNeto() - f.getRetencion() - f.getTotalCostoInicial();
        return vr;
    }

    //Valor entregado
    @Override
    public float calcularValorEntregado(Factura f) throws Exception{
        float ve = 0;
        ve = f.getTotalFacturado() + f.getTotalCostoFinal() - f.getRetencion();
        return ve;
    }

    //TCEA de Factura
    @Override
    public float calcularTceaDeFactura(Factura f) throws Exception{
        float tcea = 0;
        tcea = (float) Math.pow((f.getValorEntregado()/f.getValorREcibido()), (f.getCartera().getTasa().getDiasAnio()/f.getDias())) - 1;
        return tcea;
    }
}
