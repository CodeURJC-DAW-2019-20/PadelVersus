package com.example.padelversus.tournament;

import com.example.padelversus.match.Match;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nonspacename;

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Matches=" + Matches +
                ", nonspacename= " + nonspacename +
                '}';
    }

    @OneToMany
    private List<Match> Matches;

    public Tournament() {
    }

    public Tournament(String name, List<Match> matches) {
        this.name = name;
        this.Matches = matches;
        this.nonspacename = name.replaceAll("\\s","");
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
        return Matches;
    }

    public void setMatches(List<Match> matches) {
        Matches = matches;
    }

}
