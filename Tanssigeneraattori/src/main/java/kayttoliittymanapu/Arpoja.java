package kayttoliittymanapu;

import java.util.ArrayList;
import java.util.Random;
import liikkeidenmallinnus.Koreografia;
import liikkeidenmallinnus.Liike;
import liikkeidenmallinnus.Liikesarja;
import liikkeidenmallinnus.LiikevarastonKasittelija;
import liikkeidenmallinnus.Tanssilaji;

/**
 * Luokka tarjoaa metodin, joka arpoo satunnasista liikkeistä koostuvan koreografian,
 * ja sille satunnaisen nimen Sanakasa-luokan avulla. 
 * 
 * @author Akkanen
 */
public class Arpoja {

    private LiikevarastonKasittelija kasittelija;
    private Random random;
    private Sanakasa sanakasa = new Sanakasa();

    public Arpoja(LiikevarastonKasittelija kasittelija) {
        this.kasittelija = kasittelija;
        this.random = new Random();
    }
    
    /**
     * Metodi arpoo satunnaisen koreografian ja asettaa sen katseltavaksi
     * ja muokattavaksi ohjelmaan.
     * 
     * @param laji
     * @return 
     */
    public Koreografia arvoKoreografia(Tanssilaji laji) {
        ArrayList<Liike> liikevalikoima = kasittelija.annaLiikevalikoima();
        if (!laji.getNimi().equals("kaikki")) {
            liikevalikoima = kasittelija.suodataLajinMukaan(laji, liikevalikoima);
        }
        String randomNimi = this.arvoNimi();
        Koreografia randomKoreografia = new Koreografia(randomNimi);

        if (laji.equals("ecd") || laji.equals("parapara")) {

            //Tehdään 4 kpl 8 + 8 iskua pitkiä liikesarjoja
            //Toinen kaseista on toisto
            //Toimii melko hyvin kaavamaisille paraparalle ja ecd:lle
            for (int i = 0; i < 4; i++) {
                int fraasinKesto = 0;
                Liikesarja fraasi = new Liikesarja(laji, String.valueOf(i));
                while (fraasinKesto <= 8) {
                    Liike randomLiike = liikevalikoima.get(random.nextInt(liikevalikoima.size()));
                    if (fraasinKesto + randomLiike.getKesto() <= 8) {
                        fraasi.lisaaLiike(randomLiike);
                        fraasinKesto += randomLiike.getKesto();
                    }
                }
                randomKoreografia.lisaaLiike(fraasi);
                randomKoreografia.lisaaLiike(fraasi);
            }
        } else {
            //Ei toistoa. Sopii vientitansseille.
            int tanssinKesto = 0;
            while (tanssinKesto < 16 * 4) {

                Liike randomLiike = liikevalikoima.get(random.nextInt(liikevalikoima.size()));
                if (tanssinKesto + randomLiike.getKesto() <= 16 * 4) {
                    randomKoreografia.lisaaLiike(randomLiike);
                    tanssinKesto += randomLiike.getKesto();
                }

            }

        }
        return randomKoreografia;
    }
    
    /**
     * Metodi pyytää Sanakasa-luokalta satunnaiset sanat, ja antaa ne.
     * 
     * @return 
     */
    public String arvoNimi() {
        return sanakasa.annaAdjektiivi() + " " + sanakasa.annaSubstantiivi();
    }

}
