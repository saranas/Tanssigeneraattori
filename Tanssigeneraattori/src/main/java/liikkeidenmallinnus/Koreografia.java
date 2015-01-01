package liikkeidenmallinnus;

import java.util.ArrayList;

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
                koreografiaTekstina = koreografiaTekstina.concat(this.koreografianLiikkeet.get(i).getNimi());
                koreografiaTekstina = koreografiaTekstina.concat("\n");
            } else {
                koreografiaTekstina = koreografiaTekstina.concat(this.koreografianLiikkeet.get(i).getNimi());
                koreografiaTekstina = koreografiaTekstina.concat(" ");
            }
        }
        koreografiaTekstina = koreografiaTekstina.concat("\nTanssin kesto " + this.tanssinKesto() + " iskua");
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
