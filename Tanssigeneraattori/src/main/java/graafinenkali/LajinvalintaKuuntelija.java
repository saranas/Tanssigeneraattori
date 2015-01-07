package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import kayttoliittymanapu.LiikelistaSuodatin;

/**
 * Kuuntelee drop down -valikkoa, jossa on valittavana
 * eri tanssilajeja.
 * 
 * @author Akkanen
 */
public class LajinvalintaKuuntelija implements ActionListener {

    private JList liikelista;
    private LiikelistaSuodatin suodatin;

    public LajinvalintaKuuntelija(LiikelistaSuodatin suodatin, JList liikelista) {
        this.suodatin = suodatin;
        this.liikelista = liikelista;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        liikelista.setListData(suodatin.suodata());

    }
}
