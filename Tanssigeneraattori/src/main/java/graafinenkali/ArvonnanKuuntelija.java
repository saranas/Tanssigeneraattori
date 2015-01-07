package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import kayttoliittymanapu.Arpoja;
import kayttoliittymanapu.LiikelistaSuodatin;
import liikkeidenmallinnus.Koreografia;
import liikkeidenmallinnus.LiikevarastonKasittelija;
import liikkeidenmallinnus.Tanssilaji;

/**
 * Kuuntelee arvontapainiketta ja kutsuu Arpojaa arpomaan
 * satunnaisen koreografian.
 * 
 * @author Akkanen
 */
public class ArvonnanKuuntelija implements ActionListener {
    private Arpoja arpoja;
    private JEditorPane koreografiaEsitys;
    private JList liikelista;
    private LiikelistaSuodatin suodatin;
    private JLabel kesto;
    private Koreografia koreografia;
    private JComboBox lajivalikko;
    private LiikevarastonKasittelija kasittelija;

    public ArvonnanKuuntelija(Koreografia koreografia, JEditorPane koreografiaEsitys, 
            JList liikelista, LiikelistaSuodatin suodatin, JLabel kesto, 
            LiikevarastonKasittelija kasittelija, JComboBox lajivalikko) {
        this.arpoja = new Arpoja(kasittelija);
        this.koreografiaEsitys = koreografiaEsitys;
        this.lajivalikko = lajivalikko;
        this.liikelista = liikelista;
        this.suodatin = suodatin;
        this.kesto = kesto;
        this.koreografia = koreografia;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String valittulaji = (String) lajivalikko.getSelectedItem();
        Tanssilaji laji = new Tanssilaji(valittulaji);
        koreografia = arpoja.arvoKoreografia(laji);
        
        koreografiaEsitys.setText(koreografia.annaKoreografiaTekstina());
       
        liikelista.setListData(suodatin.suodata());
        
        kesto.setText("Tanssin kesto: " + String.valueOf(koreografia.tanssinKesto()));
    }

}
