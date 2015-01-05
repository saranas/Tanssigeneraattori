package liikkeidenmallinnus;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Akkanen
 */
public class LiikeElementtiTest {

    LiikeElementti ele;
    LiikeElementti toinenele;
    Tanssilaji laji;
    Tila alkutila;
    Tila lopputila;

    @Before
    public void setUp() {
        alkutila = new Tila("alkutila");
        lopputila = new Tila("lopputila");
        laji = new Tanssilaji("laji");
        ele = new LiikeElementti(laji, "ele", 1, alkutila, lopputila);
        toinenele = new LiikeElementti(laji, "toinenele", 1, alkutila, lopputila);
    }

    @Test
    public void liikeElementtienVertailuToimii() {
        assertTrue(ele.equals(ele));
        assertFalse(ele.equals(toinenele));
    }

}
