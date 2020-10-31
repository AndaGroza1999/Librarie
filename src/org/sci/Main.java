package org.sci;

import org.sci.newModel.Nuvela;
import org.sci.model.Carte;
import org.sci.model.Plata;
import org.sci.model.Utilizator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //CARTE
        //c un obiect de tipul Carte
        Carte c = new Carte();
        c.setNumeCarte("Beautiful Obilivion");
        c.setNumeAutor(new String[]{"Jamie McGuire"});
        c.setStare(true);
        //Arrays.toString() = este o metoda folosita pentru a returna o reprezentare string a unui array(vector)
        //Reprezentare string = este lista de elemente a vectorului, care se afla intre parantezele patrate[]
        System.out.println(c.getNumeCarte() + " by " + Arrays.toString(c.getNumeAutor()) + ". Aceasta carte se afla in stoc: " + c.getStare());

        //c1 alt obiect de tipul Carte
        Carte c1 = new Carte();
        c1.setNumeCarte("Beautiful Redemption");
        c1.setNumeAutor(new String[]{"Jamie McGuire"});
        c1.setStare(false);
        System.out.println(c1.getNumeCarte() + " by " + Arrays.toString(c1.getNumeAutor()) + ". Aceasta carte se afla in stoc: " + c1.getStare());

        System.out.println("Cartile sunt egale: " + c.equals(c1)); //-> false = obiectele nu sunt egale(au acelasi autor, dar titlurile sunt diferie)

        //UTILIZATOR
        //u un obiect de tipul Utilizator
        Utilizator u = new Utilizator();
        u.setNumeUtilizator("Anonim123");
        u.setParola("1234");
        //u.login("Mihai","1597");  //-> autentificare esuata
        u.login("Anonim123", "1234"); //-> autentificare efectuata cu scucces
        System.out.println(u.geteMail());


        //NUVELA
        //n un obiect de tipul Nuvela
        Nuvela n = new Nuvela("crima");
        System.out.println(n.getNumeCarte() + n.getGen());
        n.setNumeCarte("Ion");
        n.setNumeAutor(new String[]{"Liviu Rebreanu"});
        n.setEditura("Biblioteca Adevarul");
        n.afisare();


        //PLATA
        //p un obiect de tipul Plata
        Plata p = new Plata();
        p.setCantitate(5);
        p.setPret(15.25);
        System.out.println(p.calculareValoare(p.getCantitate())); //-> ((5 * 15.25) * 0.19) + (5 * 15.25) = 90.73
        p.calculInFunctieDeMoneda("DOLAR", 5); //-> (15.25 * 5) * 0.19 + (15.25 * 5)) * 4.1 = 372.023
    }
}
