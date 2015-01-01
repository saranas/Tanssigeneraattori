/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liikkeidenmallinnus;

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
    LiikeElementti liikeEle;
    Tanssilaji laji;
    Tila alkutila;
    Tila lopputila;
    
    @Before
    public void setUp() {
        kasittelija = new LiikevarastonKasittelija("liikevarasto.txt");
        laji = new Tanssilaji("laji");
        alkutila = new Tila("alkutila");
        lopputila = new Tila("lopputila");
        liikeEle = new LiikeElementti(laji, "ele", 1, alkutila, lopputila);
    }
    
    @Test
    public void alkuasetuksetOikein() {
        assertTrue(kasittelija.annaLiikevalikoima().isEmpty()); 
        assertTrue(kasittelija.annaTanssilajit().isEmpty()); 
    }
    
    @Test
    public void lueMetodiLisaaLiikkeitaLiikevalikoimaan() {
        kasittelija.lue();
        assertFalse(kasittelija.annaLiikevalikoima().isEmpty());
    }
    
    @Test
    public void annaTanssilajitAntaaListan() {
        kasittelija.lue();
        assertFalse(kasittelija.annaTanssilajit().isEmpty());
    }

 
}
