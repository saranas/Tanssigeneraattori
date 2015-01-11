package graafinenkali;

import kayttoliittymanapu.Taulukontekija;
import java.awt.BorderLayout;
import java.awt.Color;
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
    private Exception ex;

    public GraafinenKayttoliittyma(LiikevarastonKasittelija kasittelija) {
        this.kasittelija = kasittelija;
        this.taulukoija = new Taulukontekija();
        this.koreografia = new Koreografia("Tanssin nimi");
    }

    public void naytaVirheilmoitus(Exception ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        frame = new JFrame("Tanssigeneraattori");
        frame.setPreferredSize(new Dimension(700, 500));
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

        JPanel ylapaneeli = new JPanel(new GridLayout(1, 2));

        //Drop down -valikko tanssilajeista
        ArrayList<Tanssilaji> tanssilajilista = kasittelija.annaTanssilajit();
        String[] tanssilista = taulukoija.annaLajitTaulukkona(tanssilajilista);
        JComboBox tanssivalikko = new JComboBox(tanssilista);
        String kaikki = "kaikki";
        tanssivalikko.insertItemAt(kaikki, 0);
        tanssivalikko.setSelectedIndex(0);

        //Palkki tanssin nimen syöttämiseen
        JTextField nimenvalintapalkki = new JTextField("Tanssin nimi", 20);

        ylapaneeli.add(tanssivalikko);
        ylapaneeli.add(nimenvalintapalkki);

        JPanel keskipaneeli = new JPanel();
        keskipaneeli.setLayout(new BoxLayout(keskipaneeli, BoxLayout.LINE_AXIS));

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
        keskipaneeli.add(liikevalikko);
        keskipaneeli.add(napit);
        keskipaneeli.add(koreografiaesitysSkrolli);

        JPanel alapaneeli = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        JLabel virhekentta = new JLabel();
        alapaneeli.add(virhekentta);
        if (this.ex != null) {
            virhekentta.setText("Liikevaraston lukeminen epäonnistui");
            virhekentta.setForeground(Color.red);
        }

        JButton arvontanappi = new JButton("Random!");
        JButton latausnappi = new JButton("Lataa");
        JLabel kesto = new JLabel("Tanssin kesto: " + String.valueOf(koreografia.tanssinKesto()));
        JButton tallennusnappi = new JButton("Tallenna");
        tallennusnappi.setEnabled(true);

        alapaneeli.add(latausnappi);
        alapaneeli.add(arvontanappi);
        alapaneeli.add(kesto);
        alapaneeli.add(tallennusnappi);

        suodatin = new LiikelistaSuodatin(tanssivalikko,
                taulukoija, kasittelija, liikelista);

        LatauksenKuuntelija lataaja = new LatauksenKuuntelija(suodatin, kasittelija,
                koreografia, liikelista, koreografiaEsitys, kesto);
        latausnappi.addActionListener(lataaja);

        ArvonnanKuuntelija arpoja = new ArvonnanKuuntelija(koreografia,
                koreografiaEsitys, liikelista, suodatin, kesto, kasittelija, tanssivalikko);
        arvontanappi.addActionListener(arpoja);

        LiikkeenlisayksenKuuntelija lisaaja = new LiikkeenlisayksenKuuntelija(
                suodatin, kasittelija, koreografia, liikelista, koreografiaEsitys, kesto);
        lisaysnappi.addActionListener(lisaaja);

        LiikkeenpoistonKuuntelija poistaja = new LiikkeenpoistonKuuntelija(
                suodatin, koreografia, koreografiaEsitys, kesto, liikelista);
        poistonappi.addActionListener(poistaja);

        LajinvalintaKuuntelija lajivalitsija = new LajinvalintaKuuntelija(suodatin, liikelista, koreografia);
        tanssivalikko.addActionListener(lajivalitsija);

        TanssinNimiKuuntelija nimeaja = new TanssinNimiKuuntelija(
                koreografia, koreografiaEsitys, nimenvalintapalkki);
        nimenvalintapalkki.addActionListener(nimeaja);

        TallennuksenKuuntelija tallennuskuuntelija = new TallennuksenKuuntelija(koreografia, frame, virhekentta);
        tallennusnappi.addActionListener(tallennuskuuntelija);

        container.add(ylapaneeli, BorderLayout.NORTH);
        container.add(keskipaneeli, BorderLayout.CENTER);
        container.add(alapaneeli, BorderLayout.SOUTH);

    }

    public JFrame getFrame() {
        return frame;
    }

}
