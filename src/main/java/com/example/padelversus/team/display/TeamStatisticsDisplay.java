package com.example.padelversus.team.display;

import com.example.padelversus.team.teamstatistics.TeamStatistics;

public class TeamStatisticsDisplay {
    private String totalWins;
    private String totalDefeats;
    private String meanAcurracy;
    private String meanEffectiveness;
    private String meanUnforcedErrors;
    private String gamesPerMatch;

    public TeamStatisticsDisplay(TeamStatistics statistics){
        String[] parsedStatistics = statistics.meanStatisticsParsed();
        this.totalWins = parsedStatistics[0];
        this.totalDefeats = parsedStatistics[1];
        this.meanAcurracy = parsedStatistics[2];
        this.meanEffectiveness = parsedStatistics[3];
        this.meanUnforcedErrors = parsedStatistics[4];
        this.gamesPerMatch= parsedStatistics[5];
    }

    public String getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(String totalWins) {
        this.totalWins = totalWins;
    }

    public String getTotalDefeats() {
        return totalDefeats;
    }

    public void setTotalDefeats(String totalDefeats) {
        this.totalDefeats = totalDefeats;
    }

    public String getMeanAcurracy() {
        return meanAcurracy;
    }

    public void setMeanAcurracy(String meanAcurracy) {
        this.meanAcurracy = meanAcurracy;
    }

    public String getMeanEffectiveness() {
        return meanEffectiveness;
    }

    public void setMeanEffectiveness(String meanEffectiveness) {
        this.meanEffectiveness = meanEffectiveness;
    }

    public String getMeanUnforcedErrors() {
        return meanUnforcedErrors;
    }

    public void setMeanUnforcedErrors(String meanUnforcedErrors) {
        this.meanUnforcedErrors = meanUnforcedErrors;
    }

    public String getGamesPerMatch() {
        return gamesPerMatch;
    }

    public void setGamesPerMatch(String gamesPerMatch) {
        this.gamesPerMatch = gamesPerMatch;
    }
}
