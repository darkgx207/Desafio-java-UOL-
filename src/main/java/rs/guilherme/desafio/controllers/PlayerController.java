package rs.guilherme.desafio.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    @CrossOrigin(value = "http://localhost:8100")
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid PlayerDto user) {
        Player player = playerService.createNewPlayer(user);
        if (player == null) {
            return new ResponseEntity<>(player,HttpStatus.valueOf(204));
        }
        return new ResponseEntity<>(player,HttpStatus.valueOf(201));
    }

    @GetMapping
    @CrossOrigin(value = "http://localhost:8100")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return new ResponseEntity<>(playerService.getAllPlayers(),HttpStatus.valueOf(200));
    }
}
