package com.example.padelversus.match.stadistics;

import com.example.padelversus.tournament.Tournament;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SetPadel {
    public interface Basic{}
    @Id
    @JsonView(Basic.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(Basic.class)
    private int games;

    @JsonView(Basic.class)
    private int setNumber;

    public SetPadel() {
    }

    public SetPadel(int games, int setNumber) {
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
