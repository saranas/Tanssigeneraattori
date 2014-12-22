package com.teegee.tanssigeneraattori;

import java.io.File;
import java.util.Scanner;

public class LiikevarastonKasittelija {
    
    private Scanner lukija;
    File tiedosto = new File("liikevarasto.txt");
    
    public void lue() {
        
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
