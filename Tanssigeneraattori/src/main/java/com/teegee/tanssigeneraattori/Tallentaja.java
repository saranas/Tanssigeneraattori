package com.teegee.tanssigeneraattori;

import java.io.FileWriter;

public class Tallentaja {
    
    public void kirjoitaTiedostoon(String tiedostonNimi, String teksti) throws Exception {
        FileWriter kirjoittaja = new FileWriter(tiedostonNimi);
        kirjoittaja.write(teksti);
        kirjoittaja.close();
    }

}
