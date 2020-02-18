package com.example.padelversus.team;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
        public Optional<Team> findByid(Long id);
        public Optional<Team> findByName(String name);
        public Page<Team> findAll(Pageable pageable);
}
