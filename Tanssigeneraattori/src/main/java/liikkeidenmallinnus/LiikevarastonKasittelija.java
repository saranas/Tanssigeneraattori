package liikkeidenmallinnus;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Luokka lukee tiedostoa, johon informaatio eri tanssiliikkeistä on
 * tallennettu, ja antaa informaation eteenpäin.
 *
 * @author Akkanen
 */
public class LiikevarastonKasittelija {

    private Scanner lukija;
    private File tiedosto;
    private ArrayList<Liike> liikevalikoima;

    public LiikevarastonKasittelija(String annettuTiedosto) {
        this.tiedosto = new File(annettuTiedosto);
        this.liikevalikoima = new ArrayList<Liike>();
    }

    /**
     * Metodi palauttaa listan siitä, mitä eri tanssilajeja säiliötiedoston
     * liikkeet edustavat.
     *
     * @return
     */
    public ArrayList<Tanssilaji> annaTanssilajit() {
        ArrayList<Tanssilaji> tanssilajit;
        tanssilajit = new ArrayList<Tanssilaji>();
        for (Liike l : this.annaLiikevalikoima()) {
            if (!tanssilajit.contains(l.getTanssilaji())) {
                tanssilajit.add(l.getTanssilaji());
            }
        }
        return tanssilajit;
    }

    /**
     * Metodi palauttaa säiliötiedoston kohdat listana Liike-olioita.
     *
     * @return
     */
    public ArrayList<Liike> annaLiikevalikoima() {
        return this.liikevalikoima;
    }

    /**
     * Metodi palauttaa listan liikkeitä, joilla on sama laji, kuin
     * mikä on annettu parametrina.
     * 
     * @param valittulaji
     * @param pohjalista
     * @return lista liikkeitä valitun lajin mukaan
     */
    public ArrayList<Liike> suodataLajinMukaan(Tanssilaji valittulaji, ArrayList<Liike> pohjalista) {
        ArrayList<Liike> liikkeetLajinMukaan;
        liikkeetLajinMukaan = new ArrayList<Liike>();

        for (Liike liike : pohjalista) {
            if (liike.getTanssilaji().equals(valittulaji)) {
                liikkeetLajinMukaan.add(liike);
            }
        }
        return liikkeetLajinMukaan;
    }
    
    /**
     * Metodi palauttaa listan liikkeitä, joiden alkutila on 
     * sama kuin parametrina annetti tila.
     * 
     * @param tila
     * @param pohjalista
     * @return lista liikkeitä alkutilan mukaan
     */
    public ArrayList<Liike> suodataTilanMukaan(Tila tila, ArrayList<Liike> pohjalista) {
        ArrayList<Liike> liikkeetTilanMukaan;
        liikkeetTilanMukaan = new ArrayList<Liike>();
        
        for (Liike liike : pohjalista) {
            if (liike.getAlkutila().equals(tila)) {
                liikkeetTilanMukaan.add(liike);
            }
        }
        
        return liikkeetTilanMukaan;
    }

    /**
     * Metodi lukee liikevarasto-tiedostoa. Metodi muuntaa tiedostossa olevien
     * liikkeiden ominaisuudet sopivan- tyyppisiksi, ja luo niiden perusteella
     * uusia Liike-olioita, jotka lisätään tämän luokan listaan.
     */
    public void lue() {

        try {
            lukija = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return;
        }

        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();

            String[] splitattuRivi = rivi.split("\\|");

            Tanssilaji laji = new Tanssilaji(splitattuRivi[0].trim().toLowerCase());
            String liikkeenNimi = splitattuRivi[1].trim().toLowerCase();
            int kesto = Integer.parseInt(splitattuRivi[2].trim());
            Tila alkutila = new Tila(splitattuRivi[3].trim().toLowerCase());
            Tila lopputila = new Tila(splitattuRivi[4].trim().toLowerCase());

            LiikeElementti liikeEle = new LiikeElementti(
                    laji, liikkeenNimi, kesto,
                    alkutila, lopputila);

            this.liikevalikoima.add(liikeEle);
        }

        lukija.close();
    }

}
