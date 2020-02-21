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

}
