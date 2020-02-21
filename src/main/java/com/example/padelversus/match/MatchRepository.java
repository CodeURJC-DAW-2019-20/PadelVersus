package com.example.padelversus.match;

import com.example.padelversus.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
     Optional<Match> findById(long id);
     Optional<Match> findByDate(LocalDate date);

     @Query(value=
             "SELECT m.* " +
             "FROM  tournament_matches tm " +
             "INNER JOIN tournament t ON tm.tournament_id = t.id " +
             "INNER JOIN games m ON tm.matches_id = m.id " +
             "WHERE NOT played and t.name = ?1",
             nativeQuery = true)
     List<Match> findNotPlayedByTournamentName(String name);

     @Query(value="SELECT m.* " +
                  "FROM tournament_matches AS tm " +
                  "INNER JOIN tournament t ON tm.tournament_id = t.id "+
                  "INNER JOIN(" +
                       "SELECT id, date, played, stadistics_1_id, stadistics_2_id "+
                       "FROM ("+
                               "SELECT t.name as team_name , g.id as match_id, g.* "+
                               "FROM games_teams AS gt " +
                               "INNER JOIN games g ON gt.match_id = g.id " +
                               "INNER JOIN team t ON gt.teams_id = t.id " +
                               "WHERE t.name=?1 OR t.name=?2 " +
                               "GROUP BY g.id " +
                               "HAVING count(g.id)>1 "+
                       ") AS joinned_table "+
                  ") m ON tm.matches_id = m.id "+
                  "WHERE NOT played and t.name = ?3 ",
             nativeQuery = true)
     Optional<Match> findIdByTeamsNameAndTournamentName(String t1, String t2, String tName);

}
