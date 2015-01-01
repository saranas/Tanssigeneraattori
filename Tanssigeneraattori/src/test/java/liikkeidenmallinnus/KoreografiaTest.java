/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liikkeidenmallinnus;

import liikkeidenmallinnus.LiikeElementti;
import liikkeidenmallinnus.Tila;
import liikkeidenmallinnus.Tanssilaji;
import liikkeidenmallinnus.Koreografia;
import liikkeidenmallinnus.Liikesarja;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Akkanen
 */
public class KoreografiaTest {
    Koreografia koreografia;
    LiikeElementti liikeEle;
    Tanssilaji laji;
    Tila alkutila;
    Tila lopputila;
    
    @Before
    public void setUp() {
        this.koreografia = new Koreografia("Testikoreografia");
        laji = new Tanssilaji("laji");
        alkutila = new Tila("alkutila");
        lopputila = new Tila("lopputila");
        liikeEle = new LiikeElementti(laji, "ele", 1, alkutila, lopputila);
    }

    @Test
    public void tanssinkestoAlussaNolla() {
        assertEquals(this.koreografia.tanssinKesto(), 0);
    }
    
    @Test
    public void tanssinkestoKasvaaKunLiikkeitaLisataan() {
        this.koreografia.getKoreografianLiikkeet().add(liikeEle);
        assertEquals(this.koreografia.tanssinKesto(), liikeEle.getKesto());
    }
}
