package com.teegee.tanssigeneraattori;

public class Liikesarja implements Liike {
    private String nimi;
    private int kesto;
    private String alkutila;
    private String lopputila;

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
