package graafinenkali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import liikkeidenmallinnus.Koreografia;
import liikkeidenmallinnus.Liike;
import static liikkeidenmallinnus.Liikesarja.TYHJA_TILA;
import liikkeidenmallinnus.LiikevarastonKasittelija;
import liikkeidenmallinnus.Tanssilaji;

public class LajinvalintaKuuntelija implements ActionListener {

    private JComboBox tanssivalikko;
    private JList liikelista;
    private LiikevarastonKasittelija kasittelija;
    private Taulukontekija taulukoija;
    private Koreografia koreografia;

    public LajinvalintaKuuntelija(LiikevarastonKasittelija kasittelija,
            JComboBox tanssivalikko, JList liikelista, Koreografia koreografia) {
        this.tanssivalikko = tanssivalikko;
        this.liikelista = liikelista;
        this.taulukoija = new Taulukontekija();
        this.kasittelija = kasittelija;
        this.koreografia = koreografia;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String valittulaji;
        valittulaji = (String) tanssivalikko.getSelectedItem();
        Tanssilaji laji = new Tanssilaji(valittulaji);

        ArrayList<Liike> suodatettavaLista = kasittelija.annaLiikevalikoima();
        suodatettavaLista = kasittelija.suodataLajinMukaan(laji, suodatettavaLista);

        if (koreografia.getLopputila() != TYHJA_TILA) {
            suodatettavaLista = kasittelija.suodataTilanMukaan(koreografia.getLopputila(), suodatettavaLista);
        }
        liikelista.setListData(taulukoija.annaLiikkeetTaulukkona(suodatettavaLista));

    }
}
