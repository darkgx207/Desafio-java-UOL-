package rs.guilherme.desafio.model.codinames;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.Data;


@Data
@JacksonXmlRootElement(localName = "liga_da_justica")
public class JusticeLeague {

    @JacksonXmlElementWrapper public List<Codinome> codinomes;

    
    public static class Codinome {
        @JacksonXmlText public String codinome;
}
}

