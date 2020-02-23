package com.example.padelversus.user;

import com.example.padelversus.player.Player;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String passwordHash;

    @NotNull
    private String mail;

    @ElementCollection(fetch = FetchType.EAGER) //EAGER because the user is taken with the roles from the database
    private List<String> roles;   //Role ROLE_ADMIN/ ROLE_USER...

    @OneToOne(mappedBy = "user")
    private Player player;

    public User() {
    }

    public User(String name, String password, String mail, String... roles) {
        this.name = name;
        this.passwordHash = new BCryptPasswordEncoder().encode(password);
        this.mail = mail;
        this.roles = new ArrayList<>(Arrays.asList(roles));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        this.passwordHash = new BCryptPasswordEncoder().encode(password);
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setRol(String rol) {
        if (roles == null) {
            roles = new ArrayList<>();
        }
        this.roles.add(rol);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", mail='" + mail + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}