package com.example.padelversus.Match;

import com.example.padelversus.Match.Stadistics.MatchStadistics;

import javax.persistence.*;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Team team_1;
    //private Team team_2;
    private String score;
    private String date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private MatchStadistics stadistics_1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private MatchStadistics stadistics_2;
    //private Team winner;

    public Match() {
    }
    public Match(String score, String date, MatchStadistics stadistics_1, MatchStadistics stadistics_2){
        super();
        //this.team_1=team_1;
        //this.team_2=team_2;
        this.score=score;
        this.date=date;
        this.stadistics_1=stadistics_1;
        this.stadistics_2=stadistics_2;
        //this.winner=winner;
    }

    public MatchStadistics getStadistics_1() {
        return stadistics_1;
    }

    public void setStadistics_1(MatchStadistics stadistics_1) {
        this.stadistics_1 = stadistics_1;
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
