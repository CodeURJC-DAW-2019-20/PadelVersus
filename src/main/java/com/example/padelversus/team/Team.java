package com.example.padelversus.team;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name="team_players", joinColumns=@JoinColumn(name="player_id"), inverseJoinColumns=@JoinColumn(name="team_id"))
    private List<Player> players;

    @OneToOne(cascade = CascadeType.ALL)
    private TeamStatistics teamStatistics;

    public Team(){
    }

    public Team(String name, List<Player> playerOne, TeamStatistics teamStatistics){
        super();
        this.name = name;
        this.players = playerOne;
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public TeamStatistics getTeamStatistics() {
        return teamStatistics;
    }

    public void setTeamStatistics(TeamStatistics teamStatistics) {
        this.teamStatistics = teamStatistics;
    }
}
