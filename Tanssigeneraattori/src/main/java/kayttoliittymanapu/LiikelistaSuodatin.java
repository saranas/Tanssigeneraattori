package kayttoliittymanapu;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JList;
import liikkeidenmallinnus.Koreografia;
import liikkeidenmallinnus.Liike;
import static liikkeidenmallinnus.Liikesarja.TYHJA_TILA;
import liikkeidenmallinnus.LiikevarastonKasittelija;
import liikkeidenmallinnus.Tanssilaji;

/**
 * Luokka toimii apuvälineenä painikkeiden ja lajivalikon kuuntelijoille,
 * koska ne kaikki joutuvat tarkastamaan ja päivittämään useita samoja kenttiä.
 * 
 * @author Akkanen
 */
public class LiikelistaSuodatin {

    private JComboBox lajivalikko;
    private Koreografia koreografia;
    private Taulukontekija taulukoija;
    private LiikevarastonKasittelija kasittelija;
    private JList liikelista;

    public LiikelistaSuodatin(JComboBox lajivalikko, Koreografia koreografia, 
            Taulukontekija taulukoija, LiikevarastonKasittelija kasittelija, JList liikelista) {
        this.lajivalikko = lajivalikko;
        this.koreografia = koreografia;
        this.taulukoija = taulukoija;
        this.kasittelija = kasittelija;
        this.liikelista = liikelista;
    }   
    
    /**
     * Metodi päivittää liikelistan näyttämään ainoastaan ne liikkeet,
     * joihin on mahdollista lähteä viimeisimpänä lisätystä liikkeestä.
     * Metodi ottaa huomioon mikä tanssilaji on sillä hetkellä valittuna.
     * 
     * @return suodatettu lista liikkeitä
     */
    public String[] suodata() {
        ArrayList<Liike> suodatettavaLista = kasittelija.annaLiikevalikoima();

        if (koreografia.getLopputila() != TYHJA_TILA) {
            suodatettavaLista = kasittelija.suodataTilanMukaan(koreografia.getLopputila(), suodatettavaLista);
        }
        
        String valittulaji;
        valittulaji = (String) lajivalikko.getSelectedItem();
        
        if (valittulaji.equals("kaikki")) {
            return taulukoija.annaLiikkeetTaulukkona(suodatettavaLista);
        }
        
        Tanssilaji laji = new Tanssilaji(valittulaji);
        
        suodatettavaLista = kasittelija.suodataLajinMukaan(laji, suodatettavaLista);
        return taulukoija.annaLiikkeetTaulukkona(suodatettavaLista);
    }

}
