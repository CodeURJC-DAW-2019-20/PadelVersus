package com.example.padelversus.team.display;

import com.example.padelversus.team.Team;

public class SimpleTeamDisplay {
    private String id;
    private String name;

    public SimpleTeamDisplay(Team team){
        this.id = Long.toString(team.getId());
        this.name = team.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
