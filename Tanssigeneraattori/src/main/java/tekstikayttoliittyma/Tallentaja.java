package tekstikayttoliittyma;

import java.io.FileWriter;

/**
 * Luokka kirjoittaa tekstitiedostoon ohjelmassa luodun koreografian.
 * 
 * @author Akkanen
 */
public class Tallentaja {
    
    public void kirjoitaTiedostoon(String tiedostonNimi, String teksti) throws Exception {
        FileWriter kirjoittaja = new FileWriter(tiedostonNimi);
        kirjoittaja.write(teksti);
        kirjoittaja.close();
    }

}
