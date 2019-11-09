package com.botik.tffie.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@Table(name = "tasa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tasa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "tasaId")
    private Integer id;

    @Column (name="fechaDescuento", nullable = false)
    private Date fechaDescuento;

    @Column (name="valor", nullable = false)
    private float valor;

    @Column (name="diasAnio", nullable = false)
    private float diasAnio;

    @ManyToOne
    @JoinColumn(name = "tipoTasa")
    private TipoTasa tipoTasa;

    @ManyToOne
    @JoinColumn(name = "plazoTasa")
    private PlazoTasa plazoTasa;
}
