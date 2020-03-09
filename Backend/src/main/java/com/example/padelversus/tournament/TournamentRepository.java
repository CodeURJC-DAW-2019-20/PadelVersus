package com.example.padelversus.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    Optional<Tournament> findById(Long id);

    Optional<Tournament> findByName(String name);

    @Query(value = "SELECT t.* " +
            "FROM tournament_matches AS tm " +
            "INNER JOIN tournament t ON tm.tournament_id = t.id " +
            "INNER JOIN games m ON tm.matches_id = m.id " +
            "WHERE m.id = ?1", nativeQuery = true)
    Optional<Tournament> findTournamentByMatchId(Long id);

    @Query(value = "SELECT tr.* " +
            "FROM tournament_teams AS tt " +
            "INNER JOIN team t ON tt.teams_id = t.id " +
            "INNER JOIN tournament tr ON tt.tournament_id = tr.id  " +
            "WHERE t.id = ?1",
            nativeQuery = true)
    List<Tournament> findTournamentByTeamId(Long id);
}
