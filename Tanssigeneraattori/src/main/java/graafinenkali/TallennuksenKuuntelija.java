package graafinenkali;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
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
    private JLabel virhekentta;

    public TallennuksenKuuntelija(Koreografia koreografia, Component frame, JLabel virhekentta) {
        this.koreografia = koreografia;
        this.tallentaja = new Tallentaja();
        this.valitsija = new JFileChooser();
        this.frame = frame;
        this.virhekentta = virhekentta;
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
                    virhekentta.setText("Koreografia tallennettu");
                    kirjoittaja.close();
                }

            } catch (IOException ex) {
                virhekentta.setText("Tallennus epäonnistui");
                virhekentta.setForeground(Color.red);
            }
        }

    }

}
