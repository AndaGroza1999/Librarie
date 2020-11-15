package org.sci.util;

import org.sci.model.Carte;

import java.util.Comparator;

public class Rating implements Comparator<Carte> {

    @Override
    public int compare(Carte o1, Carte o2) {
        if (o1.equals(o2)){
            return 0;
        }
        if (o1.getPret() > o2.getPret()){
            return 1;
        }
        return -1;
    }
}
