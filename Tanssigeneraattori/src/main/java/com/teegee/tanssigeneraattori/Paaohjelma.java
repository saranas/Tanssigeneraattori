package com.teegee.tanssigeneraattori;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Akkanen
 */
public class Paaohjelma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        System.out.print("Valikoimassamme on seuraavat tanssilajit: \n"
                //TODO: lukee tiedostosta mitä vaihtoehtoja on olemassa ja panee ne tähän
                + "ECD \n"
                + "Anna tanssilaji: ");
        
        //String tanssilaji = lukija.nextLine();
        String tanssilaji = "ecd";
        System.out.println(tanssilaji);
        //Testauksen vuoksi koodattu syöte
        
        tanssilaji = tanssilaji.trim();
        tanssilaji = tanssilaji.toUpperCase();

        LiikevarastonKasittelija kasittelija = new LiikevarastonKasittelija("liikevarasto.txt");
        kasittelija.lue();

        System.out.println("Lajissa on tällaisia liikkeitä: \n");
        // "Valitse ja lisää mieleisesi koreografiaan"
        kasittelija.esitteleLiikkeet();
        System.out.println();
        
        System.out.print("Anna uuden tanssikoreografian nimi: ");
        
        //Testisyöte
        String tanssiKoreografianNimi = "Goddesses";
        System.out.println(tanssiKoreografianNimi);
        //String tanssiKoreografianNimi = lukija.nextLine();
        Koreografia uusiKoreografia = new Koreografia(tanssiKoreografianNimi);
        
        System.out.print(uusiKoreografia);
        System.out.println();
        System.out.println();
        
        while(true) {
            System.out.print("Lisää koreografiaan liikkeitä antamalla liikkeen nimi "
                    + "tai lopeta syöttämällä 'lopeta': ");
            String haluttuLiike = lukija.nextLine();
            haluttuLiike = haluttuLiike.replaceAll(" ", "").toLowerCase();
            
            if(haluttuLiike.equals("lopeta")) {
                break;
            }
            
            for (Liikesarja liikesarja : kasittelija.annaLiikevalikoima()) {
                if (liikesarja.getNimi().equals(haluttuLiike)) {
                    uusiKoreografia.getLiikkeet().add(liikesarja);
                }
            }
            
            uusiKoreografia.tulostaKoreografia();
            
        }

    }

}
