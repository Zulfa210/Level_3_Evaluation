package com.example.Level_3_Evaluation.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * @author Zulfa Attar
 */
@Data
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameId;

    private String gameName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(
            referencedColumnName = "playerId",
            name = "first_player_id")
    private Player firstPlayer;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(
            referencedColumnName = "playerId",
            name = "second_player_id")
    private Player secondPlayer;

    @OneToOne
    @JoinColumn(
            referencedColumnName = "playerId",
            name = "winning_player_id")
    private Player winningPlayer;


    private Date gameDate;
}
