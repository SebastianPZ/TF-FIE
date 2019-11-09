package com.botik.tffie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "usuarioId")
    private Integer id;

    @Column (name="nombres", length = 50, nullable = false)
    private String nombres;

    @Column (name="apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column (name="correo", length = 50, nullable = false)
    private String correo;

    @Column (name="contrasenia", length = 50, nullable = false)
    private String contrasenia;

}
