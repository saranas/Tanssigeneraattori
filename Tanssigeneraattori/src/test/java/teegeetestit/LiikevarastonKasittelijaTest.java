/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teegeetestit;

import com.teegee.tanssigeneraattori.Liikesarja;
import com.teegee.tanssigeneraattori.LiikevarastonKasittelija;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Akkanen
 */
public class LiikevarastonKasittelijaTest {
    
    LiikevarastonKasittelija kasittelija;
    
    @Before
    public void setUp() {
        kasittelija = new LiikevarastonKasittelija("liikevarasto.txt");
    }
    
    @Test
    public void annaLiikevalikoimaPalauttaaTyhjanArrayListin() {
        assertThat(kasittelija.annaLiikevalikoima().size(), is(0));       
    }
    
    @Test
    public void kasittelijanArrayListiinVoiLisataKamaa() {
        kasittelija.annaLiikevalikoima().add(new Liikesarja("ECD",
                "heinä", "3", "seisooPainoOikealla", "seisooPainoOikealla"));
        assertThat(kasittelija.annaLiikevalikoima().size(), is(1));       
    }
    
    @Test
    public void kasittelijanArrayLististaVoiHakeaKamaa() {
        kasittelija.annaLiikevalikoima().add(new Liikesarja("ECD",
                "heinä", "3", "seisooPainoOikealla", "seisooPainoOikealla"));
        assertEquals(kasittelija.annaLiikevalikoima().get(0).getTanssilaji(), "ECD");       
    }

 
}
