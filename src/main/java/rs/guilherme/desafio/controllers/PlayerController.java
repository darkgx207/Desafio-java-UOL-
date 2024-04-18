package rs.guilherme.desafio.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import rs.guilherme.desafio.model.Player;
import rs.guilherme.desafio.model.dtos.PlayerDto;
import rs.guilherme.desafio.services.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {
    
    private PlayerService playerService;

    public PlayerController( PlayerService playerService) {
        this.playerService = playerService;
    }


    @PostMapping
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid PlayerDto user) {
        Player player = playerService.createNewPlayer(user);
        if (player == null) {
            return new ResponseEntity<>(player,HttpStatus.valueOf(400));
        }
        return new ResponseEntity<>(player,HttpStatus.valueOf(201));
    }
}
