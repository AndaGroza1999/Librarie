package org.sci.model;

import org.sci.interfaces.UserInterface;

public class Utilizator extends Carte implements UserInterface {
    String numeUtilizator; //package-private
    String parola; //package-private
    String eMail; //package-private
    String stareCont; // online/offline   //package-private
    Carte[] carti; //package-private

    //Constructor default/fara parametrii
    public Utilizator() {
        numeUtilizator = "Anonim";
        parola = "1234";
        eMail = "anonim@ceva.altceva";
        stareCont = "offline";
        carti = new Carte[]{};
    }

    //Metoda pentru conectarea la cont
    public void login(String userName, String pasw) {
        if (numeUtilizator != null && parola != null) {
            if (numeUtilizator == userName && parola == pasw) {
                System.out.println("Autentificarea s-a efectuat cu succes!");
            } else {
                System.out.println("Username-ul sau parola au fost intoduse gresit!");
            }
        }
    }

    //Getters and Setters
    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getStareCont() {
        return stareCont;
    }

    public void setStareCont(String stareCont) {
        this.stareCont = stareCont;
    }
}
