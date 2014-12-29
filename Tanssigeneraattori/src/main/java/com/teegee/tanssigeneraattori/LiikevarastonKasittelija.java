package com.teegee.tanssigeneraattori;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LiikevarastonKasittelija {

    private Scanner lukija;
    private File tiedosto;
    private ArrayList<Liike> liikevalikoima;

    public LiikevarastonKasittelija(String annettuTiedosto) {
        this.tiedosto = new File(annettuTiedosto);
        this.liikevalikoima = new ArrayList<Liike>();
    }
    
    public ArrayList<Tanssilaji> annaTanssilajit() {
        ArrayList<Tanssilaji> tanssilajit;
        tanssilajit = new ArrayList<Tanssilaji>();
        for (Liike l : this.annaLiikevalikoima()) {
            if (!tanssilajit.contains(l.getTanssilaji())) {
                tanssilajit.add(l.getTanssilaji());
            }
        }
        return tanssilajit;
    }

    public ArrayList<Liike> annaLiikevalikoima() {
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

            LiikeElementti liikeEle = new LiikeElementti(
                    trimmattuRivi[0], trimmattuRivi[1],
                    trimmattuRivi[2],
                    trimmattuRivi[3], trimmattuRivi[4]);

            this.liikevalikoima.add(liike);
        }

        lukija.close();
        System.out.println();
    }


}
