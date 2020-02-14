package com.example.padelversus.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamStatisticsRepository extends JpaRepository<TeamStatistics, Long> {
    public Optional<TeamStatistics> findById(Long id);
}
