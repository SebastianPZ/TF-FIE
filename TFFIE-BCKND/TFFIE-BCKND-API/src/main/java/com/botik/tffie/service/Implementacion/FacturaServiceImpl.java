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

    private FacturaRepository facturaRepository;

    @Autowired
    public FacturaServiceImpl(FacturaRepository facturaRepository){
        this.facturaRepository = facturaRepository;
    }

    @Override
    public Factura ingresarFactura(Factura f) throws Exception{
        f.setDias(0);
        f.setTasaEfectivaFactura(0);
        f.setTasaDescontada(0);
        f.setDescuento(0);
        f.setTotalCostoInicial(0);
        f.setTotalCostoFinal(0);
        f.setValorNeto(0);
        f.setValorRecibido(0);
        f.setValorEntregado(0);
        f.setTcea(0);
        return facturaRepository.save(f);
    }

    @Override
    public int calcularFactura(Factura f) throws Exception{
        //Total Facturado
        double tf = f.getTotalFacturado();
        //Dias anio
        double diasanio = (double)f.getCartera().getTasa().getDiasAnio();

        //Numero de dias
        int numDias =  (int)((f.getFechaPago().getTime() - f.getCartera().getTasa().getFechaDescuento().getTime())/86400000);
        double te = Math.pow(1 + (f.getCartera().getTasa().getValor()/100), numDias/diasanio) - 1;
        double td = te/(1 + te);
        //Descuento
        double desct = Math.rint(td * tf * 100)/100;
        //Total Costo Inicial
        double tci = 0;
        ArrayList<CostoInicial> costosIniciales = new ArrayList<CostoInicial>();
        costosIniciales = (ArrayList<CostoInicial>) facturaRepository.listarCostosInicialesDeFactura(f.getId());

        for (CostoInicial data : costosIniciales) {
            tci += data.getMontoCI();
        }
        //Total Costo Final
        double tcf = 0;
        ArrayList<CostoFinal> costosFinales = new ArrayList<CostoFinal>();
        costosFinales = (ArrayList<CostoFinal>) facturaRepository.listarCostosFinalesDeFactura(f.getId());

        for (CostoFinal data : costosFinales) {
            tcf += data.getMontoCF();
        }
        //Valor Neto
        double vn = f.getTotalFacturado() - desct;
        //Valor Recibido
        double vr = vn - f.getRetencion() - tci;
        //Valor Entregado
        double ve = f.getTotalFacturado() + tcf - f.getRetencion();
        //TCEA
        double tcea = Math.pow((ve/vr), (diasanio/numDias)) - 1;


        facturaRepository.actualizarDias(numDias, f.getId());
        facturaRepository.actualizarTasaEfectivaFactura(Math.rint(te*1000000000)/10000000, f.getId());
        facturaRepository.actualizarTasaDescontada(Math.rint(td*1000000000)/10000000, f.getId());
        facturaRepository.actualizarDescuento(desct, f.getId());
        facturaRepository.actualizarTotalCostoInicial(tci, f.getId());
        facturaRepository.actualizarTotalCostoFinal(tcf, f.getId());
        facturaRepository.actualizarValorNeto(vn, f.getId());
        facturaRepository.actualizarValorRecibido(vr, f.getId());
        facturaRepository.actualizarValorEntregado(ve, f.getId());
        facturaRepository.actualizarTcea(Math.rint(tcea*1000000000)/10000000, f.getId());

        return 1;
    }

    @Override
    public List<Factura> listarFacturas() throws Exception{
        return facturaRepository.findAll();
    }

    @Override
    public List<CostoInicial> listarCostosInicialesDeFactura(Integer id) throws Exception{
        return facturaRepository.listarCostosInicialesDeFactura(id);
    }

    @Override
    public List<CostoFinal> listarCostosFinalesDeFactura(Integer id) throws Exception{
        return facturaRepository.listarCostosFinalesDeFactura(id);
    }


}
