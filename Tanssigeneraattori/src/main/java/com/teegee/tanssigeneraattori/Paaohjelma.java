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
        LiikevarastonKasittelija kasittelija = new LiikevarastonKasittelija("liikevarasto.txt");
        Tekstikayttoliittyma tekstikali = new Tekstikayttoliittyma(kasittelija, lukija);

        kasittelija.lue();

        tekstikali.esitteleTanssilajit();
        String tanssilaji = tekstikali.pyydaTanssilajia();
        tekstikali.esitteleLiikkeet(tanssilaji);

        System.out.print("Anna uuden tanssikoreografian nimi: ");
        String tanssiKoreografianNimi = lukija.nextLine();
        Koreografia uusiKoreografia = new Koreografia(tanssiKoreografianNimi);

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
