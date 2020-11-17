package org.sci;

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
        Carte<String> c = new Carte<>();
        c.setNumeCarte("Beautiful Obilivion");
        c.setNumeAutor(new String[]{"Jamie McGuire"});
        c.setStare(true);
        c.setAnApartitie(2014);
        c.setNrPagini(320);
        c.setId(606717219);
        c.setEditura("Atria Books");
        //Arrays.toString() = este o metoda folosita pentru a returna o reprezentare string a unui array(vector)
        //Reprezentare string = este lista de elemente a vectorului, care se afla intre parantezele patrate[]
        System.out.println('\u0022' + c.getNumeCarte() + '\u0022' + " by " + Arrays.toString(c.getNumeAutor()).replace("[", "").replace("]", "") + ". Aceasta carte se afla in stoc: " + c.getStare());

        //c1 alt obiect de tipul Carte
        Carte<String> c1 = new Carte<String>();
        c1.setNumeCarte("Beautiful Redemption");
        c1.setNumeAutor(new String[]{"Jamie McGuire"});
        c1.setStare(false);
        c1.setEditura("Atria Books");
        c1.setAnApartitie(2015);
        c1.setNrPagini(260);
        c1.setId(1502541858);
        System.out.println('\u0022' + c1.getNumeCarte() + '\u0022' + " by " + Arrays.toString(c1.getNumeAutor()).replace("[", "").replace("]", "") + ". Aceasta carte se afla in stoc: " + c1.getStare());

        System.out.println("Cartile sunt egale: " + c.equals(c1)); //-> false = obiectele nu sunt egale(au acelasi autor, dar titlurile sunt diferie)
        System.out.println();

        //up-casting
        Carte c2 = (Carte) new Nuvela("mister");
        c2.setNumeCarte("Crima din Orient Express");
        c2.setNumeAutor(new String[]{"Agatha Christie"});
        c2.setNrPagini(250);
        c2.setAnApartitie(2008);
        c2.setEditura("RAO");
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
        System.out.println('\u0022' + r.getNumeCarte() + '\u0022' + " by " + Arrays.toString(r.getNumeAutor()).replace("[", "").replace("]", ""));
        System.out.println();


        //ARRAY
        System.out.println("---------------------------------------ARRAY----------------------------------------------");
        Carte[] carte = new Carte[2];
        for (int i = 0; i < carte.length; i++) {
            if (i == 0) {
                carte[i] = n;
            } else {
                carte[i] = new Roman("Maitreyi", new String[]{"Mircea Eliade"}, 175, 15);
            }
        }
        for (Carte ca : carte) {
            System.out.println("Cartea " + '\u0022' + ca.getNumeCarte() + '\u0022' + " este scrisa de " + Arrays.toString(ca.getNumeAutor()).replace("[", "").replace("]", ""));
        }
        System.out.println();


        //LIST -> VECTOR
        //afisarea titlurilor cartilor in ordinea in care au fost introduse in vector
        System.out.println("-----------------------------------LIST -> VECTOR-----------------------------------------");
        Vector<Carte> v = new Vector<>();
        v.add(n1);
        v.add(c1);
        for (Carte value : v) {
            System.out.print('\u0022' + value.getNumeCarte() + '\u0022' + "\n");
        }
        System.out.println();


        //LIST -> ARRAYLIST
        //afisarea preturilor in ordine crescatoare(de vazut metoda compare din clasa Rating)
        System.out.println("----------------------------------LIST -> ARRAYLIST---------------------------------------");
        List<Carte> lista = new ArrayList<>();
        c1.setPret(17.5);
        c.setPret(25.3);
        n.setPret(15.4);
        r.setPret(10.50);
        lista.add(n);
        lista.add(c1);
        lista.add(c);
        lista.add(r);
        lista.add(c2);
        c1.setMaterialCoperta("Carton");
        c.setMaterialCoperta("Foaie");
        r.setMaterialCoperta("Carton");

        //Collections.sort(lista, new Rating()); //-> sorteaza dupa pret
        lista.sort(Comparator.comparing(Carte::getNumeCarte)); //-> sorteaza in ordine alfabetica
        for (Carte f : lista) {
            System.out.println(f.getPret());
        }
        System.out.println();


        //SET -> HASHSET
        System.out.println("-----------------------------------SET -> HASHSET-----------------------------------------");
        Set<Carte> hash_Set = new HashSet<>();
        hash_Set.add(n);
        hash_Set.add(c);
        hash_Set.add(r);
        hash_Set.add(n);
        hash_Set.add(c1);

        for (Carte s : hash_Set) {
            System.out.println(s.getNumeCarte()); //am adaugat 5 tipuri de carti, dar s-au afisat doar 4 deoarece n este de 2 ori
        }

        System.out.println("-------------------------------Parcurgerea cu Iterator------------------------------------");
        Iterator<Carte> it = hash_Set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getNumeCarte());
        }
        System.out.println();


        //MAP -> HASHMAP
        System.out.println("-----------------------------------MAP -> HASHMAP-----------------------------------------");
        HashMap<String, Carte> prescurtareNumeCarte = new HashMap<>();
        prescurtareNumeCarte.put("MN", n);
        prescurtareNumeCarte.put("M", r);
        prescurtareNumeCarte.put("BO", c);

        for (String i : prescurtareNumeCarte.keySet()) {
            System.out.println(i);
        }

        System.out.println("-------------------------------Parcurgerea cu Iterator------------------------------------");
        Iterator<Map.Entry<String, Carte>> itr = prescurtareNumeCarte.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Carte> set = itr.next();
            System.out.println(set.getKey() + " = " + set.getValue().getNumeCarte());
        }
        System.out.println();
        System.out.println();

        //GENERICE
        //Apelare metodele "afisareCarti" din afara clasei
        afisareCarti1(hash_Set);
        afisareCarti2(lista); //lista este ordonata alfabetic dupa numele cartilor


        List<Nuvela> nuvelaList = new ArrayList<>();
        nuvelaList.add(n);
        nuvelaList.add(n1);

        adaugaNuvela(nuvelaList);

        afisareCarti2(nuvelaList);

        calcValoare(nuvelaList);
        calcValoare(lista);


        List<Roman> listaRomane = new ArrayList<>();
        listaRomane.add(r);

        afisareCarti2(listaRomane);
    }

    //IN AFARA MAIN-ULUI

    //GENERICE
    public static void afisareCarti1(Set<Carte> book) {
        System.out.println("---------------------------------------Folosind SET---------------------------------------");
        for (Carte cr : book) {
            System.out.println("Nume: " + cr.getNumeCarte());
            System.out.println("Autor: " + Arrays.toString(cr.getNumeAutor()).replace("[", "").replace("]", ""));
            System.out.println("An aparitiei: " + cr.getAnApartitie());
            System.out.println("Editura: " + cr.getEditura());
            System.out.println("ISBN: " + cr.getId());
            System.out.println("Stare: " + cr.getStare());
            System.out.println("Pret: " +cr.getPret());
            System.out.println("Numar de pagini: " + cr.getNrPagini());
            System.out.println("Tip coperta: " + cr.getMaterialCoperta());
            if (cr instanceof Roman) {
                System.out.println("Numar capitole: " + ((Roman) cr).getNrCapitole());
            }
            if (cr instanceof Nuvela) {
                System.out.println("Gen: " + ((Nuvela) cr).getGen());
            }
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();
        }
    }

    //UPPER BOUNDED WILDCARD
    public static void afisareCarti2(List<? extends Carte> books) {
        System.out.println("-------------------------------Folosind LIST (ordonata alfabetic)-------------------------");
        for (Carte cr : books) {
            System.out.println("Nume: " + cr.getNumeCarte());
            System.out.println("Autor: " + Arrays.toString(cr.getNumeAutor()).replace("[", "").replace("]", ""));
            System.out.println("An aparitiei: " + cr.getAnApartitie());
            System.out.println("Editura: " + cr.getEditura());
            System.out.println("ISBN: " + cr.getId());
            System.out.println("Stare: " + cr.getStare());
            System.out.println("Pret: " +cr.getPret());
            System.out.println("Numar de pagini: " + cr.getNrPagini());
            System.out.println("Tip coperta: " + cr.getMaterialCoperta());
            if (cr instanceof Roman) {
                System.out.println("Numar capitole: " + ((Roman) cr).getNrCapitole());
            }
            if (cr instanceof Nuvela) {
                System.out.println("Gen: " + ((Nuvela) cr).getGen());
            }
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();
        }
    }

    //LOWER BOUND WILDCARD
    public static void adaugaNuvela(List<? super Nuvela> nvl) {
        nvl.add(new Nuvela("N/A"));
    }

    public static void calcValoare(List<? super Nuvela> nvl) {
        Iterator<Carte> it = (Iterator<Carte>) nvl.iterator();
        double valoare = 0;
        while (it.hasNext()) {
            valoare += it.next().getPret();
        }
        System.out.println("Valoarea totala a listei este: " + valoare);
        System.out.println();
    }
}


