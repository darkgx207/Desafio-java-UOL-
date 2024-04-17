package rs.guilherme.desafio.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import rs.guilherme.desafio.model.codinames.Avengers;
import rs.guilherme.desafio.model.codinames.JusticeLeague;




@Service
public class CodinameFetch {
    
    @Value("${apiexterna.urljusticeleague}")
    private String urlJusticeleague;

    @Value("${apiexterna.urlavengers}")
    private String urlAvengers;

    ObjectMapper mapper;
    RestTemplate restTemplate = new RestTemplate();


    public List<String> getAvengersCodinames() {
        Avengers avengers = null;
        mapper = new ObjectMapper();
        List<String> retorno = new ArrayList<>();
        String resp = restTemplate.getForObject( urlAvengers, String.class);

        try { avengers = mapper.readValue(resp, Avengers.class); } 
        catch (Exception e) { e.printStackTrace(); }


        avengers.getVingadores().forEach(vingador -> retorno.add(vingador.codinome));

        return retorno;
    }


    public List<String> getJusticeLeagueCodinames() {
        JusticeLeague justiceLeague = null;
        List<String> retorno = new ArrayList<>();
        String resp = restTemplate.getForObject( urlJusticeleague, String.class);
        mapper = new XmlMapper();

        try { justiceLeague = mapper.readValue(resp, JusticeLeague.class); }
        catch (Exception e) { e.printStackTrace(); }

        System.out.println(justiceLeague);

        justiceLeague.getCodinomes().forEach(x -> retorno.add(x.codinome));

        return retorno;
    }

}

