package com.example.padelversus.match;

import com.example.padelversus.match.Stadistics.MatchStadistics;
import com.example.padelversus.match.Stadistics.SetPadel;
import com.example.padelversus.team.Team;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Games")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate date;

    private boolean played; //If the game has been played

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private MatchStadistics stadistics_1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private MatchStadistics stadistics_2;

    @ManyToMany
    private List<Team> teams;

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", stadistics_1=" + stadistics_1 +
                ", stadistics_2=" + stadistics_2 +
                ", teams=" + teams +
                '}';
    }

    public Match() {
    }

    public Match(boolean played, LocalDate date, MatchStadistics stadistics_1, MatchStadistics stadistics_2,Team t1,Team t2){
        super();
        List<Team> aux = new ArrayList<>(2);
        aux.add(t1);
        aux.add(t2);
        this.played = played;
        this.teams= aux;
        this.date=date;
        this.stadistics_1=stadistics_1;
        this.stadistics_2=stadistics_2;
    }
  
  

    public Match(boolean played, LocalDate date, Team t1, Team t2) {
        super();
        List<Team> aux = new ArrayList<>(2);
        aux.add(t1);
        aux.add(t2);
        this.played = played;
        this.teams= aux;
        this.date=date;
    }



    public MatchStadistics getStadistics_1() {
        return stadistics_1;
    }

    public void setStadistics_1(MatchStadistics stadistics_1) {
        this.stadistics_1 = stadistics_1;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public MatchStadistics getStadistics_2() {
        return stadistics_2;
    }

    public void setStadistics_2(MatchStadistics stadistics_2) {
        this.stadistics_2 = stadistics_2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Match getMatch() {
        return this;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public Long getidTeam(int n) {
        if (n >= 1 && n <= 2) {
            return teams.get(n - 1).getId();
        } else {
            return Integer.toUnsignedLong(0);
        }
    }

    public boolean hasTeam(Team team){
        return teams.contains(team);
    }
}
