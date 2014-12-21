package com.teegee.tanssigeneraattori;

public class Koreografia {
    private String nimi;

    public Koreografia(String nimi) {
        this.nimi = nimi;
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
