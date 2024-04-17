package rs.guilherme.desafio.model.codinames;

import java.util.List;

import lombok.Data;

@Data
public class Avengers {
    public List<Vingadores> vingadores;

    public static class Vingadores {
        public String codinome;
    }
}

