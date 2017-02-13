package com.jhf;

import java.util.*;



public class PortalGra {
    private PomocnikGry pomocnik = new PomocnikGry();
    private ArrayList<Portal> listaPortali = new ArrayList<Portal>();
    private int iloscRuchow = 0;

    private void przygotujGre() {
        //tworzymy portale i okreslamy ich polozenie
        Portal pierwszy = new Portal();
        pierwszy.setNazwa("pornhub.com");
        Portal drugi = new Portal();
        drugi.setNazwa("youporn.com");
        Portal trzeci = new Portal();
        trzeci.setNazwa("redtube.com");
        listaPortali.add(pierwszy);
        listaPortali.add(drugi);
        listaPortali.add(trzeci);

        System.out.println("Twoim celem jest zatopienie trzech portali.");
        System.out.println("pornhub.com, youporn.com, redtube.com");
        System.out.println("Postaraj się je zatopić w jak najmniejszej ilości ruchów.");
        System.out.println("Portale mają współrzędne od a0 do g6");

        for (Portal rozmieszczanyPortal : listaPortali) {
            ArrayList<String> nowePolozenie = pomocnik.rozmiescPortal(3);
            rozmieszczanyPortal.setPolaPolozenia(nowePolozenie);
        } // end for
    } // end przygotujGre

    private void rozpocznijGre() {
        while (!listaPortali.isEmpty()) {
            String ruchGracza = pomocnik.pobierzDaneWejsciowe("Podaj pole:");
            sprawdzRuchGracza(ruchGracza);
        } // end while
    } // end rozpocznijGre

    private void sprawdzRuchGracza(String ruch) {
        iloscRuchow++;
        String wynik = "pudlo";

        for (Portal portalDosprawdzenia : listaPortali) {
            wynik = portalDosprawdzenia.sprawdz(ruch);
            if (wynik.equals("trafiony")) {
                break;
            }
            if (wynik.equals("zatopiony")) {
                listaPortali.remove(portalDosprawdzenia);
                break;
            }
        } // end for
        System.out.println(wynik);
    } // sprawdzRuchGracza

    private void zakonczGre() {
        System.out.println("Wszystkie portale zostały zatopione!");
        if (iloscRuchow <= 18) {
            System.out.println("Wykonales jedynie " + iloscRuchow + " ruchów.");
            System.out.println("Zwycięstwo!");
        }
        else {
            System.out.println("Strasznie sie grzebales! Zajelo Ci to az " + iloscRuchow + " ruchów!");
            System.out.println("Przegrałeś!");
        }
    } // end zakonczGre

    public static void main(String[] args) {
        PortalGra gra = new PortalGra();
        gra.przygotujGre();
        gra.rozpocznijGre();
        gra.zakonczGre();
    }
}
