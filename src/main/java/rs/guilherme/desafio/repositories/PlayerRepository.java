package rs.guilherme.desafio.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.guilherme.desafio.model.Player;
import rs.guilherme.desafio.model.enums.HeroGroup;

public interface PlayerRepository extends JpaRepository<Player,Long> {
    
    @Query( value = "SELECT p.codiname FROM Players p WHERE p.HeroGroup = ?1 GROUP BY p.codiname" )
    List<String> getUsedCodinames(HeroGroup group);
}

