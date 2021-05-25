package model;

import java.util.Comparator;

public class SortPret implements Comparator<Reteta> {
    public int compare(Reteta a, Reteta b) {
        return a.getPret() - b.getPret();
    }
}