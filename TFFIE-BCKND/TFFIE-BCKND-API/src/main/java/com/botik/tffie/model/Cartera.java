package com.botik.tffie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cartera")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cartera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "carteraId")
    private Integer id;

    @Column (name="valorEntregado", length = 50, nullable = false)
    private float valorEntregado;

    @Column (name="valorRecibido", length = 50, nullable = false)
    private float valorRecibido;

    @Column (name="descuentoxDias", length = 50, nullable = false)
    private float descuentoxDias;

    @Column (name="valorNeto", length = 50, nullable = false)
    private float valorNeto;

    @Column (name="tcea", length = 50, nullable = false)
    private float tcea;

    @Column (name="tir", length = 50, nullable = false)
    private float tir;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "tasa")
    private Tasa tasa;
}
