package TP2;

import java.util.Comparator;

public class CompareCarte implements Comparator<Carte> {

    @Override
    public int compare(Carte o1, Carte o2) {
        if (o1.getValeur() < o2.getValeur())
            return -1;
        else
            return 1;
    }
}
