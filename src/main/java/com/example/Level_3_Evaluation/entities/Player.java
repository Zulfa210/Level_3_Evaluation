package com.example.Level_3_Evaluation.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Zulfa Attar
 */

@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playerId;
    private String playerName;

    @OneToOne(mappedBy = "player")
    private Position playerPosition;


    private int playerHealth;
    private int playerTotalScore;
    private boolean isPlaying;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = @JoinColumn(name = "player_id", referencedColumnName ="playerId" ),
    inverseJoinColumns = @JoinColumn(name = "game_played_id", referencedColumnName = "gameId"))
    private List<Game> playedGames;

}
