package com.example.padelversus.player;

import com.example.padelversus.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findById(Long id);
    Optional<Player> findByUser(User user);
    Optional<Player> findByUserName(String name);
}
