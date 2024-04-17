package rs.guilherme.desafio.repositories;


import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
    
    @Query( value = "select count(u) from user u where u.codiname = ?1")
    int getGroupIDUsed(String codiname);
}

