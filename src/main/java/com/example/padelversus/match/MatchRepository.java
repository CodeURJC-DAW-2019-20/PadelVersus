package com.example.padelversus.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
     Optional<Match> findById(long id);
     Optional<Match> findByDate(Date date);
}
