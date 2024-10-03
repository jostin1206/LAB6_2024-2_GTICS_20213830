package com.example.lab6.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "eventos")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventoId")
    private int id;

    @Column(name = "nombre" , nullable = false)
    @Size(max = 100,min = 3,message = "El campo solo debe tener entre 3 y 100 caracteres")
    @NotBlank
    private String nombre;


    @Column(name = "fecha")
    @Future(message = "La fecha del evento debe ser una fecha futura")
    private LocalDate fecha;


    @Column(name = "asistentesEsperados")
    @Positive (message = "El número de asistentes debe ser un número positivo")
    private int asistentesEsperados;
}
