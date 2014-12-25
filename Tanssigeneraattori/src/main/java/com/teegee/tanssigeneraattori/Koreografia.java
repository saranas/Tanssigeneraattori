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
    
    public void tulostaKoreografia() {
        System.out.println();
        for (Liikesarja liikesarja : this.liikkeet) {
            System.out.println(liikesarja.getNimi());
        }
        System.out.println("Tanssin kesto " + this.tanssinKesto() + " iskua");
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
