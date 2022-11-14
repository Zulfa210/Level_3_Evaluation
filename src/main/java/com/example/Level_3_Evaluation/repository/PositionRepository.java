package com.example.Level_3_Evaluation.repository;

import com.example.Level_3_Evaluation.entities.Player;
import com.example.Level_3_Evaluation.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Zulfa Attar
 */
@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Position findByPlayer(Player player);

    Optional<Position> findByPlayerPositionXCoordinateAndPlayerPositionYCoordinate(int playerPositionXCoordinate, int playerPositionYCoordinate);

}
