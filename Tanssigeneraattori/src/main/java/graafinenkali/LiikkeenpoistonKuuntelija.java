package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import liikkeidenmallinnus.Koreografia;

public class LiikkeenpoistonKuuntelija implements ActionListener {

    private JEditorPane koreografiaEsitys;
    private Koreografia koreografia;
    private JLabel kesto;

    LiikkeenpoistonKuuntelija(Koreografia koreografia,
            JEditorPane koreografiaEsitys, JLabel kesto) {
        this.koreografiaEsitys = koreografiaEsitys;
        this.koreografia = koreografia;
        this.kesto = kesto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!koreografia.getKoreografianLiikkeet().isEmpty()) {
            koreografia.getKoreografianLiikkeet().remove(
                    koreografia.getKoreografianLiikkeet().size() - 1);
        }

        koreografiaEsitys.setText(koreografia.annaKoreografiaTekstina());

        kesto.setText("Tanssin kesto: " + String.valueOf(koreografia.tanssinKesto()));
    }

}
