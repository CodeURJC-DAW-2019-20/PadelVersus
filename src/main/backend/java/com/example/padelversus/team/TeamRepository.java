package com.example.padelversus.team;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByid(Long id);

    Optional<Team> findByName(String name);

    Page<Team> findAll(Pageable pageable);

    @Query(value = "SELECT t.* " +
            "FROM team_players AS tp " +
            "INNER JOIN team t ON tp.team_id = t.id " +
            "INNER JOIN player p ON tp.players_id = p.id " +
            " WHERE p.id = ?1",
            nativeQuery = true)
    List<Team> findTeamByPlayerId(Long id);
}
