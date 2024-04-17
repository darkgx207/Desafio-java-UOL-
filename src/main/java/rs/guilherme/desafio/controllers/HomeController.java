package rs.guilherme.desafio.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.guilherme.desafio.services.CodinameFetch;


@RestController @RequestMapping("/")
public class HomeController {
    private CodinameFetch cod;


    public HomeController(CodinameFetch cod) {
        this.cod = cod;
    }

    @GetMapping("/1")
    public List<String> getAvengersCodinames() {
        return cod.getAvengersCodinames();
    }

    @GetMapping("/2")
    public List<String> getJLCodinames() {
        return cod.getJusticeLeagueCodinames();
    }
}












    // @GetMapping("/i")
    // public String getPro() {
    //     String url = env.getProperty("apiexterna.urlavengers");
    //     return url;
    // }