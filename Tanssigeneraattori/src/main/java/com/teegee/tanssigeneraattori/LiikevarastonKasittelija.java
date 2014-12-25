package com.teegee.tanssigeneraattori;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LiikevarastonKasittelija {

    private Scanner lukija;
    private File tiedosto;
    private ArrayList<Liike> liikevalikoima;

    public LiikevarastonKasittelija(String annettuTiedosto) {
        tiedosto = new File(annettuTiedosto);
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

            String[] splitattuRivi = rivi.split("|");
            for (String kohta : splitattuRivi) {
                kohta = kohta.trim();
            }

            Liikesarja liikesarja = new Liikesarja(
                    splitattuRivi[0], splitattuRivi[1],
                    Integer.parseInt(splitattuRivi[2]),
                    splitattuRivi[3], splitattuRivi[4]);

            liikevalikoima.add(liikesarja);

            //System.out.println(rivi);
        }

        lukija.close();
    }

}
