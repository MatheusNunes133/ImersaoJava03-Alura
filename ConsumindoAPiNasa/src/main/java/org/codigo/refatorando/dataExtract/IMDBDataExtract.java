package org.codigo.refatorando.dataExtract;

import org.codigo.refatorando.JsonParser.JsonParser;
import org.codigo.refatorando.classes.Conteudo;
import org.codigo.refatorando.interfaces.DataExtract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IMDBDataExtract implements DataExtract {

    @Override
    public List<Conteudo> dataExtract(String json){
        var jsonParser = new JsonParser().parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        for(Map<String,String> atributos : jsonParser){
            String title = atributos.get("title");
            String urlImage = atributos.get("image")
                    .replaceAll("(@+)(.*).jpg", "$1.jpg");

            var conteudo = new Conteudo(title, urlImage);
            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
