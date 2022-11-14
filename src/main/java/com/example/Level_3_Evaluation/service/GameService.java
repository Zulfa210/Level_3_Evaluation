package com.example.Level_3_Evaluation.service;

import com.example.Level_3_Evaluation.entities.Game;
import com.example.Level_3_Evaluation.entities.Player;
import com.example.Level_3_Evaluation.model.dto.GameDto;

/**
 * @author Zulfa Attar
 */
public interface GameService {
    public Game createGame(GameDto gameDto);

}
