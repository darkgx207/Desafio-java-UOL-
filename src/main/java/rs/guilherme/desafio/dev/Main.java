package rs.guilherme.desafio.dev;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import rs.guilherme.desafio.model.codinames.JusticeLeague;

public class Main {
    public static void main(String[] args) throws Exception {
        String xml = """
            <liga_da_justica>
                <codinomes>
                    <codinome>Lanterna Verde</codinome>
                    <codinome>Flash</codinome>
                    <codinome>Aquaman</codinome>
                    <codinome>Batman</codinome>
                    <codinome>Superman</codinome>
                    <codinome>Mulher Maravilha</codinome>
                </codinomes>
            </liga_da_justica>
                """;

        // XmlMapper mapper = new XmlMapper();
        var mapper = XmlMapper.builder().defaultUseWrapper(false).build();

        JusticeLeague jl = mapper.readValue(xml, JusticeLeague.class);
        System.out.println(jl);
    }
}
