package com.example.Level_3_Evaluation.repository;

import com.example.Level_3_Evaluation.entities.Player;
import com.example.Level_3_Evaluation.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zulfa Attar
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByPlayerPosition(Position playerPosition);

}

