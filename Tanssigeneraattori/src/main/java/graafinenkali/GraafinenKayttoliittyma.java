package graafinenkali;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import liikkeidenmallinnus.*;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private LiikevarastonKasittelija kasittelija;
    private Koreografia koreografia;
    private Tanssilaji tanssilaji;
    private JList liikelista;
    private Taulukontekija taulukoija;

    public GraafinenKayttoliittyma(LiikevarastonKasittelija kasittelija) {
        this.kasittelija = kasittelija;
        this.koreografia = new Koreografia("Nimi");
        this.taulukoija = new Taulukontekija();
    }

    public void setLiikelista(JList liikelista) {
        this.liikelista = liikelista;
    }   

    @Override
    public void run() {
        frame = new JFrame("Tanssigeneraattori");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(ylaBlokki(), BorderLayout.NORTH);
        container.add(keskiBlokki(), BorderLayout.CENTER);
        container.add(alaBlokki(), BorderLayout.SOUTH);
    }

    private JPanel ylaBlokki() {
        JPanel paneeli = new JPanel(new GridLayout(1, 2));

        ArrayList<Tanssilaji> tanssilajilista = kasittelija.annaTanssilajit();
        String[] tanssilista = taulukoija.annaLajitTaulukkona(tanssilajilista);

        JComboBox tanssivalikko = new JComboBox(tanssilista);
        LajinvalintaKuuntelija lajivalitsija = 
                new LajinvalintaKuuntelija(kasittelija, tanssivalikko, liikelista);
        tanssivalikko.addActionListener(lajivalitsija);
        //tanssivalikko.setSelectedIndex(0);
        //tanssivalikko.addActionListener(this);

        paneeli.add(tanssivalikko);
        paneeli.add(new JTextField("Tanssin nimi"));
        return paneeli;
    }

    private JPanel keskiBlokki() {
        JPanel paneeli = new JPanel();
        paneeli.setLayout(new BoxLayout(paneeli, BoxLayout.LINE_AXIS));

        ArrayList<Liike> liikkeet = kasittelija.annaLiikevalikoima();
        String[] liiketaulukko = taulukoija.annaLiikkeetTaulukkona(liikkeet);
        liikelista = new JList(liiketaulukko);
        

        JScrollPane liikevalikko = new JScrollPane(liikelista);
        liikevalikko.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel napit = new JPanel();
        napit.setLayout(new BoxLayout(napit, BoxLayout.PAGE_AXIS));
        JButton lisaysnappi = new JButton(">");
        JButton poistonappi = new JButton("X");
        napit.add(lisaysnappi);
        napit.add(poistonappi);

        JEditorPane koreografiaEsitys = new JEditorPane();
        koreografiaEsitys.setEditable(false);
        JScrollPane koreografiaesitysSkrolli = new JScrollPane(koreografiaEsitys);
        koreografiaesitysSkrolli.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        koreografiaesitysSkrolli.setPreferredSize(new Dimension(250, 145));
        koreografiaesitysSkrolli.setMinimumSize(new Dimension(10, 10));

        paneeli.add(liikevalikko);
        paneeli.add(napit);
        paneeli.add(koreografiaEsitys);
        return paneeli;
    }

    private JPanel alaBlokki() {
        JPanel paneeli = new JPanel();

        JLabel kesto = new JLabel("Tanssin kesto: ");
        JButton tallennusnappi = new JButton("Tallenna");

        paneeli.add(kesto);
        paneeli.add(tallennusnappi);

        return paneeli;
    }

    public JFrame getFrame() {
        return frame;
    }


}
