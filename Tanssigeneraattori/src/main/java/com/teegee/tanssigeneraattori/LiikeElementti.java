package com.teegee.tanssigeneraattori;

public class LiikeElementti implements Liike {

    private String tanssilaji;
    private String nimi;
    private String kesto;
    private String alkutila;
    private String lopputila;

    public LiikeElementti(String tanssilaji, String nimi, String kesto, String alkutila, String lopputila) {
        this.tanssilaji = tanssilaji;
        this.nimi = nimi;
        this.kesto = kesto;
        this.alkutila = alkutila;
        this.lopputila = lopputila;
    }

    @Override
    public String getTanssilaji() {
        return tanssilaji;
    }

    @Override
    public String getNimi() {
        return nimi;
    }

}
