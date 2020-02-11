package com.example.padelversus.Team;

import com.example.padelversus.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
        public Optional<Team> findByid(Long id);
}
