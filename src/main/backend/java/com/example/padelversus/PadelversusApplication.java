package com.example.padelversus;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchRepository;
import com.example.padelversus.match.stadistics.MatchStadistics;
import com.example.padelversus.match.stadistics.SetPadel;
import com.example.padelversus.match.stadistics.SetPadelRepository;
import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerRepository;
import com.example.padelversus.player.PlayerService;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamRepository;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import com.example.padelversus.user.User;
import com.example.padelversus.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PadelversusApplication implements ApplicationRunner {

    private static final Path DEMO_FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "DemoImages");

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private SetPadelRepository setPadelRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlayerService playerService;

    public static void main(String[] args) {
        SpringApplication.run(PadelversusApplication.class, args);
    }
    public List<SetPadel> createSets(int games1,int games2,int games3){
        List<SetPadel> sets = new ArrayList<>();

        SetPadel set1 = new SetPadel(games1,1);
        SetPadel set2 = new SetPadel(games2,2);
        SetPadel set3 = new SetPadel(games3,3);

        setPadelRepository.save(set1);
        setPadelRepository.save(set2);
        setPadelRepository.save(set3);

        sets.add(set1);
        sets.add(set2);
        sets.add(set3);

        return sets;

    }



    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Save teams and player

        Player player1 = new Player(14, 1.68, 60, 1, 5.6, 8, 10, 10, 2.5, "Spain");
        User user1 = new User("Baltasar Grasia", "BaltasarGrasia", "baltasargrasia@gmail.com", "ROLE_USER");
        player1.setUser(user1);
        File imageFile_1 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_1.jpeg").toFile();
        playerService.setImagePlayer(player1, imageFile_1);

        Player player2 = new Player(16, 1.70, 65, 2, 4.4, 6.8, 9, 2, 4.6, "France");
        User user2 = new User("Baldomero Grano", "BaldomeroGrano", "baldomerograno@gmail.com", "ROLE_USER");
        player2.setUser(user2);
        File imageFile_2 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_2.jpeg").toFile();
        playerService.setImagePlayer(player2, imageFile_2);

        Player player3 = new Player(23, 1.72, 66, 3, 5, 5, 2, 2, 5.6, "Netherland");
        User user3 = new User("Pepe Dominguez", "PepeDominguez", "pepedominguez@gmail.com", "ROLE_USER");
        player3.setUser(user3);
        File imageFile_3 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_3.jpeg").toFile();
        playerService.setImagePlayer(player3, imageFile_3);

        Player player4 = new Player(24, 1.78, 67, 4, 3.7, 6.7, 3, 5, 6.7, "Spain");
        User user4 = new User("Baltasar Cardiel", "BaltasarCardiel", "baltasarcardiel@gmail.com", "ROLE_USER");
        player4.setUser(user4);
        File imageFile_4 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_4.jpeg").toFile();
        playerService.setImagePlayer(player4, imageFile_4);

        Player player5 = new Player(25, 1.79, 89, 5, 3.5, 3, 4, 6, 6.9, "Portugal");
        User user5 = new User("Lucas Guerreiro", "LucasGuerreiro", "lucasguerreiro@gmail.com", "ROLE_USER");
        player5.setUser(user5);
        File imageFile_5 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_5.jpeg").toFile();
        playerService.setImagePlayer(player5, imageFile_5);

        Player player6 = new Player(26, 1.87, 70, 6, 3.7, 5, 5, 7, 7.0, "United Kindgdom");
        User user6 = new User("Baruj Griego", "BarujGriego", "barujgriego@gmail.com", "ROLE_USER");
        player6.setUser(user6);
        File imageFile_6 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_6.jpeg").toFile();
        playerService.setImagePlayer(player6, imageFile_6);

        Player player7 = new Player(28, 1.9, 73, 7, 3.3, 6, 7, 8, 7.2, "United Kindgdom");
        User user7 = new User("Andrea Carion", "AndreaCarion", "andreacarion@gmail.com", "ROLE_USER");
        player7.setUser(user7);
        File imageFile_7 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_7.jpeg").toFile();
        playerService.setImagePlayer(player7, imageFile_7);

        Player player8 = new Player(31, 1.8, 75, 8, 3.2, 6.7, 8, 7, 6.4, "France");
        User user8 = new User("Bartolomé Grande", "BartolomeGrande", "bartolomegrande@gmail.com", "ROLE_USER");
        player8.setUser(user8);
        File imageFile_8 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_8.jpeg").toFile();
        playerService.setImagePlayer(player8, imageFile_8);

        Player player9 = new Player(32, 1.8, 77, 9, 1.6, 6.8, 9, 6, 5.6, "Spain");
        User user9 = new User("David Guerrero", "DavidGuerrero", "davidguerrero@gmail.com", "ROLE_USER");
        player9.setUser(user9);
        File imageFile_9 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_9.jpeg").toFile();
        playerService.setImagePlayer(player9, imageFile_9);

        Player player10 = new Player(33, 1.5, 70, 7, 1.7, 4.6, 10, 8, 6.7, "Spain");
        User user10 = new User("Baruj Grangenal", "BarujGrangenal", "barujgrangenal@gmail.com", "ROLE_USER");
        player10.setUser(user10);
        File imageFile_10 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_10.jpeg").toFile();
        playerService.setImagePlayer(player10, imageFile_10);

        Player player11 = new Player(35, 1.7, 51, 8, 1.8, 4.6, 3, 9, 8.8, "Italy");
        User user11 = new User("Andrea Grigalva", "AndreaGrigalva", "andreagrigalva@gmail.com", "ROLE_USER");
        player11.setUser(user11);
        File imageFile_11 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_11.jpeg").toFile();
        playerService.setImagePlayer(player11, imageFile_11);

        Player player12 = new Player(47, 1.5, 58, 6, 1.9, 4.8, 4, 2, 9.9, "France");
        User user12 = new User("Baldwin Carion", "BaldwinCarion", "baldwincarion@gmail.com", "ROLE_USER");
        player12.setUser(user12);
        File imageFile_12 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_12.jpeg").toFile();
        playerService.setImagePlayer(player12, imageFile_12);

        Player player13 = new Player(45, 1.6, 60, 7, 1.5, 4.3, 4.6, 3, 3.4, "Netherland");
        User user13 = new User("Bart Carion", "BartCarion", "bartcarion@gmail.com", "ROLE_USER");
        player13.setUser(user13);
        File imageFile_13 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_13.jpeg").toFile();
        playerService.setImagePlayer(player13, imageFile_13);

        Player player14 = new Player(24, 1.8, 62, 9, 1.4, 3.2, 5.7, 4, 5.6, "Netherland");
        User user14 = new User("Carlota Grasia", "CarlotaGrasia", "carlotagrasia@gmail.com", "ROLE_USER");
        player14.setUser(user14);
        File imageFile_14 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_14.jpeg").toFile();
        playerService.setImagePlayer(player14, imageFile_14);

        Player player15 = new Player(48, 1.9, 45, 10, 1.3, 3.4, 5.6, 5, 6.7, "France");
        User user15 = new User("Caritina Castiyo", "CaritinaCastiyo", "caritinacastiyo@gmail.com", "ROLE_USER");
        player15.setUser(user15);
        File imageFile_15 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_15.jpeg").toFile();
        playerService.setImagePlayer(player15, imageFile_15);

        Player player16 = new Player(50, 1.4, 67, 10, 1.2, 5.7, 5.6, 6, 7.6, "France");
        User user16 = new User("Alex Suarez", "AlexSuarez", "alexsuarez@gmail.com", "ROLE_USER");
        player16.setUser(user16);
        File imageFile_16 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_16.jpeg").toFile();
        playerService.setImagePlayer(player16, imageFile_16);

        Player player17 = new Player(29, 1.6, 69, 9, 1.1, 5.8, 6.7, 7, 6.7, "Spain");
        User user17 = new User("Jordi Hurtado", "JordiHurtado", "jordihurtado@gmail.com", "ROLE_USER");
        player17.setUser(user17);
        File imageFile_17 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_17.jpeg").toFile();
        playerService.setImagePlayer(player17, imageFile_17);

        Player player18 = new Player(21, 1.7, 70, 8, 5.6, 5.9, 3.4, 8, 4.5, "Spain");
        User user18 = new User("Marco Gutierrez", "MarcoGutierrez", "marcogutierrez@gmail.com", "ROLE_USER");
        player18.setUser(user18);
        File imageFile_18 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_18.jpeg").toFile();
        playerService.setImagePlayer(player18, imageFile_18);

        Player player19 = new Player(39, 1.8, 76, 7, 5.8, 3.4, 5.6, 9, 6.7, "United Kindgdom");
        User user19 = new User("David Grano", "DavidGrano", "davidgrano@gmail.com", "ROLE_USER");
        player19.setUser(user19);
        File imageFile_19 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_19.jpeg").toFile();
        playerService.setImagePlayer(player19, imageFile_19);

        Player player20 = new Player(40, 1.9, 40, 6, 5.9, 5.4, 5.8, 10, 5.6, "United Kindgdom");
        User user20 = new User("Baldwin Carillo", "BaldwinCarillo", "baldwincarillo@gmail.com", "ROLE_USER");
        player20.setUser(user20);
        File imageFile_20 = DEMO_FILES_FOLDER.resolve("Players").resolve("Player_20.jpeg").toFile();
        playerService.setImagePlayer(player20, imageFile_20);


        Team t1 = new Team("Madrid PT", player1, player2);
        Team t2 = new Team("Atletico PT", player3, player4);
        Team t3 = new Team("Barcelona PT", player5, player6);
        Team t4 = new Team("Leones", player7, player8);
        Team t5 = new Team("Tigres", player9, player10);
        Team t6 = new Team("Donuts", player11, player12);
        Team t7 = new Team("Valencia PT", player13, player14);
        Team t8 = new Team("VersusTeam", player15, player16);
        Team t9 = new Team("Las palmas PT", player17, player18);
        Team t10 = new Team("Getafe PT", player18, player20);

        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);
        playerRepository.save(player4);
        playerRepository.save(player5);
        playerRepository.save(player6);
        playerRepository.save(player7);
        playerRepository.save(player8);
        playerRepository.save(player9);
        playerRepository.save(player10);
        playerRepository.save(player11);
        playerRepository.save(player12);
        playerRepository.save(player13);
        playerRepository.save(player14);
        playerRepository.save(player15);
        playerRepository.save(player16);
        playerRepository.save(player17);
        playerRepository.save(player18);
        playerRepository.save(player19);
        playerRepository.save(player19);
        playerRepository.save(player20);

        teamRepository.save(t1);
        teamRepository.save(t2);
        teamRepository.save(t3);
        teamRepository.save(t4);
        teamRepository.save(t5);
        teamRepository.save(t6);
        teamRepository.save(t7);
        teamRepository.save(t8);
        teamRepository.save(t9);
        teamRepository.save(t10);


        // Save tournaments and mathches

        List<SetPadel> setsPadelOne = createSets(4,6,6);
        List<SetPadel> setsPadelTwo = createSets(6,4,3);

        List<SetPadel> setsPadelThree = createSets(3,6,6);
        List<SetPadel> setsPadelFour = createSets(6,2,1);

        List<SetPadel> setsPadelFive = createSets(2,6,1);
        List<SetPadel> setsPadelSix = createSets(6,4,6);

        List<SetPadel> setsPadelSeven = createSets(1,6,1);
        List<SetPadel> setsPadelEight = createSets(6,3,6);

        List<SetPadel> setsPadelNine = createSets(6,1,6);
        List<SetPadel> setsPadelTen = createSets(1,6,3);

        List<SetPadel> setsPadelEleven = createSets(2,6,6);
        List<SetPadel> setsPadelTwelve = createSets(6,1,3);

        List<SetPadel> setsPadelThirteen = createSets(6,3,6);
        List<SetPadel> setsPadelFourteen = createSets(1,6,3);

        List<SetPadel> setsPadelFiveteen = createSets(3,6,1);
        List<SetPadel> setsPadelSixteen = createSets(6,2,6);

        List<SetPadel> setsPadelSeventeen = createSets(1,6,2);
        List<SetPadel> setsPadelEighteen = createSets(6,4,6);

        List<SetPadel> setsPadelNineteen = createSets(6,2,6);
        List<SetPadel> setsPadelTwenty =   createSets(1,6,1);

        List<SetPadel> setsPadelTwentyOne = createSets(6,3,6);
        List<SetPadel> setsPadelTwentyTwo = createSets(1,6,1);

        List<SetPadel> setsPadelTwentyThree = createSets(2,6,1);
        List<SetPadel> setsPadelTwentyFour = createSets(6,2,6);

        List<SetPadel> setsPadelTwentyFive = createSets(2,6,1);
        List<SetPadel> setsPadelTwentySix = createSets(6,2,6);

        List<SetPadel> setsPadelTwentySeven = createSets(2,6,1);
        List<SetPadel> setsPadelTwentyEight = createSets(6,4,6);

        List<SetPadel> setsPadelTwentyNine = createSets(2,6,1);
        List<SetPadel> setsPadelThirty =     createSets(6,3,6);

        List<SetPadel> setsPadelThirtyOne = createSets(6,1,6);
        List<SetPadel> setsPadelThirtyTwo = createSets(2,6,2);

        List<SetPadel> setsPadelThirtyThree = createSets(6,2,6);
        List<SetPadel> setsPadelThirtyFour = createSets(1,6,2);

        List<SetPadel> setsPadelThirtyFive = createSets(1,6,3);
        List<SetPadel> setsPadelThirtySix = createSets(6,2,6);


        // Tournament 1

        MatchStadistics ms1_1 = new MatchStadistics(setsPadelOne, 23, 57, 50, 50, true);
        MatchStadistics ms1_2 = new MatchStadistics(setsPadelTwo, 13, 17, 0, 0, false);

        Match match1 = new Match(true, LocalDate.of(2019, 10, 21), ms1_1, ms1_2, t1, t2);

        t1.updateTeamStatistics(ms1_1);
        t2.updateTeamStatistics(ms1_2);



        MatchStadistics ms2_1 = new MatchStadistics(setsPadelThree, 23, 57, 50, 50, true);
        MatchStadistics ms2_2 = new MatchStadistics(setsPadelFour, 13, 17, 0, 0, false);


        Match match2 = new Match(true, LocalDate.of(2019, 10, 22), ms2_1, ms2_2, t1, t3);

        t1.updateTeamStatistics(ms2_1);
        t3.updateTeamStatistics(ms2_2);



        MatchStadistics ms3_1 = new MatchStadistics(setsPadelFive, 23, 57, 50, 50, false);
        MatchStadistics ms3_2 = new MatchStadistics(setsPadelSix, 13, 17, +0, 0, true);

        Match match3 = new Match(true, LocalDate.of(2019, 10, 23), ms3_1, ms3_2, t4, t1);

        t1.updateTeamStatistics(ms3_2);
        t4.updateTeamStatistics(ms3_1);



        MatchStadistics ms4_1 = new MatchStadistics(setsPadelSeven, 99, 99, 99, 99, false);
        MatchStadistics ms4_2 = new MatchStadistics(setsPadelEight, 78, 7, 9, 3, true);

        Match match4 = new Match(true, LocalDate.of(2019, 10, 24), ms4_1, ms4_2, t2, t3);

        t2.updateTeamStatistics(ms4_1);
        t3.updateTeamStatistics(ms4_2);



        MatchStadistics ms5_1 = new MatchStadistics(setsPadelNine, 23, 57, 50, 50, true);
        MatchStadistics ms5_2 = new MatchStadistics(setsPadelTen, 23, 57, 50, 50, false);

        Match match5 = new Match(true, LocalDate.of(2019, 10, 25), ms5_1, ms5_2, t2, t4);

        t2.updateTeamStatistics(ms5_1);
        t4.updateTeamStatistics(ms5_2);



        MatchStadistics ms6_1 = new MatchStadistics(setsPadelEleven, 23, 57, 50, 50, true);
        MatchStadistics ms6_2 = new MatchStadistics(setsPadelTwelve, 23, 57, 50, 50, false);

        Match match6 = new Match(true, LocalDate.of(2019, 10, 26), ms6_1, ms6_2, t4, t3);

        t4.updateTeamStatistics(ms6_1);
        t3.updateTeamStatistics(ms6_2);

        matchRepository.save(match1);
        matchRepository.save(match2);
        matchRepository.save(match3);
        matchRepository.save(match4);
        matchRepository.save(match5);
        matchRepository.save(match6);

        ArrayList<Match> tournament1_matches = new ArrayList<>();
        tournament1_matches.add(match1);
        tournament1_matches.add(match2);
        tournament1_matches.add(match3);
        tournament1_matches.add(match4);
        tournament1_matches.add(match5);
        tournament1_matches.add(match6);


        ArrayList<Team> teamsTournament1 = new ArrayList<>();
        teamsTournament1.add(t1);
        teamsTournament1.add(t2);
        teamsTournament1.add(t3);
        teamsTournament1.add(t4);

        Tournament tournament1 = new Tournament("Tournament 1", tournament1_matches, teamsTournament1);
        tournamentRepository.save(tournament1);

        // Tournament 2
        MatchStadistics ms7_1 = new MatchStadistics(setsPadelThirteen, 23, 57, 50, 50, true);
        MatchStadistics ms7_2 = new MatchStadistics(setsPadelFourteen, 23, 57, 50, 50, false);

        Match match7 = new Match(true, LocalDate.of(2019, 11, 20), ms7_1, ms7_2, t4, t5);

        t4.updateTeamStatistics(ms7_1);
        t5.updateTeamStatistics(ms7_2);

        MatchStadistics ms8_1 = new MatchStadistics(setsPadelFiveteen, 23, 57, 50, 50, false);
        MatchStadistics ms8_2 = new MatchStadistics(setsPadelSixteen, 23, 57, 50, 50, true);

        Match match8 = new Match(true, LocalDate.of(2019, 11, 21), ms8_1, ms8_2, t4, t6);

        t4.updateTeamStatistics(ms8_1);
        t6.updateTeamStatistics(ms8_2);

        MatchStadistics ms9_1 = new MatchStadistics(setsPadelSeventeen, 23, 57, 50, 50, false);
        MatchStadistics ms9_2 = new MatchStadistics(setsPadelEighteen, 23, 57, 50, 50, true);

        Match match9 = new Match(true, LocalDate.of(2019, 11, 22), ms9_1, ms9_2, t4, t7);

        t4.updateTeamStatistics(ms9_1);
        t7.updateTeamStatistics(ms9_2);

        MatchStadistics ms10_1 = new MatchStadistics(setsPadelNineteen, 23, 57, 50, 50, true);
        MatchStadistics ms10_2 = new MatchStadistics(setsPadelTwenty, 23, 57, 50, 50, false);

        Match match10 = new Match(true, LocalDate.of(2019, 11, 23), ms10_1, ms10_2, t5, t6);

        t5.updateTeamStatistics(ms10_1);
        t6.updateTeamStatistics(ms10_2);

        MatchStadistics ms11_1 = new MatchStadistics(setsPadelTwentyOne, 23, 57, 50, 50, true);
        MatchStadistics ms11_2 = new MatchStadistics(setsPadelTwentyTwo, 23, 57, 50, 50, false);

        Match match11 = new Match(true, LocalDate.of(2019, 11, 24), ms11_1, ms11_2, t5, t7);

        t5.updateTeamStatistics(ms11_1);
        t7.updateTeamStatistics(ms11_2);

        MatchStadistics ms12_1 = new MatchStadistics(setsPadelTwentyThree, 23, 57, 50, 50, false);
        MatchStadistics ms12_2 = new MatchStadistics(setsPadelTwentyFour, 23, 57, 50, 50, true);

        Match match12 = new Match(true, LocalDate.of(2019, 11, 25), ms12_1, ms12_2, t7, t6);

        t7.updateTeamStatistics(ms12_1);
        t6.updateTeamStatistics(ms12_2);

        matchRepository.save(match7);
        matchRepository.save(match8);
        matchRepository.save(match9);
        matchRepository.save(match10);
        matchRepository.save(match11);
        matchRepository.save(match12);

        List<Match> tournament2_matches = new ArrayList<>();
        tournament2_matches.add(match7);
        tournament2_matches.add(match8);
        tournament2_matches.add(match9);
        tournament2_matches.add(match10);
        tournament2_matches.add(match11);
        tournament2_matches.add(match12);

        List<Team> teamsTournament2 = new ArrayList<>();
        teamsTournament2.add(t4);
        teamsTournament2.add(t5);
        teamsTournament2.add(t6);
        teamsTournament2.add(t7);
        Tournament tournament2 = new Tournament("Tournament 2", tournament2_matches, teamsTournament2);
        tournamentRepository.save(tournament2);

        // Tournament 3
        MatchStadistics ms13_1 = new MatchStadistics(setsPadelTwentyFive, 23, 57, 50, 50, false);
        MatchStadistics ms13_2 = new MatchStadistics(setsPadelTwentySix, 23, 57, 50, 50, true);

        Match match13 = new Match(true, LocalDate.of(2019, 10, 20), ms13_1, ms13_2, t8, t6);

        t8.updateTeamStatistics(ms13_1);
        t6.updateTeamStatistics(ms13_2);

        MatchStadistics ms14_1 = new MatchStadistics(setsPadelTwentySeven, 23, 57, 50, 50, false);
        MatchStadistics ms14_2 = new MatchStadistics(setsPadelTwentyEight, 23, 57, 50, 50, true);

        Match match14 = new Match(true, LocalDate.of(2019, 11, 22), ms14_1, ms14_2, t6, t9);

        t6.updateTeamStatistics(ms14_1);
        t9.updateTeamStatistics(ms14_2);

        MatchStadistics ms15_1 = new MatchStadistics(setsPadelTwentyNine, 23, 57, 50, 50, false);
        MatchStadistics ms15_2 = new MatchStadistics(setsPadelThirty, 23, 57, 50, 50, true);

        Match match15 = new Match(true, LocalDate.of(2019, 11, 23), ms15_1, ms15_2, t6, t10);

        t6.updateTeamStatistics(ms15_1);
        t10.updateTeamStatistics(ms15_2);

        MatchStadistics ms16_1 = new MatchStadistics(setsPadelThirtyOne, 23, 57, 50, 50, true);
        MatchStadistics ms16_2 = new MatchStadistics(setsPadelThirtyTwo, 23, 57, 50, 50, false);

        Match match16 = new Match(true, LocalDate.of(2019, 11, 24), ms16_1, ms16_2, t8, t9);

        t8.updateTeamStatistics(ms16_1);
        t9.updateTeamStatistics(ms16_2);

        MatchStadistics ms17_1 = new MatchStadistics(setsPadelThirtyThree, 23, 57, 50, 50, true);
        MatchStadistics ms17_2 = new MatchStadistics(setsPadelThirtyFour, 23, 57, 50, 50, false);

        Match match17 = new Match(true, LocalDate.of(2019, 11, 25), ms17_1, ms17_2, t8, t10);

        t8.updateTeamStatistics(ms17_1);
        t10.updateTeamStatistics(ms17_2);

        MatchStadistics ms18_1 = new MatchStadistics(setsPadelThirtyFive, 23, 57, 50, 50, false);
        MatchStadistics ms18_2 = new MatchStadistics(setsPadelThirtySix, 23, 57, 50, 50, true);

        Match match18 = new Match(true, LocalDate.of(2019, 11, 26), ms18_1, ms18_2, t9, t10);

        t9.updateTeamStatistics(ms18_1);
        t10.updateTeamStatistics(ms18_2);

        Match match19 = new Match(false, LocalDate.of(2020, 3, 23), null, null, t1, t3);
        Match match20 = new Match(false, LocalDate.of(2020, 10, 30), null, null, t2, t4);
        Match match21 = new Match(false, LocalDate.of(2020, 11, 20), null, null, t6, t5);
        Match match22 = new Match(false, LocalDate.of(2020, 3, 10), null, null, t9, t8);
        Match match23 = new Match(false, LocalDate.of(2020, 3, 10), null, null, t10, t8);
        Match match24 = new Match(false, LocalDate.of(2020, 4, 15), null, null, t7, t8);

        matchRepository.save(match13);
        matchRepository.save(match14);
        matchRepository.save(match15);
        matchRepository.save(match16);
        matchRepository.save(match17);
        matchRepository.save(match18);

        matchRepository.save(match19);
        matchRepository.save(match20);
        matchRepository.save(match21);
        matchRepository.save(match22);
        matchRepository.save(match23);
        matchRepository.save(match24);


        List<Match> tournament3_matches = new ArrayList<>();
        tournament3_matches.add(match13);
        tournament3_matches.add(match14);
        tournament3_matches.add(match15);
        tournament3_matches.add(match16);
        tournament3_matches.add(match17);
        tournament3_matches.add(match18);
        tournament3_matches.add(match19);
        tournament3_matches.add(match20);
        tournament3_matches.add(match21);
        tournament3_matches.add(match22);
        tournament3_matches.add(match23);
        tournament3_matches.add(match24);

        List<Team> teamsTournament3 = new ArrayList<>();
        teamsTournament3.add(t6);
        teamsTournament3.add(t8);
        teamsTournament3.add(t9);
        teamsTournament3.add(t10);

        Tournament tournament3 = new Tournament("Tournament 3", tournament3_matches, teamsTournament3);
        tournamentRepository.save(tournament3);

        teamRepository.save(t1);
        teamRepository.save(t2);
        teamRepository.save(t3);
        teamRepository.save(t4);
        teamRepository.save(t5);
        teamRepository.save(t6);
        teamRepository.save(t7);
        teamRepository.save(t8);
        teamRepository.save(t9);
        teamRepository.save(t10);


        //Save database admin
        userRepository.save(new User("admin", "adminpass", "procesosoftg1@gmail.com", null, "ROLE_USER", "ROLE_ADMIN"));
    }


}
