package com.example.padelversus.tournament;

import com.example.padelversus.match.Match;
import com.example.padelversus.team.Team;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nonspacename;
    @OneToMany
    private List<Match> matches;
    @ManyToMany
    private List<Team> teams;

    public Tournament() {
    }

    public Tournament(String name, List<Match> matches, List<Team> teams) {
        this.name = name;
        this.matches = matches;
        this.nonspacename = name.replaceAll("\\s", "");
        this.teams = teams;
    }

    public Tournament(String name) {
        this.name = name;
        this.matches = new ArrayList<>();
        this.nonspacename = name.replaceAll("\\s", "");
        this.teams = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", matches=" + matches +
                ", nonspacename= " + nonspacename +
                ", teams= " + teams +
                '}';
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void addMatch(Match m) {
        this.matches.add(m);
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

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Tournament getTournament() {
        return this;
    }

    public boolean hasTeam(Team team) {
        return teams.contains(team);
    }

    public String getNonspacename() {
        return nonspacename;
    }

    public void setNonspacename(String nonspacename) {
        this.nonspacename = nonspacename;
    }


}
