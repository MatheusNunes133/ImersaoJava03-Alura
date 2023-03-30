package org.codigo.refatorando;

import org.codigo.refatorando.ClientHttp.ClientHttp;
import org.codigo.refatorando.classes.Conteudo;
import org.codigo.refatorando.classes.StickerFactory;
import org.codigo.refatorando.dataExtract.NasaDataExtract;
import org.codigo.refatorando.interfaces.DataExtract;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{

        String url = "https://api.nasa.gov/planetary/apod?api_key=WBzxnHew6tp1Hswq0uzHfbJ9kMYErO4uCirWMNbA&start_date=2021-08-27&end_date=2021-08-28";
        var httpClient = new ClientHttp();
        String json = httpClient.dataFinder(url);

        //DataExtract nasaDataExtract = new NasaDataExtract();
        List<Conteudo> list = new NasaDataExtract().dataExtract(json);
        StickerFactory stickerFactory = new StickerFactory();

        for(Conteudo conteudo : list){
            stickerFactory.generateImage(conteudo.getUrlImage(), conteudo.getTitle());
        }
    }
}