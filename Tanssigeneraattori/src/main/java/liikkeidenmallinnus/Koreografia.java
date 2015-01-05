package liikkeidenmallinnus;

import java.util.ArrayList;
import static liikkeidenmallinnus.Liikesarja.TYHJA_TILA;

/**
 * Luokka säilöö käyttäjän koreografiaan valitsemat liikkeet listaan.
 * 
 * @author Akkanen
 */
public class Koreografia {

    private String nimi;
    private ArrayList<Liike> koreografianLiikkeet;

    public Koreografia(String nimi) {
        this.nimi = nimi;
        this.koreografianLiikkeet = new ArrayList<Liike>();
    }

    public ArrayList<Liike> getKoreografianLiikkeet() {
        return this.koreografianLiikkeet;
    }
    
    /**
     * Metodi lisää Liike-olion Koreografian liikelistaan, mutta vain
     * jos listan viimeisen liikkeen lopputila ja lisättävän liikkeen alkutila
     * ovat yhteensopivat.
     *
     * @param liike
     * @return boolean Palauttaa true tai false sen mukaan onnistuiko lisäys
     */
    public boolean lisaaLiike(Liike liike) {

        if (koreografianLiikkeet.isEmpty()) {
            koreografianLiikkeet.add(liike);
            return true;
        }

        Tila alkutila = liike.getAlkutila();
        if (alkutila.equals(this.getLopputila())) {
            koreografianLiikkeet.add(liike);
            return true;
        }
        return false;
    }
    
    
    /**
     * Palauttaa listan viimeisen liikkeen lopputilan, koska se on näin ollen
     * koko Liikesarjan lopputila. Jos liikkeitä ei ole vielä lisätty, palauttaa
     * tyhjän tilan.
     *
     * @return listan viimeisen liikkeen lopputila
     */
    public Tila getLopputila() {
        if (koreografianLiikkeet.isEmpty()) {
            return TYHJA_TILA;
        } else {
            return koreografianLiikkeet.get(koreografianLiikkeet.size() - 1).getLopputila();
        }
    }
    
    /**
     * Metodi laskee ja palauttaa koreografian liikkeiden 
     * yhteiskeston iskuina. 
     * 
     * @return liikkeiden yhteiskesto
     */
    public int tanssinKesto() {
        int kestoYhteensa = 0;
        for (Liike liike : this.koreografianLiikkeet) {
            kestoYhteensa += liike.getKesto();
        }
        return kestoYhteensa;
    }
    
    /**
     * Metodi muuntaa luokan ArrayListin sisältämien Liikkeiden
     * nimet helppolukuiseksi muotoilluksi tekstiksi. 
     * 
     * @return koreografian liikkeet Stringinä
     */
    public String annaKoreografiaTekstina() {
        String koreografiaTekstina = this.getNimi() + "\n\n";
        for (int i = 0; i < koreografianLiikkeet.size(); i++) {
            if (i % 2 != 0 || i == 1) {
                koreografiaTekstina = koreografiaTekstina + 
                        this.koreografianLiikkeet.get(i).getNimi() + "\n";
            } else {
                koreografiaTekstina = koreografiaTekstina + 
                        this.koreografianLiikkeet.get(i).getNimi() + " ";
            }
        }
        //koreografiaTekstina = koreografiaTekstina + "\nTanssin kesto " + this.tanssinKesto() + " iskua";
        return koreografiaTekstina;
        
    }
    
    /**
     * Metodi tulostaa koreografian tekstimuodossa.
     */
    public void tulostaKoreografia() {
        System.out.println();
        System.out.println(this.annaKoreografiaTekstina());
        System.out.println();
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return "Koreografia: " + nimi;
    }

}
