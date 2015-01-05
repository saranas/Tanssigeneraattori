package kayttoliittymanapu;

import liikkeidenmallinnus.LiikevarastonKasittelija;
import java.util.ArrayList;
import java.util.Scanner;
import liikkeidenmallinnus.Koreografia;
import liikkeidenmallinnus.Liike;
import liikkeidenmallinnus.Tanssilaji;

/**
 * Luokka vastaa käyttäjän kanssa kommunikoimisesta.
 * Luokka esittelee liikkeet ja käsittelee käyttäjän syötteitä. 
 * Tulee jäämään pois käytöstä graafisen käyttöliittymän valmistuessa.
 * 
 * @author Akkanen
 */
public class Tekstikayttoliittyma {

    private LiikevarastonKasittelija kasittelija;
    private Scanner lukija;
    private Koreografia uusiKoreografia;
    private Tallentaja tallentaja;

    public Tekstikayttoliittyma(LiikevarastonKasittelija annettuKasittelija, Scanner annettuLukija) {
        this.kasittelija = annettuKasittelija;
        this.lukija = annettuLukija;
    }

    public void esitteleTanssilajit() {
        System.out.print("Valikoimassamme on seuraavat tanssilajit: \n");
        ArrayList<Tanssilaji> tulostettavat;
        tulostettavat = kasittelija.annaTanssilajit();
        for (Tanssilaji tulostettava : tulostettavat) {
            System.out.println(tulostettava.getNimi());
        }
        System.out.println();
    }

    public void esitteleLiikkeet(Tanssilaji tanssilaji) {
        System.out.println("\nLajissa on tällaisia liikkeitä.");
        System.out.println("Valitse ja lisää mieleisesi koreografiaan.\n");
        if (!kasittelija.annaLiikevalikoima().isEmpty()) {
            for (Liike liike : kasittelija.annaLiikevalikoima()) {
                if (liike.getTanssilaji().getNimi().equals(tanssilaji.getNimi())) {
                    System.out.println(liike.getNimi()
                            + " (" + liike.getKesto() + ")");
                }
            }
            System.out.println();
        } else {
            System.out.println("Liikkeitä valitulle lajille ei ollut.");
        }
    }

    public Tanssilaji pyydaTanssilajia() {
        System.out.print("Anna tanssilaji: ");
        
        Tanssilaji tanssilaji;
        String annettuTanssilaji;
        while (true) {
            annettuTanssilaji = this.lukija.nextLine();
            annettuTanssilaji = annettuTanssilaji.trim();
            annettuTanssilaji = annettuTanssilaji.toLowerCase();
            for (Tanssilaji laji : kasittelija.annaTanssilajit()) {
                if (laji.getNimi().equals(annettuTanssilaji)) {
                    tanssilaji = new Tanssilaji(annettuTanssilaji);
                    return tanssilaji;
                }
            }
            System.out.print("Anna jokin listalla olevista tanssilajeista: ");
        }
    }
    
    public void pyydaKoreografianNimea() {
        System.out.print("Anna uuden tanssikoreografian nimi: ");
        String tanssiKoreografianNimi = lukija.nextLine();
        this.uusiKoreografia = new Koreografia(tanssiKoreografianNimi);
    }
    
    
    public void lisaaLiikkeitaKoreografiaan() {
        while (true) {
            System.out.print("Lisää koreografiaan liikkeitä antamalla liikkeen nimi "
                    + "tai lopeta syöttämällä 'lopeta': ");
            String haluttuLiike = lukija.nextLine();
            haluttuLiike = haluttuLiike.replaceAll(" ", "").toLowerCase();

            if (haluttuLiike.equals("lopeta")) {
                break;
            }

            for (Liike liike : kasittelija.annaLiikevalikoima()) {
                if (liike.getNimi().equals(haluttuLiike)) {
                    this.uusiKoreografia.getKoreografianLiikkeet().add(liike);
                }
            }

            this.tulostaKoreografia();

        }
    }
    
    /**
     * Metodi tulostaa koreografian tekstimuodossa.
     */
    public void tulostaKoreografia() {
        System.out.println();
        System.out.println(this.uusiKoreografia.annaKoreografiaTekstina());
        System.out.println();
    }
    
    public void kysyTallennetaanko() {
        System.out.print("\nHaluatko tallentaa? (y/n) ");
        while (true) {
            String tallennetaanko = lukija.nextLine();

            if (tallennetaanko.equals("y")) {

                String tallennettavanTiedostonNimi = this.uusiKoreografia.getNimi();
                tallennettavanTiedostonNimi = tallennettavanTiedostonNimi + ".txt";
                String koreografianSisalto = this.uusiKoreografia.annaKoreografiaTekstina();
                this.tallentaja = new Tallentaja();

                try {
                    tallentaja.kirjoitaTiedostoon(tallennettavanTiedostonNimi, koreografianSisalto);
                } catch (Exception e) {
                    System.out.println("Virhe " + e.getMessage());
                }

                System.out.println("Tallennus suoritettu");
                break;

            } else if (tallennetaanko.equals("n")) {
                break;
            } else {
                System.out.print("Anna y tai n: ");
            }
        }
    }

}
