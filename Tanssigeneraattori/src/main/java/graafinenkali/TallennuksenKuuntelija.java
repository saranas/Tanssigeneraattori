package graafinenkali;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import liikkeidenmallinnus.Koreografia;
import kayttoliittymanapu.Tallentaja;


public class TallennuksenKuuntelija implements ActionListener {
    private Koreografia koreografia;
    private Tallentaja tallentaja;
    private JFileChooser valitsija;
    private Component frame;
    
    public TallennuksenKuuntelija(Koreografia koreografia, Component frame) {
        this.koreografia = koreografia;
        this.tallentaja = new Tallentaja();
        this.valitsija = new JFileChooser();
        this.frame = frame;
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
//        valitsija.setMultiSelectionEnabled(false);
//        valitsija.showSaveDialog(frame);
        String tanssinTiedostonimi = koreografia.getNimi() + ".txt";
        try {
            tallentaja.kirjoitaTiedostoon(tanssinTiedostonimi, koreografia.annaKoreografiaTekstina());
        } catch (Exception ex) {
            Logger.getLogger(TallennuksenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
