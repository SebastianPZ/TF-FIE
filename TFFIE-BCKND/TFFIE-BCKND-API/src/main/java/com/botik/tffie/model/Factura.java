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
    private float totalFacturado;

    @Column (name="retencion", nullable = false)
    private float retencion;

    @ManyToOne
    @JoinColumn(name = "cartera")
    private Cartera cartera;

    @Column (name="tcea", nullable = false)
    private float tcea;

    @Column (name="valorNeto", nullable = false)
    private float valorNeto;

    @Column (name="valorREcibido", nullable = false)
    private float valorREcibido;

    @Column (name="valorEntregado", nullable = false)
    private float valorEntregado;

    @Column (name="dias", nullable = false)
    private float dias;

    @Column (name="descuento", nullable = false)
    private float descuento;

    @Column (name="totalCostoInicial", nullable = false)
    private float totalCostoInicial;

    @Column (name="totalCostoFinal", nullable = false)
    private float totalCostoFinal;

    @Column (name="tasaDescontada", nullable = false)
    private float tasaDescontada;

    @Column (name="tasaEfectivaFactura", nullable = false)
    private float tasaEfectivaFactura;
}
