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
            for (String kohta : splitattuRivi) {
                kohta = kohta.trim();
            }
            
            Liikesarja liikesarja = new Liikesarja(
                    splitattuRivi[0], splitattuRivi[1],
                    splitattuRivi[2],
                    splitattuRivi[3], splitattuRivi[4]);

            this.liikevalikoima.add(liikesarja);
            System.out.println();
            //System.out.println(liikevalikoima.size());
            //System.out.println(splitattuRivi[1]);
            //System.out.println(liikesarja.getNimi());
        }

        lukija.close();
        System.out.println(this.liikevalikoima.size());
    }

}
