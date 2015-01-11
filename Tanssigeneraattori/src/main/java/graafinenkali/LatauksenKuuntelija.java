package graafinenkali;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import kayttoliittymanapu.KoreografianLukija;
import kayttoliittymanapu.LiikelistaSuodatin;
import liikkeidenmallinnus.Koreografia;
import liikkeidenmallinnus.Liike;
import liikkeidenmallinnus.LiikevarastonKasittelija;

/**
 * Kuuntelee Lataa-painiketta. Kutsuu sitten KoreografianLukijaa lukemaan
 * valitun tiedoston.
 * 
 * @author Akkanen
 */
public class LatauksenKuuntelija implements ActionListener {

    private KoreografianLukija klukija;
    private JList liikelista;
    private JEditorPane koreografiaEsitys;
    private Koreografia koreografia;
    private LiikevarastonKasittelija kasittelija;
    private JLabel kesto;
    private LiikelistaSuodatin suodatin;
    private JFileChooser valitsija;
    private Component frame;

    LatauksenKuuntelija(LiikelistaSuodatin suodatin, LiikevarastonKasittelija kasittelija,
            Koreografia koreografia, JList liikelista,
            JEditorPane koreografiaEsitys, JLabel kesto) {
        this.klukija = new KoreografianLukija(kasittelija);
        this.suodatin = suodatin;
        this.liikelista = liikelista;
        this.kasittelija = kasittelija;
        this.koreografiaEsitys = koreografiaEsitys;
        this.kesto = kesto;
        this.valitsija = new JFileChooser();
        this.frame = frame;
        this.koreografia = koreografia;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        valitsija.setMultiSelectionEnabled(false);
        int paatos = valitsija.showOpenDialog(frame);

        if (paatos == JFileChooser.APPROVE_OPTION) {
            File tiedostonimi = valitsija.getSelectedFile();

            int liikkeita = koreografia.getKoreografianLiikkeet().size();
            for (int i = 0; i < liikkeita; i++) {
                koreografia.poistaViimeisinLiike();
            }
            Koreografia ladattukoreografia = klukija.lueKoreografia(tiedostonimi);
            koreografia.setNimi(ladattukoreografia.getNimi());
            for (Liike liike : ladattukoreografia.getKoreografianLiikkeet()) {
                koreografia.lisaaLiike(liike);
            }
            
            koreografiaEsitys.setText(koreografia.annaKoreografiaTekstina());
            liikelista.setListData(suodatin.suodata(koreografia));
            kesto.setText("Tanssin kesto: " + String.valueOf(koreografia.tanssinKesto()));
        }
    }

}
