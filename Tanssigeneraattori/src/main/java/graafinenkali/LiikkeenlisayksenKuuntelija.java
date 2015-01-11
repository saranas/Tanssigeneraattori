package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import kayttoliittymanapu.LiikelistaSuodatin;
import liikkeidenmallinnus.Koreografia;
import liikkeidenmallinnus.Liike;
import liikkeidenmallinnus.LiikevarastonKasittelija;

/**
 * Kuuntelee lisäyspainiketta. Lisää valitun liikkeen
 * koreografiaan ja päivittää muut kentät sen mukaan.
 * 
 * @author Akkanen
 */
public class LiikkeenlisayksenKuuntelija implements ActionListener {

    private JList liikelista;
    private JEditorPane koreografiaEsitys;
    private Koreografia koreografia;
    private LiikevarastonKasittelija kasittelija;
    private JLabel kesto;
    private LiikelistaSuodatin suodatin;

    LiikkeenlisayksenKuuntelija(LiikelistaSuodatin suodatin, LiikevarastonKasittelija kasittelija,
            Koreografia koreografia, JList liikelista,
            JEditorPane koreografiaEsitys, JLabel kesto) {
        this.suodatin = suodatin;
        this.liikelista = liikelista;
        this.kasittelija = kasittelija;
        this.koreografiaEsitys = koreografiaEsitys;
        this.koreografia = koreografia;
        this.kesto = kesto;
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
       
        liikelista.setListData(suodatin.suodata(koreografia));
        
        kesto.setText("Tanssin kesto: " + String.valueOf(koreografia.tanssinKesto()));
    }

}
