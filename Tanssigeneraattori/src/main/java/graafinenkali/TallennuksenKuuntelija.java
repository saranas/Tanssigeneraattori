package graafinenkali;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import liikkeidenmallinnus.Koreografia;
import kayttoliittymanapu.Tallentaja;

/**
 * Luokka kuuntelee tallennuspainiketta ja tallentaa koreografian
 * valittuun sijaintiin tekstitiedostona.
 * 
 * @author Akkanen
 */
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
    
    /*
     * Näyttää tiedostonvalitsijan ja tallentaa koreografian tekstitiedostoon
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        valitsija.setMultiSelectionEnabled(false);
        int paatos = valitsija.showSaveDialog(frame);

        if (paatos == JFileChooser.APPROVE_OPTION) {

            try {

                File tiedostonimi = valitsija.getSelectedFile();
                
                try (FileWriter kirjoittaja = new FileWriter(new File(
                        tiedostonimi.getCanonicalPath() + ".txt"))) {
                    kirjoittaja.write(koreografia.annaKoreografiaTekstina());
                    kirjoittaja.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(TallennuksenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
