package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import kayttoliittymanapu.LiikelistaSuodatin;
import liikkeidenmallinnus.Koreografia;
import liikkeidenmallinnus.Liike;
import static liikkeidenmallinnus.Liikesarja.TYHJA_TILA;
import liikkeidenmallinnus.Tanssilaji;

public class LiikkeenpoistonKuuntelija implements ActionListener {

    private JEditorPane koreografiaEsitys;
    private Koreografia koreografia;
    private JLabel kesto;
    private JComboBox lajivalikko;
    private LiikelistaSuodatin suodatin;
    private JList liikelista;

    LiikkeenpoistonKuuntelija(LiikelistaSuodatin suodatin, Koreografia koreografia,
            JEditorPane koreografiaEsitys, JLabel kesto, JComboBox lajivalikko, JList liikelista) {
        this.suodatin = suodatin;
        this.koreografiaEsitys = koreografiaEsitys;
        this.koreografia = koreografia;
        this.kesto = kesto;
        this.lajivalikko = lajivalikko;
        this.liikelista = liikelista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!koreografia.getKoreografianLiikkeet().isEmpty()) {
            koreografia.getKoreografianLiikkeet().remove(
                    koreografia.getKoreografianLiikkeet().size() - 1);
        }

        koreografiaEsitys.setText(koreografia.annaKoreografiaTekstina());
       
        liikelista.setListData(suodatin.suodata());
        
        kesto.setText("Tanssin kesto: " + String.valueOf(koreografia.tanssinKesto()));
    }

}
