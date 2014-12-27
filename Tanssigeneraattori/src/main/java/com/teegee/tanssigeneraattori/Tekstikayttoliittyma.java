package com.teegee.tanssigeneraattori;

import java.util.ArrayList;
import java.util.Scanner;

public class Tekstikayttoliittyma {

    private LiikevarastonKasittelija kasittelija;
    private Scanner lukija;

    public Tekstikayttoliittyma(LiikevarastonKasittelija annettuKasittelija, Scanner annettuLukija) {
        this.kasittelija = annettuKasittelija;
        this.lukija = annettuLukija;
    }

    public void esitteleTanssilajit() {
        ArrayList<String> tulostettavat;
        tulostettavat = new ArrayList<String>();
        System.out.print("Valikoimassamme on seuraavat tanssilajit: \n");
        for (Liikesarja l : kasittelija.annaLiikevalikoima()) {
            if (!tulostettavat.contains(l.getTanssilaji())) {
                tulostettavat.add(l.getTanssilaji());
            }
        }
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
            if (kasittelija.annaTanssilajitTekstina().contains(tanssilaji)) {
                break;
            }
            System.out.print("Anna jokin listalla olevista tanssilajeista: ");
        }
        return tanssilaji;
    }

}
