package com.example.padelversus.match.display;

import com.example.padelversus.team.display.LastMatchDisplay;

import java.time.LocalDate;
import java.util.List;

public class MatchesByDateDisplay {
    private List<LastMatchDisplay> matches;
    private LocalDate date;

    public MatchesByDateDisplay(List<LastMatchDisplay> matches, LocalDate localDate) {
        this.matches = matches;
        this.date = localDate;
    }

    public List<LastMatchDisplay> getMatches() {
        return matches;
    }

    public void setMatches(List<LastMatchDisplay> matches) {
        this.matches = matches;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
