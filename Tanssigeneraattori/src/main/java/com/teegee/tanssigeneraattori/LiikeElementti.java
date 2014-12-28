package com.teegee.tanssigeneraattori;

public class LiikeElementti implements Liike {

    private Tanssilaji tanssilaji;
    private String nimi;
    private int kesto;
    private Tila alkutila;
    private Tila lopputila;

    public LiikeElementti(Tanssilaji tanssilaji, String nimi, int kesto, Tila alkutila, Tila lopputila) {
        this.tanssilaji = tanssilaji;
        this.nimi = nimi;
        this.kesto = kesto;
        this.alkutila = alkutila;
        this.lopputila = lopputila;
    }

    @Override
    public Tanssilaji getTanssilaji() {
        return tanssilaji;
    }

    @Override
    public String getNimi() {
        return nimi;
    }

    @Override
    public int getKesto() {
        return kesto;
    }

    @Override
    public Tila getAlkutila() {
        return alkutila;
    }

    @Override
    public Tila getLopputila() {
        return lopputila;
    }

}
