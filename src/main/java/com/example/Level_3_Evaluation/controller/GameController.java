package com.example.Level_3_Evaluation.controller;

import com.example.Level_3_Evaluation.model.dto.FireDto;
import com.example.Level_3_Evaluation.model.dto.GameDto;
import com.example.Level_3_Evaluation.model.dto.MovePlayerDto;
import com.example.Level_3_Evaluation.model.dto.PlayerDto;
import com.example.Level_3_Evaluation.service.GameService;
import com.example.Level_3_Evaluation.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zulfa Attar
 */
@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    PlayerService playerService;

    @RequestMapping("/createPlayer")
    public ResponseEntity createPlayer(@RequestBody PlayerDto playerDto){
        try{
            return new ResponseEntity(playerService.createPlayer(playerDto), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/createGame")
    public ResponseEntity createGame(@RequestBody GameDto gameDto){
        try{
            return new ResponseEntity(gameService.createGame(gameDto), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/movePlayer")
    public ResponseEntity movePlayer(@RequestBody MovePlayerDto movePlayerDto){
        try{
            return new ResponseEntity(playerService.movePlayer(movePlayerDto), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/firePlayer")
    public ResponseEntity firePlayer(@RequestBody FireDto fireDto){
        try{
            return new ResponseEntity(playerService.firePlayer(fireDto), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
