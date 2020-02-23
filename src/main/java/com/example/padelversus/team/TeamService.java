package com.example.padelversus.team;

import com.example.padelversus.ImageService;
import com.example.padelversus.player.Player;
import com.example.padelversus.team.display.TeamxDisplay;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    private ImageService imageService;

    public Optional<Team> getTeam(Long id) {
        Optional<Team> team = teamRepository.findByid(id);
        return team;
    }

    public Optional<Team> getTeamByName(String name) {
        Optional<Team> team = teamRepository.findByName(name);
        return team;
    }

    public TeamxDisplay createTeamxDisplay(Team team) {
        TeamxDisplay teamxDisplay = new TeamxDisplay(team);
        loadPlayerImages(team);
        return teamxDisplay;
    }

    public void loadPlayerImages(Team team) {
        try {
            Player player1 = team.getMemberN(1);
            Player player2 = team.getMemberN(2);
            BufferedImage playerImage1 = player1.getBufferedImage();
            String base_url = "/images_temp/Player/";
            String image_name = imageService.saveImage("Player", player1.getId(), playerImage1);
            String image1_url = base_url + image_name;
            player1.setImageUrl(image1_url);

            BufferedImage playerImage2 = player2.getBufferedImage();
            image_name = imageService.saveImage("Player", player2.getId(), playerImage2);
            String image2_url = base_url + image_name;
            player2.setImageUrl(image2_url);
        } catch (IOException e) {
            System.out.println("Fatal error loading player images");
            e.printStackTrace();
        }
    }

    public Page<Team> getPages(Pageable page) {
        return teamRepository.findAll(page);
    }

    public List<String[]> getPageTeamNames(Page<Team> pages) {
        List<String[]> pageTeamNames = new ArrayList<>();
        for (Team t : pages) {
            String[] info = {Long.toString(t.getId()), t.getName()};
            pageTeamNames.add(info);
        }

        return pageTeamNames;
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public List<String> getPageTeamNamesforTeamsController(Pageable page) {
        Page<Team> pages = teamRepository.findAll(page);
        List<Team> allTeams = teamRepository.findAll();
        List<String> pageTeamNames = new ArrayList<>();
        for (Team t : pages) {
            pageTeamNames.add(t.getName());
        }

        return pageTeamNames;
    }

    public void saveTeam(Team team) {
        teamRepository.save(team);
    }
}
