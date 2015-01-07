package kayttoliittymanapu;

import java.util.Random;

/**
 * Luokka säilöö kasan sanoja satunnaisten nimien arpomista varten.
 * Luokka palauttaa satunnaisia sanoja annetusta sanaluokasta.
 * 
 * @author Akkanen
 */
public class Sanakasa {
    private String[] adjektiivit;
    private String[] substantiivit;
    private Random random;

    public Sanakasa() {
        this.random = new Random();
        this.adjektiivit = new String[]{
            "Green", "Sunny", "Happy", "Broad"
        };
        this.substantiivit = new String[]{
            "Goddess", "Car", "Road", 
        };
    }
    
    public String annaAdjektiivi() {
        return adjektiivit[random.nextInt(adjektiivit.length)];
    }
    
    public String annaSubstantiivi() {
        return substantiivit[random.nextInt(substantiivit.length)];
    }

}
