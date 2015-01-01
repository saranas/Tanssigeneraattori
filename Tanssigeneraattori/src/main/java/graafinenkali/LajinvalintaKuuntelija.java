package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JList;
import liikkeidenmallinnus.Liike;
import liikkeidenmallinnus.LiikevarastonKasittelija;

public class LajinvalintaKuuntelija implements ActionListener {

    private JComboBox tanssivalikko;
    private JList liikelista;
    private GraafinenKayttoliittyma gkali;
    private LiikevarastonKasittelija kasittelija;
    private Taulukontekija taulukoija;

    public LajinvalintaKuuntelija(GraafinenKayttoliittyma gk, LiikevarastonKasittelija kasittelija, 
            JComboBox tanssivalikko, JList liikelista) {
        this.tanssivalikko = tanssivalikko;
        this.liikelista = liikelista;
        this.taulukoija = new Taulukontekija();
        this.gkali = gk;
        this.kasittelija = kasittelija;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Henkilo henkilo = new Henkilo(nimiKentta.getText(), hetuKentta.getText());
        //this.henkiloVarasto.talleta(henkilo);
        
        String valittulaji;
        valittulaji = (String)tanssivalikko.getSelectedItem();
        
        JList uusiliikelista = new JList(taulukoija.annaLiikkeetTaulukkona(
                kasittelija.annaLiikevalikoimaLajinMukaan(valittulaji)));
        gkali.setLiikelista(uusiliikelista);
    }
}