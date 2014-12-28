package com.teegee.tanssigeneraattori;

import java.util.ArrayList;

public class Liikesarja implements Liike {

    private Tanssilaji tanssilaji;
    private String nimi;
    private ArrayList<Liike> liikkeet;
    public static Tila TYHJA_TILA = new Tila("tyhja");

    public Liikesarja(Tanssilaji tanssilaji, String nimi) {
        this.tanssilaji = tanssilaji;
        this.nimi = nimi;
        this.liikkeet = new ArrayList<Liike>();
    }

    public Tanssilaji getTanssilaji() {
        return tanssilaji;
    }

    public String getNimi() {
        return nimi;
    }

    public int getKesto() {
        int kestoYhteensa = 0;
            for (Liike liike : this.liikkeet) {
                kestoYhteensa += liike.getKesto();
            }
        return kestoYhteensa;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return this.tanssilaji + this.nimi + this.getKesto()
                + this.getAlkutila() + this.getLopputila();
    }

    @Override
    public Tila getAlkutila() {
        if (liikkeet.isEmpty()) {
            return TYHJA_TILA;
        } else {
            return liikkeet.get(0).getAlkutila();
        }
    }

    @Override
    public Tila getLopputila() {
        if (liikkeet.isEmpty()) {
            return TYHJA_TILA;
        } else {
            return liikkeet.get(liikkeet.size() - 1).getLopputila();
        }
    }

    public boolean lisaaLiike(Liike liike) {
        
        if (liikkeet.isEmpty()) {
            liikkeet.add(liike);
            return true;
        }
        
        Tila alkutila = liike.getAlkutila();
        if (alkutila.equals(this.getLopputila())) {
            liikkeet.add(liike);
            return true;
        }
        return false;
    }
    
    public Liike poistaViimeisinLiike() {
        if (!liikkeet.isEmpty()) {
            return liikkeet.remove(liikkeet.size()-1);
        }
        return null;
    }

}
