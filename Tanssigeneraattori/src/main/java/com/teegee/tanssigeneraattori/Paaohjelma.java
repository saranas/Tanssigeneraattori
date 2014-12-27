package com.teegee.tanssigeneraattori;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Akkanen
 */
public class Paaohjelma {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        System.out.print("Valikoimassamme on seuraavat tanssilajit: \n"
                //TODO: lukee tiedostosta mitä vaihtoehtoja on olemassa ja panee ne tähän
                + "ECD \nParapara \n"
                + "Anna tanssilaji: ");

        String tanssilaji = lukija.nextLine();
        //String tanssilaji = "ecd";
        System.out.println(tanssilaji);
        //Testauksen vuoksi koodattu syöte

        tanssilaji = tanssilaji.trim();
        tanssilaji = tanssilaji.toLowerCase();
        System.out.println(tanssilaji);

        LiikevarastonKasittelija kasittelija = new LiikevarastonKasittelija("liikevarasto.txt");
        kasittelija.lue();

        System.out.println("Lajissa on tällaisia liikkeitä: \n");
        // "Valitse ja lisää mieleisesi koreografiaan"
        kasittelija.esitteleLiikkeet(tanssilaji);
        System.out.println();

        System.out.print("Anna uuden tanssikoreografian nimi: ");

        //Testisyöte
        //String tanssiKoreografianNimi = "Goddesses";
        String tanssiKoreografianNimi = lukija.nextLine();
        System.out.println(tanssiKoreografianNimi);
        Koreografia uusiKoreografia = new Koreografia(tanssiKoreografianNimi);

        System.out.print(uusiKoreografia);
        System.out.println();
        System.out.println();

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
                    uusiKoreografia.getLiikkeet().add(liikesarja);
                }
            }

            uusiKoreografia.tulostaKoreografia();

        }
        

        System.out.println("\nHaluatko tallentaa? (y/n) ");
        while (true) {
            String tallennetaanko = lukija.nextLine();

            if (tallennetaanko.equals("y")) {
                
                String tallennettavanTiedostonNimi = uusiKoreografia.getNimi();
                tallennettavanTiedostonNimi = tallennettavanTiedostonNimi.concat(".txt");
                String koreografianSisalto = uusiKoreografia.annaKoreografiaTekstina();
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
