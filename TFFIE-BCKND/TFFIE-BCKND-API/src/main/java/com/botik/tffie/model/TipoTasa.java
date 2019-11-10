package com.botik.tffie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipoTasa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoTasa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "tipoTasaId")
    private Integer id;

    @Column (name="nTipoTasa", length = 50, nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "capitalizacion")
    private Capitalizacion capitalizacion;

}
