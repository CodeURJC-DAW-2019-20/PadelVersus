package com.example.padelversus.team;

import com.example.padelversus.match.Match;
import com.example.padelversus.player.Player;
import com.example.padelversus.team.teamstatistics.TeamStatistics;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<Player> players;

    @OneToOne(cascade = CascadeType.ALL)
    private TeamStatistics teamStatistics;

    @ManyToMany
    private List<Match> matches;

    public Team(){
    }

    public Team(String name, Player playerOne, Player playerTwo){
        super();
        List<Player> aux = new ArrayList<>(2);
        aux.add(playerOne);
        aux.add(playerTwo);
        this.name = name;
        this.players =  aux;
        this.teamStatistics = new TeamStatistics();
        this.matches = new ArrayList<>();
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

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> playedMatches) {
        this.matches = playedMatches;
    }

    public void addMatch(Match m) {
        this.matches.add(m);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", players=" + players +
                ", teamStatistics=" + teamStatistics +
                '}';
    }

    public void updateTeamStatistics(){
        teamStatistics.resetStatistics();
        for(Match m: matches){
            if (m.isPlayed()){
                if (id == m.getidTeam(1)) {
                    teamStatistics.updateStatistics(m.getStadistics_1());
                } else {
                    teamStatistics.updateStatistics(m.getStadistics_2());
                }
            }
        }
    }
}
