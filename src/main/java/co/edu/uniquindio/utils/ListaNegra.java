package co.edu.uniquindio.utils;

import co.edu.uniquindio.model.Contributor;

public class ListaNegra {
    private LinkedListCustom<Contributor> listaNegra = new LinkedListCustom<>();

    public void addContributor(Contributor contributor) {
        listaNegra.add(contributor);
    }

    public LinkedListCustom<Contributor> getListaNegra() {
        return listaNegra;
    }

}