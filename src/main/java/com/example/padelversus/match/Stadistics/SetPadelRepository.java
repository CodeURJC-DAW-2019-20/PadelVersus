package com.example.padelversus.match.Stadistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SetPadelRepository extends JpaRepository<SetPadel, Long> {
    Optional<SetPadel> findById(Long id);
}
