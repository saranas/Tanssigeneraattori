package liikkeidenmallinnus;

/**
 * Luokka säilöö Liikkeen alkutilan ja lopputilan
 * 
 * @author Akkanen
 */
public class Tila {
    private String nimi;

    public Tila(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
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

        Tila verrattava = (Tila) olio;

        if (this.nimi == null || !this.nimi.equals(verrattava.getNimi())) {
            return false;
        }

        return true;
    }
    
    
    
    

}
