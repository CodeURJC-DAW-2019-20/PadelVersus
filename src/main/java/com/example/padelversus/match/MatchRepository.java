package com.example.padelversus.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    Optional<Match> findById(long id);

    Optional<Match> findByDate(LocalDate date);

    @Query(value =
            "SELECT m.* " +
                    "FROM  tournament_matches tm " +
                    "INNER JOIN tournament t ON tm.tournament_id = t.id " +
                    "INNER JOIN games m ON tm.matches_id = m.id " +
                    "WHERE NOT played and t.name = ?1",
            nativeQuery = true)
    List<Match> findNotPlayedByTournamentName(String name);

    @Query(value = "SELECT m.* " +
            "FROM tournament_matches AS tm " +
            "INNER JOIN tournament t ON tm.tournament_id = t.id " +
            "INNER JOIN(" +
            "SELECT id, date, played, stadistics_1_id, stadistics_2_id " +
            "FROM (" +
            "SELECT t.name as team_name , g.id as match_id, g.* " +
            "FROM games_teams AS gt " +
            "INNER JOIN games g ON gt.match_id = g.id " +
            "INNER JOIN team t ON gt.teams_id = t.id " +
            "WHERE t.name=?1 OR t.name=?2 " +
            "GROUP BY g.id " +
            "HAVING count(g.id)>1 " +
            ") AS joinned_table " +
            ") m ON tm.matches_id = m.id " +
            "WHERE NOT played and t.name = ?3 ",
            nativeQuery = true)
    Optional<Match> findIdByTeamsNameAndTournamentName(String t1, String t2, String tName);

    @Query(value = "SELECT * " +
            "FROM games " +
            "WHERE played " +
            "ORDER BY date desc " +
            "LIMIT 4",
            nativeQuery = true)
    List<Match> findLastFourMatchesPlayedOrderByDateDesc();

    @Query(value = "SELECT * " +
            "FROM games " +
            "WHERE NOT played " +
            "ORDER BY date " +
            "LIMIT 4",
            nativeQuery = true)
    List<Match> findNextFourMatchesPlayedOrderByDate();

    @Query(value = "SELECT * " +
            "FROM games " +
            "WHERE date = ?1 AND NOT played " +
            "ORDER BY date asc",
            nativeQuery = true)
    List<Match> findMatchByDateAndPlayedOrderByDate(String date);

    @Query(value = "SELECT distinct date FROM games WHERE NOT played order by date", nativeQuery = true)
    List<Date> findAllNotPlayedDates();

    @Query(value = "SELECT g.* " +
            "FROM  padelversus.games_teams gt " +
            "INNER JOIN padelversus.games g ON gt.match_id = g.id " +
            "INNER JOIN padelversus.team t ON gt.teams_id = t.id " +
            "WHERE g.played and t.id = ?1 " +
            "ORDER by g.date desc " +
            "LIMIT 4", nativeQuery = true)
    List<Match> findLastFourMatchesPlayedByTeamId(Long id);
}
