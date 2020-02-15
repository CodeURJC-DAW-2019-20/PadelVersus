package com.example.padelversus.player;

import com.example.padelversus.user.User;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int age;
    private Byte image;
    private String countryBirth;


    private double height;
    private double weight;
    private double speed;
    private double strength;
    private double endurance;
    private double pace;
    private double accuaracy;
    private double aceleration;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Player() {
    }

    public Player(int age, double height, double weight, double speed, double strength, double endurance, double pace, double accuaracy, double aceleration, String countryBirth) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
        this.strength = strength;
        this.endurance = endurance;
        this.pace = pace;
        this.accuaracy = accuaracy;
        this.aceleration = aceleration;
        this.countryBirth = countryBirth;
    }



    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", speed=" + speed +
                ", aceleration=" + aceleration +
                ", accuaracy=" + accuaracy +
                ", pace=" + pace +
                ", endurance=" + endurance +
                ", strength=" + strength +
                ", image=" + image +
                ", countryBirth='" + countryBirth + '\'' +

                '}';
    }




    public Long getId() {
        return id;
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


    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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
    public double getEndurance() {
        return endurance;
    }

    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    public double getPace() {
        return pace;
    }

    public void setPace(double pace) {
        this.pace = pace;
    }

    public double getAccuaracy() {
        return accuaracy;
    }

    public void setAccuaracy(double accuaracy) {
        this.accuaracy = accuaracy;
    }

    public double getAceleration() {
        return aceleration;
    }

    public void setAceleration(double aceleration) {
        this.aceleration = aceleration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
