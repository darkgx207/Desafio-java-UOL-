package rs.guilherme.desafio.controllers;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import rs.guilherme.desafio.model.dtos.UserDto;

@RestController
@RequestMapping("/player")
public class PlayerController {
    
    @PostMapping
    public ResponseEntity<UserDto> createNewPlayer(@RequestBody @Valid UserDto user) {

        return null;
    }
}
