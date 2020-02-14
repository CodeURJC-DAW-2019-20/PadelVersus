package com.example.padelversus.match.Stadistics;

import com.example.padelversus.team.teamstatistics.game.Game;

import javax.persistence.*;
import java.util.List;

@Entity
public class MatchStadistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int acurracy;
    private int effectiveness;
    private int games_wins;
    private int unforcedErrors;
    private boolean win;

    @OneToMany (cascade = CascadeType.ALL)
    private List<SetPadel> sets; //Sets with their games on each set

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

    public MatchStadistics() {
    }
    public MatchStadistics(List<SetPadel> sets, int acurracy,int effectiveness,int wins,int unforcedErrors,boolean win) {
        super();
        this.acurracy=acurracy;
        this.effectiveness=effectiveness;
        this.unforcedErrors=unforcedErrors;
        this.win=win;
        this.sets=sets;
        this.games_wins = 0;
        for(SetPadel s: sets){ //For each set of the teamx it adds the games won of this set to the total
            for(Game g: (SetPadel) s) {
                this.games_wins += g.getGames();
            }
        }
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

    public List<Game> getSets() {
        return sets;
    }

    public void setSets(List<Game> sets) {
        this.sets = sets;
    }
}
