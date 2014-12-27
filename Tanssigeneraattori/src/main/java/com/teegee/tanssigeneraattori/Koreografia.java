package com.teegee.tanssigeneraattori;

import java.util.ArrayList;

public class Koreografia {

    private String nimi;
    private ArrayList<Liikesarja> liikkeet;

    public Koreografia(String nimi) {
        this.nimi = nimi;
        this.liikkeet = new ArrayList<Liikesarja>();
    }

    public ArrayList<Liikesarja> getLiikkeet() {
        return this.liikkeet;
    }

    public int tanssinKesto() {
        int kestoYhteensa = 0;
        for (Liikesarja liikesarja : this.liikkeet) {
            kestoYhteensa += Integer.parseInt(liikesarja.getKesto());
        }
        return kestoYhteensa;
    }
    
    public String annaKoreografiaTekstina() {
        String koreografiaTekstina = this.getNimi() + "\n\n";
        for (int i = 0; i < liikkeet.size(); i++) {
            if (i % 2 != 0 || i == 1) {
                koreografiaTekstina = koreografiaTekstina.concat(this.liikkeet.get(i).getNimi());
            } else {
                koreografiaTekstina = koreografiaTekstina.concat(this.liikkeet.get(i).getNimi());
            }
        }
        return koreografiaTekstina;
        
    }

    //Allaoleva metodi muuttunee tarpeettomaksi, jos saan tehtyä graafisen 
    //käyttöliittymän. Siinä on paljon päällekkäisyyttä 
    //ylläolevan kanssa.
    public void tulostaKoreografia() {
        System.out.println();
        for (int i = 0; i < liikkeet.size(); i++) {
            if (i % 2 != 0 || i == 1) {
                System.out.println(this.liikkeet.get(i).getNimi());
            } else {
                System.out.print(this.liikkeet.get(i).getNimi() + " ");
            }
        }
        System.out.println("\nTanssin kesto " + this.tanssinKesto() + " iskua");
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
