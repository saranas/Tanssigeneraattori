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
            
            Tanssilaji laji = new Tanssilaji(splitattuRivi[0].trim().toLowerCase());
            String liikkeenNimi = splitattuRivi[1].trim().toLowerCase();
            int kesto = Integer.parseInt(splitattuRivi[2].trim());
            Tila alkutila = new Tila(splitattuRivi[3].trim().toLowerCase());
            Tila lopputila = new Tila(splitattuRivi[4].trim().toLowerCase());

            LiikeElementti liikeEle = new LiikeElementti(
                    laji, liikkeenNimi, kesto,
                    alkutila, lopputila);

            this.liikevalikoima.add(liikeEle);
        }

        lukija.close();
        System.out.println();
    }


}
