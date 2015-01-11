package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import kayttoliittymanapu.LiikelistaSuodatin;
import liikkeidenmallinnus.Koreografia;

/**
 * Kuuntelee drop down -valikkoa, jossa on valittavana
 * eri tanssilajeja, ja asettaa liikelistan näyttämään
 * valitun lajin liikkeet.
 * 
 * @author Akkanen
 */
public class LajinvalintaKuuntelija implements ActionListener {

    private JList liikelista;
    private LiikelistaSuodatin suodatin;
    private Koreografia koreografia;

    public LajinvalintaKuuntelija(LiikelistaSuodatin suodatin, JList liikelista, Koreografia koreografia) {
        this.suodatin = suodatin;
        this.liikelista = liikelista;
        this.koreografia = koreografia;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        liikelista.setListData(suodatin.suodata(koreografia));

    }
}
