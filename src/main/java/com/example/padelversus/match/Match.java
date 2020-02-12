package com.example.padelversus.match;

import com.example.padelversus.match.Stadistics.MatchStadistics;
import com.example.padelversus.team.Team;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String score;
    private String date;

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
                ", score='" + score + '\'' +
                ", date='" + date + '\'' +
                ", stadistics_1=" + stadistics_1 +
                ", stadistics_2=" + stadistics_2 +
                ", teams=" + teams +
                '}';
    }

    public Match() {
    }
    public Match(String score, String date, MatchStadistics stadistics_1, MatchStadistics stadistics_2,Team t1,Team t2){
        super();
        List<Team> aux = new ArrayList<>(2);
        aux.add(t1);
        aux.add(t2);
        this.teams= aux;
        this.score=score;
        this.date=date;
        this.stadistics_1=stadistics_1;
        this.stadistics_2=stadistics_2;
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

   /* public Team getTeam_1() {
        return team_1;
    }

    public void setTeam_1(Team team_1) {
        this.team_1 = team_1;
    }

    public Team getTeam_2() {
        return team_2;
    }

    public void setTeam_2(Team team_2) {
        this.team_2 = team_2;
    }
*/
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   /* public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }*/
}
