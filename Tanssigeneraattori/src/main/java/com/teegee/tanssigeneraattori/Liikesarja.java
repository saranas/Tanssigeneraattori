package com.teegee.tanssigeneraattori;

public class Liikesarja implements Liike {
    private String tanssilaji;
    private String nimi;
    private int kesto;
    private String alkutila;
    private String lopputila;
    
    public Liikesarja(String tanssilaji, String nimi, int kesto, String alkutila, String lopputila) {
        this.tanssilaji = tanssilaji;
        this. nimi = nimi;
        this.kesto = kesto;
        this.alkutila = alkutila;
        this.lopputila = lopputila;
    }

    public String getNimi() {
        return nimi;
    }

    public int getKesto() {
        return kesto;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setKesto(int kesto) {
        this.kesto = kesto;
    }

    @Override
    public String toString() {
        return "Liike{" + "nimi=" + nimi + ", kesto=" + kesto + '}';
    }
    

}
