package graafinenkali;

import kayttoliittymanapu.Taulukontekija;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import kayttoliittymanapu.LiikelistaSuodatin;
import liikkeidenmallinnus.*;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private LiikevarastonKasittelija kasittelija;
    private JList liikelista;
    private Taulukontekija taulukoija;
    private Koreografia koreografia;
    private LiikelistaSuodatin suodatin;

    public GraafinenKayttoliittyma(LiikevarastonKasittelija kasittelija) {
        this.kasittelija = kasittelija;
        this.taulukoija = new Taulukontekija();
        this.koreografia = new Koreografia("Tanssin nimi");
    }

    @Override
    public void run() {
        frame = new JFrame("Tanssigeneraattori");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setMinimumSize(new Dimension(300, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void setLiikelista(JList liikelista) {
        this.liikelista = liikelista;
    }

    /**
     * Asettelee graafisen käyttöliittymän palikat paikalleen.
     *
     * @param container
     */
    private void luoKomponentit(Container container) {

        JPanel paneeli1 = new JPanel(new GridLayout(1, 2));

        //Drop down -valikko tanssilajeista
        ArrayList<Tanssilaji> tanssilajilista = kasittelija.annaTanssilajit();
        String[] tanssilista = taulukoija.annaLajitTaulukkona(tanssilajilista);
        JComboBox tanssivalikko = new JComboBox(tanssilista);
        String kaikki = "kaikki";
        tanssivalikko.insertItemAt(kaikki, 0);
        tanssivalikko.setSelectedIndex(0);

        //Palkki tanssin nimen syöttämiseen
        JTextField nimenvalintapalkki = new JTextField("Tanssin nimi", 20);

        paneeli1.add(tanssivalikko);
        paneeli1.add(nimenvalintapalkki);

        JPanel paneeli2 = new JPanel();
        paneeli2.setLayout(new BoxLayout(paneeli2, BoxLayout.LINE_AXIS));

        //Luo skrollivalikon liikkeistä
        ArrayList<Liike> liikkeet = kasittelija.annaLiikevalikoima();
        String[] liiketaulukko = taulukoija.annaLiikkeetTaulukkona(liikkeet);
        liikelista = new JList(liiketaulukko);
        JScrollPane liikevalikko = new JScrollPane(liikelista);
        liikevalikko.setPreferredSize(new Dimension(200, 110));
        liikevalikko.setMinimumSize(new Dimension(40, 40));
        liikevalikko.setMaximumSize(new Dimension(200, 700));
        liikevalikko.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //Luo napit liikkeiden lisäykseen ja poistoon
        JPanel napit = new JPanel();
        napit.setLayout(new BoxLayout(napit, BoxLayout.PAGE_AXIS));
        JButton lisaysnappi = new JButton(">");
        JButton poistonappi = new JButton("X");

        //Luo tekstilaatikon, jossa koreografia näytetään
        JEditorPane koreografiaEsitys = new JEditorPane();
        koreografiaEsitys.setEditable(false);
        koreografiaEsitys.setText("");
        JScrollPane koreografiaesitysSkrolli = new JScrollPane(koreografiaEsitys);
        koreografiaesitysSkrolli.setPreferredSize(new Dimension(200, 110));
        koreografiaesitysSkrolli.setMinimumSize(new Dimension(20, 20));
        koreografiaesitysSkrolli.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        napit.add(lisaysnappi);
        napit.add(poistonappi);
        paneeli2.add(liikevalikko);
        paneeli2.add(napit);
        paneeli2.add(koreografiaesitysSkrolli);

        JPanel paneeli3 = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        
        JButton arvontanappi = new JButton("Random!");
        //JButton latausnappi = new JButton("Lataa");
        JLabel kesto = new JLabel("Tanssin kesto: " + String.valueOf(koreografia.tanssinKesto()));
        JButton tallennusnappi = new JButton("Tallenna");
        tallennusnappi.setEnabled(true);
        
        paneeli3.add(arvontanappi);
        //paneeli3.add(latausnappi);
        paneeli3.add(kesto);
        paneeli3.add(tallennusnappi);

        suodatin = new LiikelistaSuodatin(tanssivalikko, koreografia,
                taulukoija, kasittelija, liikelista);
        
        ArvonnanKuuntelija arpoja = new ArvonnanKuuntelija(koreografia, 
                koreografiaEsitys, liikelista, suodatin, kesto, kasittelija, tanssivalikko);
        arvontanappi.addActionListener(arpoja);

        LiikkeenlisayksenKuuntelija lisaaja = new LiikkeenlisayksenKuuntelija(
                suodatin, kasittelija, koreografia, liikelista, koreografiaEsitys, kesto);
        lisaysnappi.addActionListener(lisaaja);

        LiikkeenpoistonKuuntelija poistaja = new LiikkeenpoistonKuuntelija(
                suodatin, koreografia, koreografiaEsitys, kesto, liikelista);
        poistonappi.addActionListener(poistaja);

        LajinvalintaKuuntelija lajivalitsija = new LajinvalintaKuuntelija(suodatin, liikelista);
        tanssivalikko.addActionListener(lajivalitsija);

        TanssinNimiKuuntelija nimeaja = new TanssinNimiKuuntelija(
                koreografia, koreografiaEsitys, nimenvalintapalkki);
        nimenvalintapalkki.addActionListener(nimeaja);

        TallennuksenKuuntelija tallennuskuuntelija
                = new TallennuksenKuuntelija(koreografia, frame);
        tallennusnappi.addActionListener(tallennuskuuntelija);

        container.add(paneeli1, BorderLayout.NORTH);
        container.add(paneeli2, BorderLayout.CENTER);
        container.add(paneeli3, BorderLayout.SOUTH);

    }

    public JFrame getFrame() {
        return frame;
    }

}
