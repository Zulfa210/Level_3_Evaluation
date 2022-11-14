package com.example.Level_3_Evaluation.repository;

import com.example.Level_3_Evaluation.entities.Game;
import com.example.Level_3_Evaluation.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Zulfa Attar
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
   Optional<Game> findByFirstPlayer(Player firstPlayer);

    Optional<Game> findBySecondPlayer(Player secondPlayer);



}
