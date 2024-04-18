package rs.guilherme.desafio.services;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.guilherme.desafio.model.Player;
import rs.guilherme.desafio.model.dtos.UserDto;
import rs.guilherme.desafio.model.enums.HeroGroup;
import rs.guilherme.desafio.repositories.PlayerRepository;


@Service
public class PlayerService {

    private CodinameFetch codinameFetch;
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository, CodinameFetch codinameFetch) {
        this.playerRepository = playerRepository;
        this.codinameFetch = codinameFetch;
    }

    public Player createNewPlayer(UserDto user) {
        Player player = null;
        try {
            player = new Player();
            player.setHeroGroup(user.heroGroup());
            
            List<String> codinamesInUse = playerRepository.getUsedCodinames(player.getHeroGroup());
            System.out.println(codinamesInUse);
            List<String> codinames = ( player.getHeroGroup() == HeroGroup.AVENGERS 
                ? codinameFetch.getAvengersCodinames() 
                : codinameFetch.getJusticeLeagueCodinames() );

            codinames.removeAll(codinamesInUse);
            if (codinames.size() == 0) { return null; }

            int randInt = new Random().nextInt( codinames.size() );

            player.setName(user.name());
            player.setEmail(user.email());
            player.setName(user.name());
            player.setPhoneNumber(user.phoneNumber());
            player.setCodiname(codinames.get( randInt ));

            player = playerRepository.save(player);

        } catch(Exception e) { 
            e.printStackTrace();
            player = null; 
        }
        return player;
    }

}
