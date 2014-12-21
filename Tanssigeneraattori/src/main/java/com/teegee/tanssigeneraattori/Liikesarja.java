package com.teegee.tanssigeneraattori;

public class Liikesarja {
    private String nimi;
    private int kesto;

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
