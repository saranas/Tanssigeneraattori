package kayttoliittymanapu;

import java.util.ArrayList;
import liikkeidenmallinnus.Liike;
import liikkeidenmallinnus.Tanssilaji;

/**
 * Luokka on apuväline, joka muuttaa ArrayListit taulukoiksi.
 * 
 * @author Akkanen
 */
public class Taulukontekija {
    
    /**
     * Metodi muuttaa annetun ArrayListin taulukoksi.
     * @param vanhalista
     * @return 
     */
    public String[] annaLiikkeetTaulukkona(ArrayList<Liike> vanhalista) {
        String[] uusitaulukko = new String[vanhalista.size()];
        for (int i = 0; i < vanhalista.size(); i++) {
            uusitaulukko[i] = vanhalista.get(i).getNimi();
        }
        return uusitaulukko;
    }
    
    /**
     * Metodi muuttaa annetun ArrayListin taulukoksi.
     * @param vanhalista
     * @return 
     */
    public String[] annaLajitTaulukkona(ArrayList<Tanssilaji> vanhalista) {
        String[] uusitaulukko = new String[vanhalista.size()];
        for (int i = 0; i < vanhalista.size(); i++) {
            uusitaulukko[i] = vanhalista.get(i).getNimi();
        }
        return uusitaulukko;
    }

}
