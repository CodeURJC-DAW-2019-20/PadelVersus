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
    private int age;
    private double height;
    private double weight;
    private String password;
    private String team;
    private double speed;
    private double strength;
    private Byte image;
    private String countryBirth;

    public Player() {
    }


    public Player (String username, String email, int age, double height, double weight, String password, String team, double speed, double strength, String  countryBirth) {
        super();
        this.username = username;
        this.email = email;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.password = password;
        this.team = team;
        this.speed = speed;
        this.strength = strength;
        this.countryBirth =  countryBirth;
        ;
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

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getPassword() {
        return password;
    }

    public String getTeam() {
        return team;
    }

    public double getSpeed() {
        return speed;
    }

    public double getStrength() {
        return strength;
    }

    public Byte getImage() {
        return image;
    }

    public String getCountryBirth() {
        return countryBirth;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public void setImage(Byte imagen) {
        this.image = imagen;
    }

    public void setCountryBirth(String countryBirth) {
        this.countryBirth = countryBirth;
    }
}
