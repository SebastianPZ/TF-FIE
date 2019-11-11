package com.botik.tffie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "plazoTasa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlazoTasa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "plazoTasaId")
    private Integer id;

    @Column (name="nPlazoTasa", length = 50, nullable = false)
    private String nombre;

    @Column (name="numDias", length = 50 , nullable = false )
    private int numDias;

}
