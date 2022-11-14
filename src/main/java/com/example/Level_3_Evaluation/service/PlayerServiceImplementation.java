package com.example.Level_3_Evaluation.service;

import com.example.Level_3_Evaluation.entities.Game;
import com.example.Level_3_Evaluation.entities.Player;
import com.example.Level_3_Evaluation.entities.Position;
import com.example.Level_3_Evaluation.exception.PositionOccupiedException;
import com.example.Level_3_Evaluation.model.dto.FireDto;
import com.example.Level_3_Evaluation.model.dto.MovePlayerDto;
import com.example.Level_3_Evaluation.model.dto.PlayerDto;
import com.example.Level_3_Evaluation.repository.GameRepository;
import com.example.Level_3_Evaluation.repository.PlayerRepository;
import com.example.Level_3_Evaluation.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import static java.time.LocalDateTime.*;

/**
 * @author Zulfa Attar
 */
@Service
public class PlayerServiceImplementation implements PlayerService {


    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    GameRepository gameRepository;
    @Override
    public Player createPlayer(PlayerDto playerDto) {
        try {
            Player player = new Player();
            player.setPlayerName(playerDto.getPlayerName());
            player.setPlayerHealth(0);
            player.setPlaying(false);
            player.setPlayerPosition(null);
            player.setPlayerTotalScore(0);
            player.setPlayedGames(new ArrayList<>());


            return playerRepository.save(player);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Game firePlayer(FireDto fireDto) {

        Player firingPlayer = playerRepository.findById(fireDto.getFiringPlayerId()).orElse(null);
        Player opponentPlayer = playerRepository.findById(fireDto.getFiringPlayerId()).orElse(null);
        Game game =  gameRepository.findById(fireDto.getGameId()).orElse(null);

        if(fireDto.getXCoordinate() == opponentPlayer.getPlayerPosition().getPlayerPositionYCoordinate()
        && fireDto.getYCoordinate() == opponentPlayer.getPlayerPosition().getPlayerPositionYCoordinate()){
            int score = firingPlayer.getPlayerTotalScore();
            firingPlayer.setPlayerTotalScore(score+ 20);

            if(firingPlayer.getPlayerTotalScore()  == 100){


               if(game != null){
                   game.setWinningPlayer(firingPlayer);
               }
               firingPlayer.setPlayerPosition(null);
               opponentPlayer.setPlayerPosition(null);
               firingPlayer.setPlaying(false);
               opponentPlayer.setPlaying(false);
               positionRepository .delete(positionRepository.findByPlayer(firingPlayer));
               positionRepository.delete(positionRepository.findByPlayer(opponentPlayer));


            }
        }
        playerRepository.save(firingPlayer);
        playerRepository.save(opponentPlayer);
        return gameRepository.save(game);

    }

    @Override
    public int movePlayer(MovePlayerDto movePlayerDto) {
        Player player = playerRepository.findById(movePlayerDto.getPlayerId()).orElse(null);

        if(player!=null){
            Position position = positionRepository.findByPlayerPositionXCoordinateAndPlayerPositionYCoordinate(
                    movePlayerDto.getXCoordinate(),
                    movePlayerDto.getYCoordinate()
            ).orElse(null);


            if(position.getPlayer() != null){
                throw new PositionOccupiedException();
            }else{

                Position existingPosition = player.getPlayerPosition();
                if(existingPosition.getPlayerPositionXCoordinate() - movePlayerDto.getXCoordinate() >1 ||
                        existingPosition.getPlayerPositionYCoordinate() - movePlayerDto.getYCoordinate() >1||
                        existingPosition.getPlayerPositionXCoordinate() - movePlayerDto.getXCoordinate() <-1 ||
                        existingPosition.getPlayerPositionYCoordinate() - movePlayerDto.getYCoordinate() <-1) {
                   return 0;
                }else{
                    player.setPlayerPosition(position);
                    position.setPlayer(player);
                    playerRepository.save(player);
                    positionRepository.save(position);
                    return 1;
                }
            }

        }
        return 0;
    }


}
