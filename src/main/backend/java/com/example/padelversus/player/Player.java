package com.example.padelversus.player;

import com.example.padelversus.user.User;
import com.fasterxml.jackson.annotation.JsonView;

import javax.imageio.ImageIO;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

@Entity
public class Player {

    public interface Basic{}
    public interface MinInfo{}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonView({Basic.class, MinInfo.class})
    private int age;
    @JsonView({Basic.class, MinInfo.class})
    private String countryBirth;

    @JsonView({Basic.class})
    private double height;
    @JsonView({Basic.class})
    private double weight;
    @JsonView({Basic.class})
    private double speed;
    @JsonView({Basic.class})
    private double strength;
    @JsonView({Basic.class})
    private double endurance;
    @JsonView({Basic.class})
    private double pace;
    @JsonView({Basic.class})
    private double accuaracy;
    @JsonView({Basic.class})
    private double aceleration;
    @JsonView({Basic.class, MinInfo.class})
    private String imageUrl;

    @Lob
    private byte[] image;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountryBirth() {
        return countryBirth;
    }

    public void setCountryBirth(String countryBirth) {
        this.countryBirth = countryBirth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BufferedImage getBufferedImage() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.image);
        BufferedImage imageBuffered = ImageIO.read(byteArrayInputStream);
        return imageBuffered;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String image_url) {
        this.imageUrl = image_url;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", age=" + age +
                ", countryBirth='" + countryBirth + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", speed=" + speed +
                ", strength=" + strength +
                ", endurance=" + endurance +
                ", pace=" + pace +
                ", accuaracy=" + accuaracy +
                ", aceleration=" + aceleration +
                ", image=" + Arrays.toString(image) +
                ", user=" + user +
                '}';
    }


}
