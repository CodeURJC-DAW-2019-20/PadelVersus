package com.example.padelversus.player;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public  interface PlayerRepository extends JpaRepository<Player,Long> {
    public Optional<Player> findById(Long id);


}
