package com.teegee.tanssigeneraattori;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Akkanen
 */
public class LiikesarjaTest {

    Liikesarja liikesarja;
    LiikeElementti ele;
    LiikeElementti toinenEle;
    Tanssilaji laji;
    Tila alkutila;
    Tila lopputila;

    @Before
    public void setUp() {
        alkutila = new Tila("alkutila");
        lopputila = new Tila("lopputila");
        ele = new LiikeElementti(laji, "LiikeElementti", 1, alkutila, lopputila);
        toinenEle = new LiikeElementti(laji, "LiikeElementti2", 2, lopputila, alkutila);
        liikesarja = new Liikesarja(laji, "Arming");
    }

    @Test
    public void tyhjaLiikesarjaSisaltaaOletusarvot() {
        assertEquals(liikesarja.getKesto(), 0);
        assertEquals(liikesarja.getAlkutila(), Liikesarja.TYHJA_TILA);
        assertEquals(liikesarja.getLopputila(), Liikesarja.TYHJA_TILA);

    }

    @Test
    public void yhdenLiikkenLiikesarjaSisaltaaLiikkeenOminaisuudet() {
        assertTrue(liikesarja.lisaaLiike(ele));
        assertEquals(liikesarja.getKesto(), ele.getKesto());
        assertEquals(liikesarja.getAlkutila(), ele.getAlkutila());
        assertEquals(liikesarja.getLopputila(), ele.getLopputila());
    }

    @Test
    public void useammanLiikkeenLiikesarjaPalauttaaPaatyliikkeidenOminaisuudetJaKaikkienLiikkeidenYhteiskeston() {
        assertTrue(liikesarja.lisaaLiike(ele));
        assertTrue(liikesarja.lisaaLiike(toinenEle));
        assertEquals(liikesarja.getKesto(), ele.getKesto() + toinenEle.getKesto());
        assertEquals(liikesarja.getAlkutila(), ele.getAlkutila());
        assertEquals(liikesarja.getLopputila(), toinenEle.getLopputila());
    }

    @Test
    public void eriLopputilaJaAlkutilaEstaaLiikkeenLisaamisen() {
        assertTrue(liikesarja.lisaaLiike(ele));
        assertFalse(liikesarja.lisaaLiike(ele));
    }

    @Test
    public void tyhjastaLiikesarjastaPoistaminenPalauttaaNullin() {
        assertTrue(liikesarja.lisaaLiike(ele));
        assertTrue(liikesarja.lisaaLiike(toinenEle));
        assertEquals(liikesarja.getKesto(), ele.getKesto() + toinenEle.getKesto());

        assertEquals(liikesarja.poistaViimeisinLiike(), toinenEle);
        assertEquals(liikesarja.getKesto(), ele.getKesto());
        
        assertEquals(liikesarja.poistaViimeisinLiike(), ele);
        assertEquals(liikesarja.getKesto(), 0);
        
        assertEquals(liikesarja.poistaViimeisinLiike(), null);
        assertEquals(liikesarja.getKesto(), 0);

    }

}
