package org.sci.model;

import org.sci.interfaces.PayInterface;

public class Plata extends Carte implements PayInterface {
    private String tip;
    private String moneda; //in ce moneda se face plata euro $ ron etc
    private int cantitate;
    private final double TVA = 0.19; //const-ul din c++


    //Metoda calculare valoare
    public Double calculareValoare(int cantitate) {
        return ((getPret() * cantitate) * TVA) + (getPret() * cantitate);
    }

    @Override
    public void calculInFunctieDeMoneda(String tipMoneda) {
        switch (tipMoneda)
        {
            case "RON":
                break;
            case "EURO":
                break;
            case "DOLAR":
                break;
            default:
                break;

        }
    }

    //Getters and Setters
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

}
