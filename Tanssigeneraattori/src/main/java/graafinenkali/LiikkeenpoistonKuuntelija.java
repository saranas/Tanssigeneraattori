package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import kayttoliittymanapu.LiikelistaSuodatin;
import liikkeidenmallinnus.Koreografia;

/**
 * Luokka kuuntelee poistonappia, ja poistaa koreografian viimeisimmän 
 * liikkeen. 
 * 
 * @author Akkanen
 */
public class LiikkeenpoistonKuuntelija implements ActionListener {

    private JEditorPane koreografiaEsitys;
    private Koreografia koreografia;
    private JLabel kesto;
    private LiikelistaSuodatin suodatin;
    private JList liikelista;

    LiikkeenpoistonKuuntelija(LiikelistaSuodatin suodatin, Koreografia koreografia,
            JEditorPane koreografiaEsitys, JLabel kesto, JList liikelista) {
        this.suodatin = suodatin;
        this.koreografiaEsitys = koreografiaEsitys;
        this.koreografia = koreografia;
        this.kesto = kesto;
        this.liikelista = liikelista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!koreografia.getKoreografianLiikkeet().isEmpty()) {
            koreografia.getKoreografianLiikkeet().remove(
                    koreografia.getKoreografianLiikkeet().size() - 1);
        }

        koreografiaEsitys.setText(koreografia.annaKoreografiaTekstina());
       
        liikelista.setListData(suodatin.suodata(koreografia));
        
        kesto.setText("Tanssin kesto: " + String.valueOf(koreografia.tanssinKesto()));
    }

}
