package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JList;
import liikkeidenmallinnus.Koreografia;
import liikkeidenmallinnus.Liike;
import liikkeidenmallinnus.LiikevarastonKasittelija;

public class LiikkeenlisayksenKuuntelija implements ActionListener {
    private JList liikelista;
    private JEditorPane koreografiaEsitys;
    private Koreografia koreografia;
    private LiikevarastonKasittelija kasittelija;
    
    LiikkeenlisayksenKuuntelija(LiikevarastonKasittelija kasittelija, Koreografia koreografia, JList liikelista, JEditorPane koreografiaEsitys) {
        this.liikelista = liikelista;
        this.kasittelija = kasittelija;
        this.koreografiaEsitys = koreografiaEsitys;
        this.koreografia = koreografia;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String haluttuliike = (String)liikelista.getSelectedValue();
        for (Liike liike : kasittelija.annaLiikevalikoima()) {
            if (liike.getNimi().equals(haluttuliike)) {
                koreografia.getKoreografianLiikkeet().add(liike);
            }
        }         
        koreografiaEsitys.setText(koreografia.annaKoreografiaTekstina());
    }
    
    

}