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
import liikkeidenmallinnus.Liike;
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
        
        int liikkeita = koreografia.getKoreografianLiikkeet().size();
        for (int i = 0; i < liikkeita; i++) {
            koreografia.poistaViimeisinLiike();
        }
        Koreografia arvottukoreografia = arpoja.arvoKoreografia(laji);
        koreografia.setNimi(arvottukoreografia.getNimi());
        for (Liike liike : arvottukoreografia.getKoreografianLiikkeet()) {
            koreografia.lisaaLiike(liike);
        }
        
        koreografiaEsitys.setText(koreografia.annaKoreografiaTekstina());
       
        liikelista.setListData(suodatin.suodata(koreografia));
        
        kesto.setText("Tanssin kesto: " + String.valueOf(koreografia.tanssinKesto()));
    }

}
