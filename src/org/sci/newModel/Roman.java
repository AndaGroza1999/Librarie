package org.sci.newModel;

import org.sci.model.Carte;

public class Roman extends Carte {
    int nrCapitole;

    //Constructor cu 4 parametrii
    public Roman(String numC, String[] numeAutor, int nrPag, int nrCapitole) {
        super(numC, numeAutor, nrPag); //-> am aplelat constructorul din clasa parinte
        this.nrCapitole = nrCapitole;
    }

    //Getters and Setters
    public int getNrCapitole() {
        return nrCapitole;
    }

    public void setNrCapitole(int nrCapitole) {
        this.nrCapitole = nrCapitole;
    }
}
