package liikkeidenmallinnus;

import java.util.ArrayList;

public class Liikesarja implements Liike {

    private Tanssilaji tanssilaji;
    private String nimi;
    private ArrayList<Liike> liikkeet;
    /**
     * Tyhjä arvo alku- ja lopputilaksi, 
     * jos listaan ei ole vielä lisätty mitään
     */
    public static Tila TYHJA_TILA = new Tila("tyhja");

    public Liikesarja(Tanssilaji tanssilaji, String nimi) {
        this.tanssilaji = tanssilaji;
        this.nimi = nimi;
        this.liikkeet = new ArrayList<Liike>();
    }

    public Tanssilaji getTanssilaji() {
        return tanssilaji;
    }

    public String getNimi() {
        return nimi;
    }
    
    /**
     * Metodi palauttaa Liikesarjan liikkeiden yhteiskeston, joka
     * on nolla, jos lista on tyhjä.
     * 
     * @return int Yhteiskesto
     */
    public int getKesto() {
        int kestoYhteensa = 0;
            for (Liike liike : this.liikkeet) {
                kestoYhteensa += liike.getKesto();
            }
        return kestoYhteensa;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return this.tanssilaji + this.nimi + this.getKesto()
                + this.getAlkutila() + this.getLopputila();
    }
    
    /**
     * Palauttaa Liikesarjan ensimmäisen liikkeen alkutilan, koska
     * se on näin ollen koko Liikesarjan alkutila. Jos liikkeitä
     * ei vielä ole lisätty, palauttaa tyhjän tilan.
     * 
     * @return listan ensimmäisen liikkeen alkutila
     */
    @Override
    public Tila getAlkutila() {
        if (liikkeet.isEmpty()) {
            return TYHJA_TILA;
        } else {
            return liikkeet.get(0).getAlkutila();
        }
    }
    
    /**
     * Palauttaa listan viimeisen liikkeen lopputilan, koska se
     * on näin ollen koko Liikesarjan lopputila. Jos liikkeitä
     * ei ole vielä lisätty, palauttaa tyhjän tilan.
     * 
     * @return listan viimeisen liikkeen lopputila
     */
    @Override
    public Tila getLopputila() {
        if (liikkeet.isEmpty()) {
            return TYHJA_TILA;
        } else {
            return liikkeet.get(liikkeet.size() - 1).getLopputila();
        }
    }
    
    /**
     * Metodi lisää Liike-olion Liikesarja-luokan liikkeet-listaan, mutta vain jos
     * listan viimeisen liikkeen lopputila ja lisättävän liikkeen alkutila
     * ovat yhteensopivat.
     * 
     * @param liike 
     * @return boolean Palauttaa true tai false sen mukaan onnistuiko lisäys
     */
    public boolean lisaaLiike(Liike liike) {
        
        if (liikkeet.isEmpty()) {
            liikkeet.add(liike);
            return true;
        }
        
        Tila alkutila = liike.getAlkutila();
        if (alkutila.equals(this.getLopputila())) {
            liikkeet.add(liike);
            return true;
        }
        return false;
    }
    
    /**
     * Metodi poistaa Liikesarjan liikkeet-listan viimeisen Liike-olion
     * 
     * @return poistettu liike tai ei mitään
     */
    public Liike poistaViimeisinLiike() {
        if (!liikkeet.isEmpty()) {
            return liikkeet.remove(liikkeet.size()-1);
        }
        return null;
    }

}
