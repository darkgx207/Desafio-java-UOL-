package rs.guilherme.desafio.services;

import org.springframework.stereotype.Service;

import rs.guilherme.desafio.model.dtos.UserDto;
import rs.guilherme.desafio.repositories.UserRepository;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    private UserDto createNewPlayer(UserDto user) {

    }

}
