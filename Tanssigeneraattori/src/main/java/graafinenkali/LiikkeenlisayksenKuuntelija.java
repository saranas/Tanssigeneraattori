package graafinenkali;

import kayttoliittymanapu.Taulukontekija;
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
import liikkeidenmallinnus.LiikevarastonKasittelija;
import liikkeidenmallinnus.Tanssilaji;

public class LiikkeenlisayksenKuuntelija implements ActionListener {

    private JList liikelista;
    private JEditorPane koreografiaEsitys;
    private Koreografia koreografia;
    private LiikevarastonKasittelija kasittelija;
    private JLabel kesto;
    private Taulukontekija taulukoija;
    private JComboBox lajivalikko;
    private LiikelistaSuodatin suodatin;

    LiikkeenlisayksenKuuntelija(LiikelistaSuodatin suodatin, LiikevarastonKasittelija kasittelija,
            Koreografia koreografia, JList liikelista,
            JEditorPane koreografiaEsitys, JLabel kesto, JComboBox lajivalikko) {
        this.suodatin = suodatin;
        this.liikelista = liikelista;
        this.kasittelija = kasittelija;
        this.koreografiaEsitys = koreografiaEsitys;
        this.koreografia = koreografia;
        this.kesto = kesto;
        this.taulukoija = new Taulukontekija();
        this.lajivalikko = lajivalikko;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String haluttuliike = (String) liikelista.getSelectedValue();
        for (Liike liike : kasittelija.annaLiikevalikoima()) {
            if (liike.getNimi().equals(haluttuliike)) {
                koreografia.lisaaLiike(liike);

            }
        }
        koreografiaEsitys.setText(koreografia.annaKoreografiaTekstina());

        
        liikelista.setListData(suodatin.suodata());

        kesto.setText("Tanssin kesto: " + String.valueOf(koreografia.tanssinKesto()));
    }

}
