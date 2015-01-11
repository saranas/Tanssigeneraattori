package liikkeidenmallinnus;

import java.util.ArrayList;

/**
 * Luokka säilöö käyttäjän koreografiaan valitsemat liikkeet Liikesarja-olioon.
 * 
 * @author Akkanen
 */
public class Koreografia {

    private String nimi;
    private Liikesarja tanssikoreografia;

    public Koreografia(String nimi) {
        this.nimi = nimi;
        this.tanssikoreografia = new Liikesarja(nimi);
    }

    public ArrayList<Liike> getKoreografianLiikkeet() {
        return this.tanssikoreografia.getLiikkeet();
    }
    
    /**
     * Metodi lisää Liike-olion Koreografian liikelistaan, mutta vain
     * jos listan viimeisen liikkeen lopputila ja lisättävän liikkeen alkutila
     * ovat yhteensopivat.
     *
     * @param liike
     * @return Palauttaa true tai false sen mukaan onnistuiko lisäys
     */
    public boolean lisaaLiike(Liike liike) {
        return this.tanssikoreografia.lisaaLiike(liike);
    }
    
    /**
     * Metodi poistaa viimeisimpänä lisätyn liikkeen.
     * Jos liikkeitä ei ole lisätty, palauttaa null.
     *
     * @return poistettu liike tai ei mitään
     */
    public Liike poistaViimeisinLiike() {
        return this.tanssikoreografia.poistaViimeisinLiike();
    }
    
    /**
     * Palauttaa listan viimeisen liikkeen lopputilan, koska se on näin ollen
     * koko Koreografian lopputila. Jos liikkeitä ei ole vielä lisätty, palauttaa
     * tyhjän tilan.
     *
     * @return Liikesarjan viimeisen liikkeen lopputila
     */
    public Tila getLopputila() {
        return this.tanssikoreografia.getLopputila();
    }
    
    /**
     * Metodi laskee ja palauttaa koreografian liikkeiden 
     * yhteiskeston iskuina. 
     * 
     * @return liikkeiden yhteiskesto
     */
    public int tanssinKesto() {
        return this.tanssikoreografia.getKesto();
    }
    
    /**
     * Metodi muuntaa Liikesarjan ArrayListin sisältämien Liikkeiden
     * nimet helppolukuiseksi muotoilluksi tekstiksi. 
     * 
     * @return koreografian liikkeet Stringinä
     */
    public String annaKoreografiaTekstina() {
        String koreografiaTekstina = this.getNimi() + "\n\n";
        for (int i = 0; i < getKoreografianLiikkeet().size(); i++) {
            koreografiaTekstina = koreografiaTekstina + this.getKoreografianLiikkeet().get(i).getNimi() + "\n";
//            if (i % 2 != 0 || i == 1) {
//                koreografiaTekstina = koreografiaTekstina + 
//                        this.getKoreografianLiikkeet().get(i).getNimi() + "\n";
//            } else {
//                koreografiaTekstina = koreografiaTekstina + 
//                        this.getKoreografianLiikkeet().get(i).getNimi() + " ";
//            }
        }
        //koreografiaTekstina = koreografiaTekstina + "\nTanssin kesto " + this.tanssinKesto() + " iskua";
        return koreografiaTekstina;       
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
