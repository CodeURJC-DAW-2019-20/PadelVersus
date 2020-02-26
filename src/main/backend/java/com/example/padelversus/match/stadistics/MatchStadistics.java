package com.example.padelversus.match.stadistics;

import com.example.padelversus.tournament.Tournament;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;

@Entity
public class MatchStadistics {
    public interface Basic{}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(Basic.class)
    private int acurracy;

    @JsonView(Basic.class)
    private int effectiveness;

    @JsonView(Basic.class)
    private int games_wins;

    @JsonView(Basic.class)
    private int unforcedErrors;

    @JsonView(Basic.class)
    private boolean win;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<SetPadel> sets; //Sets with their games on each set

    public MatchStadistics() {
    }

    public MatchStadistics(List<SetPadel> sets, int acurracy, int effectiveness, int wins, int unforcedErrors, boolean win) {
        super();
        this.acurracy = acurracy;
        this.effectiveness = effectiveness;
        this.unforcedErrors = unforcedErrors;
        this.win = win;
        this.sets = sets;
        this.games_wins = 0;
        for (SetPadel s : sets) { //For each set of the teamx it adds the games won of this set to the total
            this.games_wins += s.getGames();
        }
    }

    @Override
    public String toString() {
        return "MatchStadistics{" +
                "id=" + id +
                ", acurracy=" + acurracy +
                ", effectiveness=" + effectiveness +
                ", games_wins=" + games_wins +
                ", unforcedErrors=" + unforcedErrors +
                ", win=" + win +
                '}';
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAcurracy() {
        return acurracy;
    }

    public void setAcurracy(int acurracy) {
        this.acurracy = acurracy;
    }

    public int getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(int effectiveness) {
        this.effectiveness = effectiveness;
    }

    public int getGames_wins() {
        return games_wins;
    }

    public void setGames_wins(int games_wins) {
        this.games_wins = games_wins;
    }

    public int getUnforcedErrors() {
        return unforcedErrors;
    }

    public void setUnforcedErrors(int unforcedErrors) {
        this.unforcedErrors = unforcedErrors;
    }

    public List<SetPadel> getSets() {
        return sets;
    }

    public void setSets(List<SetPadel> sets) {
        this.sets = sets;
    }
}
