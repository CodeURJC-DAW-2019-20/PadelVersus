package com.example.padelversus.Player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private  String email;
    private int edad;
    private double altura;
    private double peso;
    private String password;
    private String equipo;
    private double velocidad;
    private double fuerza;
    private Byte imagen;

    public Player() {
    }

    public Player (String username, String email,int edad,double altura,double peso, String password,String equipo,double velocidad,double fuerza, Byte imagen){
        this.username = username;
        this.email = email;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.password = password;
        this.equipo = equipo;
        this.velocidad = velocidad;
        this.fuerza = fuerza;
        this.imagen = imagen;
    }


}
