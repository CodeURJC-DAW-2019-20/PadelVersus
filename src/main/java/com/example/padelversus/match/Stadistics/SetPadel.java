package com.example.padelversus.match.Stadistics;

import com.example.padelversus.team.teamstatistics.game.Game;

import javax.persistence.*;
import java.util.List;

@Entity
public class SetPadel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany
    List<Game> games; //Games won by one team in this set

    public SetPadel() {
    }

    public SetPadel(List<Game> games){
        super();
        this.games = games;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
