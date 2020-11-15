package org.sci.model;

import org.sci.interfaces.PayInterface;

public class Plata extends Carte implements PayInterface {
    private String tip;
    private String moneda; //in ce moneda se face plata euro $ ron etc
    private int cantitate;
    private final double TVA = 0.19; //const-ul din c++

    //Metoda calculare valoare comanda
    public Double calculareValoare(int cantitate) {
        return ((getPret() * cantitate) * TVA) + (getPret() * cantitate);
    }

    //Metoda calculare valoare comanda in functie de moneda in care se face plata
    public void calculInFunctieDeMoneda(String tipMoneda, int cantitate) {
        switch (tipMoneda)
        {
            case "RON":
                System.out.println(((getPret() * cantitate) * TVA + (getPret() * cantitate)));
                break;
            case "EURO":
                System.out.println(((getPret() * cantitate) * TVA + (getPret() * cantitate)) * 4.5);
                break;
            case "DOLAR":
                System.out.println(((getPret() * cantitate) * TVA + (getPret() * cantitate)) * 4.1);
                break;
            default:
                System.out.println("Eroare!!");
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
