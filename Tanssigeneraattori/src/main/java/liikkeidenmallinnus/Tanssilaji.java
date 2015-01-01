package liikkeidenmallinnus;

public class Tanssilaji  {
    private String nimi;
    
    public Tanssilaji(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }
    
    @Override
    public boolean equals(Object olio) {
        if (olio == null) {
            return false;
        }

        if (getClass() != olio.getClass()) {
            return false;
        }

        Tanssilaji verrattava = (Tanssilaji) olio;

        if (this.nimi == null || !this.nimi.equals(verrattava.getNimi())) {
            return false;
        }

        return true;
    }

}
