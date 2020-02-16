package com.example.padelversus.tournament;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    Optional<Tournament> findById(Long id);
    Optional<Tournament> findByName(String name);
}
