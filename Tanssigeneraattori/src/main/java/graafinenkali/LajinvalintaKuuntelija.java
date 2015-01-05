package graafinenkali;

import kayttoliittymanapu.Taulukontekija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import kayttoliittymanapu.LiikelistaSuodatin;
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
    private LiikelistaSuodatin suodatin;

    public LajinvalintaKuuntelija(LiikelistaSuodatin suodatin, LiikevarastonKasittelija kasittelija,
            JComboBox tanssivalikko, JList liikelista, Koreografia koreografia) {
        this.suodatin = suodatin;
        this.tanssivalikko = tanssivalikko;
        this.liikelista = liikelista;
        this.taulukoija = new Taulukontekija();
        this.kasittelija = kasittelija;
        this.koreografia = koreografia;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        liikelista.setListData(suodatin.suodata());

    }
}
