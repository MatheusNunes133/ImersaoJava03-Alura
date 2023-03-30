package org.codigo.refatorando.interfaces;

import org.codigo.refatorando.classes.Conteudo;

import java.util.List;

public interface DataExtract {

    List<Conteudo> dataExtract(String json);
}
