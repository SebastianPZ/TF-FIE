package com.botik.tffie.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "costoInicial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CostoInicial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "costoInicialId")
    private Integer id;

    @Column (name="motivo", length = 50, nullable = false)
    private String motivoCI;

    @Column (name="monto", length = 50, nullable = false)
    private float montoCI;

    @ManyToOne
    @JoinColumn(name = "factura")
    private Factura facturaCI;
}
