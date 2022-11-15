package com.example.Level_3_Evaluation.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Zulfa Attar
 */
@Entity
@Data
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long leaderBoardId;


    @OneToOne
    @JoinColumn(referencedColumnName = "playerId", name = "player_id")
    private Player player;

    private int playerScore;

    private int playerRank;
}
