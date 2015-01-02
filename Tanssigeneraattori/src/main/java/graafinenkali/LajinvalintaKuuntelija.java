package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import liikkeidenmallinnus.LiikevarastonKasittelija;

public class LajinvalintaKuuntelija implements ActionListener {

    private JComboBox tanssivalikko;
    private JList liikelista;
    private LiikevarastonKasittelija kasittelija;
    private Taulukontekija taulukoija;

    public LajinvalintaKuuntelija(LiikevarastonKasittelija kasittelija,
            JComboBox tanssivalikko, JList liikelista) {
        this.tanssivalikko = tanssivalikko;
        this.liikelista = liikelista;
        this.taulukoija = new Taulukontekija();
        this.kasittelija = kasittelija;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String valittulaji;
        valittulaji = (String) tanssivalikko.getSelectedItem();

        liikelista.setListData(taulukoija.annaLiikkeetTaulukkona(
                kasittelija.annaLiikevalikoimaLajinMukaan(valittulaji)));

    }
}
