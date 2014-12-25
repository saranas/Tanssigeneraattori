package com.teegee.tanssigeneraattori;

public class Liikesarja implements Liike {
    private String tanssilaji;
    private String nimi;
    private String kesto;
    private String alkutila;
    private String lopputila;
    
    public Liikesarja(String tanssilaji, String nimi, String kesto, String alkutila, String lopputila) {
        this.tanssilaji = tanssilaji;
        this. nimi = nimi;
        this.kesto = kesto;
        this.alkutila = alkutila;
        this.lopputila = lopputila;
    }

    public String getTanssilaji() {
        return tanssilaji;
    }

    public String getNimi() {
        return nimi;
    }

    public String getKesto() {
        return kesto;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return this.tanssilaji + this.nimi + this.kesto + this.alkutila + this.lopputila;
    }

    
    

}
