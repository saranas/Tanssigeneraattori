package com.teegee.tanssigeneraattori;

import java.util.ArrayList;
import java.util.Scanner;

public class Tekstikayttoliittyma {

    private LiikevarastonKasittelija kasittelija;
    private Scanner lukija;
    private Koreografia uusiKoreografia;

    public Tekstikayttoliittyma(LiikevarastonKasittelija annettuKasittelija, Scanner annettuLukija) {
        this.kasittelija = annettuKasittelija;
        this.lukija = annettuLukija;
    }

    public void esitteleTanssilajit() {
        System.out.print("Valikoimassamme on seuraavat tanssilajit: \n");
        ArrayList<String> tulostettavat;
        tulostettavat = kasittelija.annaTanssilajit();
        for (String tulostettava : tulostettavat) {
            System.out.println(tulostettava);
        }
        System.out.println();
    }

    public void esitteleLiikkeet(String tanssilaji) {
        System.out.println("\nLajissa on tällaisia liikkeitä.");
        System.out.println("Valitse ja lisää mieleisesi koreografiaan.\n");
        if (kasittelija.annaLiikevalikoima() != null) {
            for (Liikesarja liikesarja : kasittelija.annaLiikevalikoima()) {
                if (liikesarja.getTanssilaji().equals(tanssilaji)) {
                    System.out.println(liikesarja.getNimi()
                            + " (" + liikesarja.getKesto() + ")");
                }
            }
            System.out.println();
        } else {
            System.out.println("Liikkeitä valitulle lajille ei ollut.");
        }
    }

    public String pyydaTanssilajia() {
        System.out.print("Anna tanssilaji: ");

        String tanssilaji;
        while (true) {
            tanssilaji = this.lukija.nextLine();
            tanssilaji = tanssilaji.trim();
            tanssilaji = tanssilaji.toLowerCase();
            for (String laji : kasittelija.annaTanssilajit()) {
                if (laji.equals(tanssilaji)) {
                    return tanssilaji;
                }
            }
            System.out.print("Anna jokin listalla olevista tanssilajeista: ");
        }
    }
    
    public void pyydaKoreografianNimea() {
        System.out.print("Anna uuden tanssikoreografian nimi: ");
        String tanssiKoreografianNimi = lukija.nextLine();
        this.uusiKoreografia = new Koreografia(tanssiKoreografianNimi);
    }
    
    public void lisaaLiikkeita() {
        while (true) {
            System.out.print("Lisää koreografiaan liikkeitä antamalla liikkeen nimi "
                    + "tai lopeta syöttämällä 'lopeta': ");
            String haluttuLiike = lukija.nextLine();
            haluttuLiike = haluttuLiike.replaceAll(" ", "").toLowerCase();

            if (haluttuLiike.equals("lopeta")) {
                break;
            }

            for (Liikesarja liikesarja : kasittelija.annaLiikevalikoima()) {
                if (liikesarja.getNimi().equals(haluttuLiike)) {
                    this.uusiKoreografia.getLiikkeet().add(liikesarja);
                }
            }

            this.uusiKoreografia.tulostaKoreografia();

        }
    }
    
    public void kysyTallennetaanko() {
        System.out.println("\nHaluatko tallentaa? (y/n) ");
        while (true) {
            String tallennetaanko = lukija.nextLine();

            if (tallennetaanko.equals("y")) {

                String tallennettavanTiedostonNimi = this.uusiKoreografia.getNimi();
                tallennettavanTiedostonNimi = tallennettavanTiedostonNimi.concat(".txt");
                String koreografianSisalto = this.uusiKoreografia.annaKoreografiaTekstina();
                Tallentaja tallentaja = new Tallentaja();

                try {
                    tallentaja.kirjoitaTiedostoon(tallennettavanTiedostonNimi, koreografianSisalto);
                } catch (Exception e) {
                    System.out.println("Virhe " + e.getMessage());
                }

                System.out.println("Tallennus suoritettu");
                break;

            } else if (tallennetaanko.equals("n")) {
                break;
            } else {
                System.out.print("Anna y tai n: ");
            }
        }
    }

}
