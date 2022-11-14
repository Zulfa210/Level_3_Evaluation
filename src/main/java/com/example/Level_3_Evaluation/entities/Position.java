package com.example.Level_3_Evaluation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Zulfa Attar
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long positionId;

    @Column(name = "player_position_x_coordinate")
    private int playerPositionXCoordinate;

    @Column(name = "player_position_y_coordinate")
    private int playerPositionYCoordinate;


    @OneToOne
    @JoinColumn(
            referencedColumnName = "playerId",
            name = "player_id"
    )
    private Player player;
}
