package com.example.Level_3_Evaluation.model.dto;

import lombok.Data;

/**
 * @author Zulfa Attar
 */
@Data
public class FireDto {

    private int xCoordinate;
    private int yCoordinate;
    private long gameId;
    private long firingPlayerId;
    private long opponentId;

}
