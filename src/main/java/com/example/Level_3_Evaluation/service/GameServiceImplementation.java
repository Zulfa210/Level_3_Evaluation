package com.example.Level_3_Evaluation.service;

import com.example.Level_3_Evaluation.entities.Game;
import com.example.Level_3_Evaluation.entities.Player;
import com.example.Level_3_Evaluation.entities.Position;
import com.example.Level_3_Evaluation.model.dto.GameDto;
import com.example.Level_3_Evaluation.repository.GameRepository;
import com.example.Level_3_Evaluation.repository.PlayerRepository;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @author Zulfa Attar
 */
@Service
public class GameServiceImplementation implements GameService{


    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    @Override
    public Game createGame(GameDto gameDto) {

        try {
            Game game = new Game();
            Player firstPlayer = playerRepository.findById(gameDto.getFirstPlayerId()).orElse(null);
            System.out.println(firstPlayer);
            Player secondPlayer = playerRepository.findById(gameDto.getSecondPlayerId()).orElse(null);
            System.out.println(secondPlayer);
            if(firstPlayer!=null && secondPlayer!= null) {
                game.setGameName(gameDto.getGameName());
                game.setFirstPlayer(firstPlayer);
                game.setSecondPlayer(secondPlayer);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:sss");
                game.setGameDate(format.parse(String.valueOf(LocalDateTime.now())));

                Position firstPlayerPosition = new Position();
                firstPlayerPosition.setPlayerPositionXCoordinate(0);
                firstPlayerPosition.setPlayerPositionXCoordinate(0);
                firstPlayerPosition.setPlayer(firstPlayer);
                firstPlayer.setPlayerPosition(firstPlayerPosition);
                firstPlayer.setPlaying(true);
                firstPlayer.setPlayerHealth(100);
                firstPlayer.getPlayedGames().add(game);


                Position secondPlayerPosition = new Position();
                secondPlayerPosition.setPlayerPositionXCoordinate(0);
                secondPlayerPosition.setPlayerPositionXCoordinate(10);
                secondPlayerPosition.setPlayer(secondPlayer);
                secondPlayer.setPlayerPosition(secondPlayerPosition);
                secondPlayer.setPlaying(true);
                secondPlayer.setPlayerHealth(100);
                secondPlayer.getPlayedGames().add(game);
                return gameRepository.save(game);
            }
            return null;

        }catch (Exception e){
            return null;
        }
    }
}
