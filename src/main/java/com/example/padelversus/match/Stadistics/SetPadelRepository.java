package com.example.padelversus.match.Stadistics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SetPadelRepository extends JpaRepository<SetPadel, Long> {
    public Optional<SetPadel> findById (Long id);
}
