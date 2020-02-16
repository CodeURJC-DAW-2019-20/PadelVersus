package com.example.padelversus.player;

import com.example.padelversus.ImageService;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamRepository;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import com.example.padelversus.user.User;
import com.example.padelversus.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private ImageService imageService;

    //Save (a copy) of a player joined with the user passed in username param if not possible return false
    public boolean savePlayer(Player player, String username) {
        User relatedUser = userRepository.findByName(username);
        if (relatedUser != null) {
            Player playerSave = new Player();

            playerSave.setAge(player.getAge());
            playerSave.setImage(player.getImage());
            playerSave.setCountryBirth(player.getCountryBirth());
            playerSave.setHeight(player.getHeight());
            playerSave.setWeight(player.getWeight());
            playerSave.setSpeed(player.getSpeed());
            playerSave.setStrength(player.getStrength());
            playerSave.setEndurance(player.getEndurance());
            playerSave.setPace(player.getPace());
            playerSave.setAccuaracy(player.getAccuaracy());
            playerSave.setAceleration(player.getAceleration());

            player.setUser(relatedUser);
            playerRepository.save(player);
            return true;
        }
        return false;
    }

    //find the name of the team  of the player

    public Team findTeamOfPlayer(Player player) {
        Team team = null;
        List<Team> allTeams = teamRepository.findAll();
        boolean encontrado = false;
        Iterator<Team> it = allTeams.iterator();
        while ((!encontrado) && (it.hasNext())) {
            team = it.next();
            encontrado = team.getPlayers().contains(player);
        }
        if (!encontrado) {
            team = null;
        }
        return team;
    }

    //find the name of more the team  of each player
    public List<Team>findMoreTeamOfEachPlayer(Player player) {
        List<Team> allTeams = teamRepository.findAll();
        List<Team> teamsFounds = new ArrayList<>();
        Iterator<Team> it = allTeams.iterator();
        Team team = null;
        while ((it.hasNext())) {
            team = it.next();
            if(team.getPlayers().contains(player)){
                teamsFounds.add(team);
            }
        }

        return teamsFounds;
    }

    //find the name of the tournament  of the player
    public Tournament findTournamentOfPlayer(Player player) {
        Tournament tournament = null;
        List<Tournament> allTournaments = tournamentRepository.findAll();
        boolean encontrado = false;
        Iterator<Tournament> it = allTournaments.iterator();
        while ((!encontrado) && (it.hasNext())) {
            tournament = it.next();
            encontrado = tournament.getTeams().contains(findTeamOfPlayer(player));
        }
        if (!encontrado) {
            tournament = null;
        }
        return tournament;
    }

    public List<Tournament>findMoreTournamentOfEachPlayer(Player player) {
        List<Tournament> allTournaments = tournamentRepository.findAll();
        List<Tournament> tournamentsFounds = new ArrayList<>();
        List<Team> teamsOfPlayer = findMoreTeamOfEachPlayer(player);
        for ( Tournament oneTournament :allTournaments){
            for(Team team :teamsOfPlayer){
                if(oneTournament.getTeams().contains(team) && !tournamentsFounds.contains(oneTournament)){
                    tournamentsFounds.add(oneTournament);
                }
            }
        }

        return tournamentsFounds;
    }



    // Return the string temporal path were the image is saved (return null if there is any problem)
    public String getImagePath(Player player) {
        byte[] byteImage = player.getImage();
        BufferedImage imageFile;
        try {
            imageFile = ImageIO.read(new ByteArrayInputStream(byteImage));
        } catch (IOException e) {
            return null;
        }
        String path;
        try {
            path = imageService.saveImage("Player", player.getId(), imageFile);
        } catch (IOException e) {
            return null;
        }
        return path;
    }

    // Only for demo purpose (assign File to byte[])
    public boolean setImagePlayer(Player player, File imageFile) {
        BufferedImage bImage;
        try {
            bImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            return false;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, "jpg", bos);
        } catch (IOException e) {
            return false;
        }
        byte[] data = bos.toByteArray();
        player.setImage(data);
        return true;
    }
}
