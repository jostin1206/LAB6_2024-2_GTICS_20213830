package com.example.lab6.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "artistas")
public class Artistas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artistaId")
    private int id;

    @Column(name = "nombre" , nullable = false)
    @Size(max = 100,min = 2,message = "El campo solo debe tener entre 2 y 100 caracteres")
    @NotBlank
    private String nombre;

    @Column(name = "genero")
    private String genero;

    @Column(name = "telefono")
    private String telefono;
}
