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
    
    
    
    

}
