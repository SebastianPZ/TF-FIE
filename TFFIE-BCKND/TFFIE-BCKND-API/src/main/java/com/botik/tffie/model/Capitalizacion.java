package com.botik.tffie.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "capitalizacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Capitalizacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "capitalizacionId")
    private Integer id;

    @Column (name="nCapitalizacion", length = 50, nullable = false)
    private String nombre;

    @Column (name="dias", nullable = false)
    private Integer dias;
}
