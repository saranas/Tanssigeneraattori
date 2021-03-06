/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liikkeidenmallinnus;

import java.util.ArrayList;
import liikkeidenmallinnus.LiikeElementti;
import liikkeidenmallinnus.LiikeElementti;
import liikkeidenmallinnus.Tila;
import liikkeidenmallinnus.Tanssilaji;
import liikkeidenmallinnus.Liikesarja;
import liikkeidenmallinnus.Tanssilaji;
import liikkeidenmallinnus.Tila;
import liikkeidenmallinnus.LiikevarastonKasittelija;
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
    LiikeElementti ele;
    LiikeElementti ele2;
    Tanssilaji laji;
    Tanssilaji erilaji;
    Tila alkutila;
    Tila lopputila;
    ArrayList<Liike> lista;
    
    @Before
    public void setUp() {
        kasittelija = new LiikevarastonKasittelija("liikevarasto.txt");
        laji = new Tanssilaji("laji");
        erilaji = new Tanssilaji("erilaji");
        alkutila = new Tila("alkutila");
        lopputila = new Tila("lopputila");
        ele = new LiikeElementti(laji, "ele", 1, alkutila, lopputila);
        ele2 = new LiikeElementti(erilaji, "ele2", 2, lopputila, alkutila);
        lista = kasittelija.annaLiikevalikoima();
    }
    
    @Test
    public void alkuasetuksetOikein() {
        assertTrue(kasittelija.annaLiikevalikoima().isEmpty()); 
        assertTrue(kasittelija.annaTanssilajit().isEmpty());
        assertTrue(kasittelija.suodataLajinMukaan(laji, lista).isEmpty());
        assertTrue(kasittelija.suodataTilanMukaan(lopputila, lista).isEmpty());
    }
    
    @Test
    public void lueMetodiLisaaLiikkeitaLiikevalikoimaan() throws Exception {
        kasittelija.lue();
        assertFalse(kasittelija.annaLiikevalikoima().isEmpty()); 
        assertFalse(kasittelija.annaTanssilajit().isEmpty());
    }
    
    @Test
    public void suodattimetToimivat() {
        kasittelija.annaLiikevalikoima().add(ele);
        kasittelija.annaLiikevalikoima().add(ele2);
        assertEquals(kasittelija.suodataLajinMukaan(erilaji, lista).size(), 1);
        assertEquals(kasittelija.suodataLajinMukaan(erilaji, lista).get(0), ele2);
        assertEquals(kasittelija.suodataTilanMukaan(alkutila, lista).size(), 1);
        assertEquals(kasittelija.suodataTilanMukaan(alkutila, lista).get(0), ele);
    }
    

 
}
