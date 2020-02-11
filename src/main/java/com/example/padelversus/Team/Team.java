package com.example.padelversus.Team;

import com.example.padelversus.Player;

import javax.persistence.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Player playerOne;

    @OneToOne(cascade = CascadeType.ALL)
    private TeamStatistics teamStatistics;

    public Team(){
    }

    public Team(String name, Player playerOne, TeamStatistics teamStatistics){
        super();
        this.name = name;
        this.playerOne = playerOne;
        this.teamStatistics = teamStatistics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public TeamStatistics getTeamStatistics() {
        return teamStatistics;
    }

    public void setTeamStatistics(TeamStatistics teamStatistics) {
        this.teamStatistics = teamStatistics;
    }
}
