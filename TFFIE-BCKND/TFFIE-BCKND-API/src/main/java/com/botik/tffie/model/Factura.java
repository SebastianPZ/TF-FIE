package com.botik.tffie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "facturaId")
    private Integer id;

    @Column (name="fechaEmision", nullable = false)
    private Date fechaEmision;

    @Column (name="fechaPago", nullable = false)
    private Date fechaPago;

    @Column (name="totalFacturado", nullable = false)
    private double totalFacturado;

    @Column (name="retencion", nullable = false)
    private double retencion;

    @ManyToOne
    @JoinColumn(name = "cartera")
    private Cartera cartera;

    @Column (name="tcea", nullable = false)
    private double tcea;

    @Column (name="valorNeto", nullable = false)
    private double valorNeto;

    @Column (name="valorRecibido", nullable = false)
    private double valorRecibido;

    @Column (name="valorEntregado", nullable = false)
    private double valorEntregado;

    @Column (name="dias", nullable = false)
    private int dias;

    @Column (name="descuento", nullable = false)
    private double descuento;

    @Column (name="totalCostoInicial", nullable = false)
    private double totalCostoInicial;

    @Column (name="totalCostoFinal", nullable = false)
    private double totalCostoFinal;

    @Column (name="tasaDescontada", nullable = false)
    private double tasaDescontada;

    @Column (name="tasaEfectivaFactura", nullable = false)
    private double tasaEfectivaFactura;
}
