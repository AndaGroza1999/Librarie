package org.sci.newModel;

import org.sci.model.Carte;

import java.util.Arrays;

public class Nuvela extends Carte {
    String gen;

    //Constructor cu 1 parametru //super cu paranteze(super();)
    public Nuvela(String gen) {
        super(); //am apelat constructorul fara parametrii/default din parinte(clasa Carte)
        this.gen = gen;
    }

    //Getters and Setters
    public String getGen() {
        return ", genul: " + gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getId() {
        return id = 101;
    }

    //super cu punct(super.getId())
    public void afisare() {
        System.out.println("Cartea " + this.getNumeCarte() + " scrisa de " + Arrays.toString(this.getNumeAutor()) + " cu id-ul " + super.getId() + " a fost publicata in anul " +
                this.getAnApartitie() + ", la editura " + this.getEditura()); // id-ul este 0
        System.out.println("Cartea " + this.getNumeCarte() + " scrisa de " + Arrays.toString(this.getNumeAutor()) + " cu id-ul " + this.getId() + " a fost publicata in anul " +
                this.getAnApartitie() + ", la editura " + this.getEditura()); // id-ul este 101
    }
}
