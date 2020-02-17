package com.example.padelversus.match.Stadistics;

import com.example.padelversus.team.teamstatistics.game.Game;

import javax.persistence.*;
import java.util.List;

@Entity
public class SetPadel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int games;

    private int setNumber;

    public SetPadel() {
    }

    public SetPadel(int games, int setNumber){
        super();
        this.games = games;
        this.setNumber = setNumber;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }
}
