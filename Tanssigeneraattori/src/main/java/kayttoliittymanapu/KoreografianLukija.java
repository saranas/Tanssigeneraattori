package kayttoliittymanapu;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import liikkeidenmallinnus.Koreografia;
import liikkeidenmallinnus.Liike;
import liikkeidenmallinnus.LiikevarastonKasittelija;

/**
 * Luokka lukee tiedostoon tallennetun koreografian ohjelmaan muokkausta varten.
 * 
 * @author Akkanen
 */
public class KoreografianLukija {
    private Scanner lukija;
    private LiikevarastonKasittelija kasittelija;

    public KoreografianLukija(LiikevarastonKasittelija kasittelija) {
        this.kasittelija = kasittelija;
    }
    
    /**
     * Metodi lukee annetun tiedoston, ja asettaa sen sisällön koreografiaan.
     * 
     * @param tiedosto
     * @return 
     */
    public Koreografia lueKoreografia(File tiedosto) {
        Koreografia luettuKoreografia = new Koreografia(" ");

        try {
            lukija = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return luettuKoreografia;
        }
        
        ArrayList<String> luetutliikkeet = new ArrayList<String>();
        while (lukija.hasNextLine()) {
            String luettuliike = lukija.nextLine();
            luetutliikkeet.add(luettuliike);
        }
        
        for (String luettuliike : luetutliikkeet) {
            if (luetutliikkeet.indexOf(luettuliike) == 0) {
                luettuKoreografia.setNimi(luettuliike);
            } else if (luetutliikkeet.indexOf(luettuliike) != 1) {
                for (Liike liike : kasittelija.annaLiikevalikoima()) {
                    if (liike.getNimi().equals(luettuliike)) {
                        luettuKoreografia.lisaaLiike(liike);
                    }
                }
            }
        }

        lukija.close();
        return luettuKoreografia;
    }
}
