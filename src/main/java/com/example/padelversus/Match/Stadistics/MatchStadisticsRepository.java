package com.example.padelversus.Match.Stadistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MatchStadisticsRepository extends JpaRepository<MatchStadistics, Long> {
        Optional<MatchStadistics> findById(long id);
}
