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

        Koreografia tanssi1 = new Koreografia("Jenkka");

        System.out.println(tanssi1);
        Scanner lukija;

        File tiedosto = new File("liikevarasto.txt");
        try {
            lukija = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return;
        }

        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            System.out.println(rivi);
        }

        lukija.close();

    }

}
