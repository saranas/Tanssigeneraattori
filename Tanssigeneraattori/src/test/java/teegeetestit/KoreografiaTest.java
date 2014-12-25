/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teegeetestit;

import com.teegee.tanssigeneraattori.Koreografia;
import com.teegee.tanssigeneraattori.Liikesarja;
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
    Liikesarja liike;
    
    @Before
    public void setUp() {
        this.koreografia = new Koreografia("Goddesses");
        this.liike = new Liikesarja("ECD", "heinä",
                "3", "seisooPainoOikealla", "seisooPainoOikealla");
    }

    @Test
    public void tanssinkestoAlussaNolla() {
        assertEquals(this.koreografia.tanssinKesto(), 0);
    }
    
    @Test
    public void tanssinkestoKasvaaKunLiikkeitaLisataan() {
        this.koreografia.getLiikkeet().add(liike);
        assertEquals(this.koreografia.tanssinKesto(), 3);
    }
}
