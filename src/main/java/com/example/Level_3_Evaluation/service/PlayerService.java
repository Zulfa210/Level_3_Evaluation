package com.example.Level_3_Evaluation.service;

import com.example.Level_3_Evaluation.entities.Game;
import com.example.Level_3_Evaluation.entities.Player;
import com.example.Level_3_Evaluation.entities.Position;
import com.example.Level_3_Evaluation.model.dto.FireDto;
import com.example.Level_3_Evaluation.model.dto.MovePlayerDto;
import com.example.Level_3_Evaluation.model.dto.PlayerDto;

/**
 * @author Zulfa Attar
 */
public interface PlayerService {
    public Player createPlayer(PlayerDto playerDto);

    public Game firePlayer(FireDto fireDto);

    public int movePlayer(MovePlayerDto movePlayerDto);

}
