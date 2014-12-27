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
    
    public String annaTanssilajitTekstina() {
        String tanssilajit = "";
        for (Liikesarja l : this.liikevalikoima) {
            //System.out.println(l.getTanssilaji());
            tanssilajit = tanssilajit.concat(l.getTanssilaji());
            tanssilajit = tanssilajit.concat("\n");
        }
        return tanssilajit;
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


}
