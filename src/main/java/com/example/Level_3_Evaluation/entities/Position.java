package com.example.Level_3_Evaluation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Zulfa Attar
 */
@Entity
@Data
@ToString(exclude = "player")
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


    @JsonIgnore
    @OneToOne
    @JoinColumn(
            referencedColumnName = "playerId",
            name = "player_id"
    )
    private Player player;


}
