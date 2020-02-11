package com.example.padelversus.Team;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private long id;

    private String nombre;

    public Team(){
    }

    public Team(String nombre){
        super();
        this.nombre = nombre;
    }
}
