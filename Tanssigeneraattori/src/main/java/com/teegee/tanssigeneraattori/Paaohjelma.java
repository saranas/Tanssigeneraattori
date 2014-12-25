/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        System.out.println("Valikoimassamme on seuraavat tanssilajit: \n"
                //TODO: lukee tiedostosta mitä vaihtoehtoja on olemassa ja panee ne tähän
                + "ECD \n"
                + "Anna tanssilaji: ");
        
        //String tanssilaji = lukija.nextLine();
        String tanssilaji = "ecd";
        System.out.println(tanssilaji);
        //Testauksen vuoksi koodattu syöte
        
        tanssilaji = tanssilaji.trim();
        tanssilaji = tanssilaji.toUpperCase();

//        if (tanssilaji.equals("ECD")) {
//            LiikevarastonKasittelija kasittelija = new LiikevarastonKasittelija("liikevarasto.txt");
//            kasittelija.lue();
//        } else {
//            System.out.println("Antamaasi tanssilajia ei löytynyt. Anna toinen: ");
//            
//        }
        LiikevarastonKasittelija kasittelija = new LiikevarastonKasittelija("liikevarasto.txt");
        kasittelija.lue();

        System.out.println("Lajissa on tällaisia liikkeitä: \n");
        // "Valitse ja lisää mieleisesi koreografiaan"
        if (kasittelija.annaLiikevalikoima() != null) {
            for (Liike liike : kasittelija.annaLiikevalikoima()) {
                if (liike.getTanssilaji().equals(tanssilaji)) {
                    System.out.println(liike.getNimi());
                }
            }
        } else {
            System.out.println("Oli null");
        }
        
        
        Koreografia tanssi1 = new Koreografia(tanssilaji);
        System.out.println(tanssi1);

    }

}
