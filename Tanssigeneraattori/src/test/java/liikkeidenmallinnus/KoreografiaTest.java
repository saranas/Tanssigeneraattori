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
import static liikkeidenmallinnus.Liikesarja.TYHJA_TILA;
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
    LiikeElementti liikeEle2;
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
        liikeEle2 = new LiikeElementti(laji, "ele2", 2, lopputila, alkutila);

    }

    @Test
    public void tanssinAlkuasetuksetOikein() {
        assertEquals(this.koreografia.tanssinKesto(), 0);
        assertEquals(this.koreografia.getLopputila(), TYHJA_TILA);
    }
    
    @Test
    public void yhdenLiikkeenLisaaminenMuuttaaKestonJaLopputilan() {
        assertTrue(this.koreografia.lisaaLiike(liikeEle));
        assertEquals(this.koreografia.tanssinKesto(), liikeEle.getKesto());
        assertEquals(this.koreografia.getLopputila(), liikeEle.getLopputila());
    }
    
    @Test
    public void kahdenEriLiikkeenlisaaminenMuuttaaKestonJaLopputilan() {
        assertTrue(this.koreografia.lisaaLiike(liikeEle));
        assertTrue(this.koreografia.lisaaLiike(liikeEle2));
        assertEquals(this.koreografia.tanssinKesto(), liikeEle.getKesto() + liikeEle2.getKesto());
        assertEquals(this.koreografia.getLopputila(), liikeEle2.getLopputila());
    }
    
    @Test
    public void eriLopputilaJaAlkutilaEstaaLiikkeenLisaamisen() {
        assertTrue(this.koreografia.lisaaLiike(liikeEle));
        assertFalse(this.koreografia.lisaaLiike(liikeEle));
    }
}
