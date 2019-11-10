package com.botik.tffie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "costoFinal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CostoFinal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "costoFinalId")
    private Integer id;

    @Column (name="motivo", length = 50, nullable = false)
    private String motivoCF;

    @Column (name="monto", length = 50, nullable = false)
    private float montoCF;

    @ManyToOne
    @JoinColumn(name = "factura")
    private Factura facturaCF;
}
