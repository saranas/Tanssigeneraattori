package tekstikayttoliittyma;

import java.io.FileWriter;

/**
 * Luokka kirjoittaa tekstitiedostoon ohjelmassa luodun koreografian.
 * 
 * @author Akkanen
 */
public class Tallentaja {
    
    /**
     * Metodi kirjoittaa annetun Stringin tiedostoon.
     * 
     * @param tiedostonNimi
     * @param teksti
     * @throws Exception 
     */
    public void kirjoitaTiedostoon(String tiedostonNimi, String teksti) throws Exception {
        FileWriter kirjoittaja = new FileWriter(tiedostonNimi);
        kirjoittaja.write(teksti);
        kirjoittaja.close();
    }

}
