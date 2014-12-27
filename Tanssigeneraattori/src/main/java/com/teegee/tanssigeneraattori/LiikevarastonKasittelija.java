package com.teegee.tanssigeneraattori;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LiikevarastonKasittelija {

    private Scanner lukija;
    private File tiedosto;
    private ArrayList<Liikesarja> liikevalikoima;

    public LiikevarastonKasittelija(String annettuTiedosto) {
        this.tiedosto = new File(annettuTiedosto);
        this.liikevalikoima = new ArrayList<Liikesarja>();
    }

    public ArrayList<Liikesarja> annaLiikevalikoima() {
        return this.liikevalikoima;
    }

    public void lue() {

        try {
            lukija = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return;
        }

        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();

            String[] splitattuRivi = rivi.split("\\|");
            String[] trimmattuRivi = new String[splitattuRivi.length];

            for (int i = 0; i < splitattuRivi.length; i++) {
                trimmattuRivi[i] = splitattuRivi[i].trim().toLowerCase();
            }

            Liikesarja liikesarja = new Liikesarja(
                    trimmattuRivi[0], trimmattuRivi[1],
                    trimmattuRivi[2],
                    trimmattuRivi[3], trimmattuRivi[4]);

            this.liikevalikoima.add(liikesarja);
        }

        lukija.close();
        System.out.println();
    }

    public void esitteleLiikkeet(String tanssilaji) {
        if (this.annaLiikevalikoima() != null) {
            for (Liikesarja liikesarja : this.annaLiikevalikoima()) {
                if (liikesarja.getTanssilaji().equals(tanssilaji)) {
                    System.out.println(liikesarja.getNimi()
                            + " (" + liikesarja.getKesto() + ")");
                }
            }
        }
    }

}
