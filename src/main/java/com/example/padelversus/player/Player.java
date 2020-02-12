package com.example.padelversus.player;

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
    private String paisNacimiento;

    public Player() {
    }

    //FaltaAñadirImagenContructor
    public Player (String username, String email,int edad,double altura,double peso, String password,String equipo,double velocidad,double fuerza,String pais){
        this.username = username;
        this.email = email;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.password = password;
        this.equipo = equipo;
        this.velocidad = velocidad;
        this.fuerza = fuerza;
        this.paisNacimiento = pais;
        //this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public String getPassword() {
        return password;
    }

    public String getEquipo() {
        return equipo;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getFuerza() {
        return fuerza;
    }

    public Byte getImagen() {
        return imagen;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    public void setImagen(Byte imagen) {
        this.imagen = imagen;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }
}
