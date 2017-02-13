package com.jhf;
/**
 * Created by Witold on 13.02.2017.
 * super
 */

import java.util.*;

public class Portal {
    private ArrayList<String> polaPolozenia;
    private String nazwa;

    public void setPolaPolozenia(ArrayList<String> ppol) {
        polaPolozenia = ppol;
    }

    public void setNazwa(String nzwPortalu){
        nazwa = nzwPortalu;
    }

    public String sprawdz(String ruch) {
        String wynik = "pudlo";
        int indeks = polaPolozenia.indexOf(ruch);
        if (indeks >= 0) {
            polaPolozenia.remove(indeks);

            if(polaPolozenia.isEmpty()) {
                wynik = "zatopiony";
                System.out.println("Auć! Zatopiłeś portal: " + nazwa + " :(");
            }
            else {
                wynik = "trafiony";
            } // end if
        } // end if
        return wynik;
    } // end sprawdz
} // end com.jhf.Portal
