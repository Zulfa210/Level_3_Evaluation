package com.example.Level_3_Evaluation.exception;

/**
 * @author Zulfa Attar
 */

public class PositionOccupiedException extends RuntimeException{
    public PositionOccupiedException() {
        super("Position is already occupied");
    }
}
