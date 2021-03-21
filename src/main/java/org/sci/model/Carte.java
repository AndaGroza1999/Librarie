package org.sci.model;

import java.util.Arrays;
import java.util.Objects;

public class Carte {
    protected int id;
    private String numeCarte;
    private String[] numeAutor;
    private int anApartitie;
    private int nrPagini;
    private Double pret;
    private boolean stare; //true - in stoc; false - nu se mai afla in stoc(out of stock)
    private String editura;
//    private m materialCoperta;

    //Constructor default/fara parametrii
    public Carte() {
        this(1900);
        this.id = 0;
        this.numeCarte = "N/A";
        this.numeAutor = new String[]{"N/A"};
        //this.anApartitie = 1900;
        this.nrPagini = 0;
        this.pret = 0.0;
        this.stare = false;
        this.editura = "N/A";
    }

//    public Carte()
//    {
//        this("UNDPNR",new String[]{"N/A"}, 253);
//    }

    //Constructor cu 1 parametru
    public Carte(int anApar) {
        anApartitie = anApar;
    }

//    public Carte(m materialCoperta) {
//        this.materialCoperta = materialCoperta;
//    }

    //Constructor cu 3 parametrii
    public Carte(String numC, String[] numeAutor, int nrPag) {
        numeCarte = numC;
        this.numeAutor = numeAutor; //Shadowing
        nrPagini = nrPag;
    }

    private void bookMethod() {
        System.out.println("bookMethod();");
    }


    //Comparam 2 carti intre ele
    @Override
    public boolean equals(Object obj) {

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            Carte recovedCarte = (Carte) obj;
            return id == recovedCarte.id &&
                    anApartitie == recovedCarte.anApartitie &&
                    nrPagini == recovedCarte.nrPagini &&
                    stare == recovedCarte.stare &&
                    Objects.equals(numeCarte, recovedCarte.numeCarte) &&
                    Arrays.equals(numeAutor, recovedCarte.numeAutor) &&
                    Objects.equals(pret, recovedCarte.pret) &&
                    Objects.equals(editura, recovedCarte.editura);
        }
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, numeCarte, anApartitie, nrPagini, pret, stare, editura);
        result = 31 * result + Arrays.hashCode(numeAutor);
        return result;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeCarte() {
        return numeCarte;
    }

    public void setNumeCarte(String numeCarte) {
        this.numeCarte = numeCarte;
    }

    public String[] getNumeAutor() {
        return numeAutor;
    }

    public void setNumeAutor(String[] numeAutor) {
        this.numeAutor = numeAutor;
    }

    public int getAnApartitie() {
        return anApartitie;
    }

    public void setAnApartitie(int anApartitie) {
        this.anApartitie = anApartitie;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public boolean getStare() {
        return stare;
    }

    public void setStare(boolean stare) {
        this.stare = stare;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

//    public m getMaterialCoperta() {
//        return materialCoperta;
//    }
//
//    public void setMaterialCoperta(m materialCoperta) {
//        this.materialCoperta = materialCoperta;
//    }

}
