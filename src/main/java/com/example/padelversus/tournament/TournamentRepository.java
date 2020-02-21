package com.example.padelversus.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    Optional<Tournament> findById(Long id);

    Optional<Tournament> findByName(String name);

    @Query(value = "SELECT t.* " +
            "FROM tournament_matches AS tm " +
            "INNER JOIN tournament t ON tm.tournament_id = t.id " +
            "INNER JOIN games m ON tm.matches_id = m.id " +
            "WHERE m.id = ?1",nativeQuery = true)
    Optional<Tournament> findTournamentByMatchId(Long id);
}
