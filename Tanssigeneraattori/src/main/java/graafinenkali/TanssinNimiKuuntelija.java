package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import liikkeidenmallinnus.Koreografia;

/**
 * Kuuntelee tekstikenttää, johon voi syöttää tanssin nimen.
 * Asettaa annetun nimen koreografialle.
 * 
 * @author Akkanen
 */
public class TanssinNimiKuuntelija implements ActionListener {
    private Koreografia koreografia;
    private JEditorPane koreografiaEsitys;
    private JTextField nimenvalintapalkki;
    
    public TanssinNimiKuuntelija(Koreografia koreografia, 
            JEditorPane koreografiaEsitys, JTextField nimenvalintapalkki) {
        this.koreografia = koreografia;
        this.koreografiaEsitys = koreografiaEsitys;
        this.nimenvalintapalkki = nimenvalintapalkki;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String uusnimi = nimenvalintapalkki.getText();
        koreografia.setNimi(uusnimi);
        koreografiaEsitys.setText(koreografia.annaKoreografiaTekstina());
    }

}
