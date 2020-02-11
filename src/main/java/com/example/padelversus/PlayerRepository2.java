package com.example.padelversus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository2 extends JpaRepository<Player2, Long> {

    public Optional<Player2> findById(long id);
}
