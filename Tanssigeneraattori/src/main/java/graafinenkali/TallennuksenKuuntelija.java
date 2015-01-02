package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import liikkeidenmallinnus.Koreografia;
import tekstikayttoliittyma.Tallentaja;

public class TallennuksenKuuntelija implements ActionListener {
    private Koreografia koreografia;
    private Tallentaja tallentaja;
    
    public TallennuksenKuuntelija(Koreografia koreografia) {
        this.koreografia = koreografia;
        this.tallentaja = new Tallentaja();
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        String tanssinTiedostonimi = koreografia.getNimi() + ".txt";
        try {
            tallentaja.kirjoitaTiedostoon(tanssinTiedostonimi, koreografia.annaKoreografiaTekstina());
        } catch (Exception ex) {
            Logger.getLogger(TallennuksenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
