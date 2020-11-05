package org.sci;

import org.sci.Util.Rating;
import org.sci.newModel.Nuvela;
import org.sci.model.Carte;
import org.sci.model.Plata;
import org.sci.model.Utilizator;
import org.sci.newModel.Roman;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println();
        //CARTE
        //c un obiect de tipul Carte
        Carte c = new Carte();
        c.setNumeCarte("Beautiful Obilivion");
        c.setNumeAutor(new String[]{"Jamie McGuire"});
        c.setStare(true);
        //Arrays.toString() = este o metoda folosita pentru a returna o reprezentare string a unui array(vector)
        //Reprezentare string = este lista de elemente a vectorului, care se afla intre parantezele patrate[]
        System.out.println('\u0022' + c.getNumeCarte() + '\u0022' + " by " + Arrays.toString(c.getNumeAutor()).replace("[", "").replace("]", "") + ". Aceasta carte se afla in stoc: " + c.getStare());

        //c1 alt obiect de tipul Carte
        Carte c1 = new Carte();
        c1.setNumeCarte("Beautiful Redemption");
        c1.setNumeAutor(new String[]{"Jamie McGuire"});
        c1.setStare(false);
        System.out.println('\u0022' + c1.getNumeCarte() + '\u0022' + " by " + Arrays.toString(c1.getNumeAutor()).replace("[", "").replace("]", "") + ". Aceasta carte se afla in stoc: " + c1.getStare());

        System.out.println("Cartile sunt egale: " + c.equals(c1)); //-> false = obiectele nu sunt egale(au acelasi autor, dar titlurile sunt diferie)
        System.out.println();

        //up-casting
        Carte c2 = (Carte) new Nuvela("mister");
        c2.setNumeCarte("Crima din Orient Express");
        c2.setNumeAutor(new String[]{"Agatha Christie"});
        System.out.println('\u0022' + c2.getNumeCarte() + '\u0022' + " by " + Arrays.toString(c2.getNumeAutor()).replace("[", "").replace("]", "") + " //up-casting");
        System.out.println();

        //UTILIZATOR
        //u un obiect de tipul Utilizator
        Utilizator u = new Utilizator();
        u.setNumeUtilizator("Anonim123");
        u.setParola("1234");
        //u.login("Mihai","1597");  //-> autentificare esuata
        u.login("Anonim123", "1234"); //-> autentificare efectuata cu scucces
        System.out.println(u.geteMail());
        System.out.println();

        //NUVELA
        //n un obiect de tipul Nuvela
        Nuvela n = new Nuvela("crima");
        System.out.println(n.getNumeCarte() + n.getGen());
        n.setNumeCarte("Moara cu noroc");
        n.setNumeAutor(new String[]{"Ioan Slavici"});
        n.setEditura("Biblioteca Adevarul");
        n.afisare();
        System.out.println();

        //down-casting
        Nuvela n1 = (Nuvela) c2;
        System.out.println('\u0022' + n1.getNumeCarte() + '\u0022' + " by " + Arrays.toString(n1.getNumeAutor()).replace("[", "").replace("]", "") + n1.getGen() + " //down-casting");
        System.out.println();

        //PLATA
        //p un obiect de tipul Plata
        Plata p = new Plata();
        p.setCantitate(5);
        p.setPret(15.25);
        System.out.println(p.calculareValoare(p.getCantitate())); //-> ((5 * 15.25) * 0.19) + (5 * 15.25) = 90.73
        p.calculInFunctieDeMoneda("DOLAR", 5); //-> (15.25 * 5) * 0.19 + (15.25 * 5)) * 4.1 = 372.023
        System.out.println();

        //ROMAN
        //r un obiect de tip Roman
        Roman r = new Roman("Maitreyi", new String[]{"Mircea Eliade"}, 175, 15);

        Carte[] carte = new Carte[2];
        for (int i = 0; i < carte.length; i++) {
            if (i == 0) {
                carte[i] = n;
            } else {
                carte[i] = new Roman("Maitreyi", new String[]{"Mircea Eliade"}, 175, 15);
            }
        }
        for (int i = 0; i < carte.length; i++) {
            System.out.println("Cartea " + '\u0022' + carte[i].getNumeCarte() + '\u0022' + " este scrisa de " + Arrays.toString(carte[i].getNumeAutor()).replace("[", "").replace("]", ""));
        }
        System.out.println();

        Vector<Carte> v = new Vector<Carte>();
        v.add(n1);
        v.add(c1);
        for (int i = 0; i < v.size(); i++) {
            System.out.print('\u0022' + v.get(i).getNumeCarte() + '\u0022' + "\n");
        }

        List<Carte> lista = new ArrayList<>();
        c1.setPret(17.5);
        c.setPret(894.4);
        c2.setPret(85.4);
        lista.add(c1);
        lista.add(c);
        lista.add(c2);

        Collections.sort(lista, new Rating());
        for(Carte f : lista) {
            System.out.println(f.getPret());
        }
    }

}


