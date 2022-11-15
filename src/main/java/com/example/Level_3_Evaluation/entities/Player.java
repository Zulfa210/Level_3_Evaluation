package com.example.Level_3_Evaluation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @author Zulfa Attar
 */

@Data
@ToString(exclude = "playedGames")
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playerId;
    private String playerName;

    @OneToOne(mappedBy = "player", cascade = CascadeType.PERSIST)
    private Position playerPosition;


    private int playerHealth;
    private int playerTotalScore;
    private boolean isPlaying;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "player_id", referencedColumnName ="playerId" ),
    inverseJoinColumns = @JoinColumn(name = "game_played_id", referencedColumnName = "gameId"))
    private List<Game> playedGames;

    @JsonIgnore
    @OneToOne(mappedBy = "player")
    private Leaderboard positionOnLeaderBoard;

}
