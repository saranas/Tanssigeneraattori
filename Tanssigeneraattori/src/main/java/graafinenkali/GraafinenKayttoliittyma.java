package graafinenkali;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import liikkeidenmallinnus.*;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private LiikevarastonKasittelija kasittelija;
    private Koreografia koreografia;

    public GraafinenKayttoliittyma(LiikevarastonKasittelija kasittelija) {
        this.kasittelija = kasittelija;
        this.koreografia = new Koreografia("Nimi");
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
        String[] tanssilista = new String[tanssilajilista.size()];
        for (int i = 0; i < tanssilajilista.size(); i++) {
            tanssilista[i] = tanssilajilista.get(i).getNimi();
        }

        JComboBox tanssivalikko = new JComboBox(tanssilista);
        //tanssivalikko.setSelectedIndex(0);
        //tanssivalikko.addActionListener(this);

        paneeli.add(tanssivalikko);
        paneeli.add(new JTextField("Tanssin nimi"));
        return paneeli;
    }
    
    private JPanel keskiBlokki() {
        JPanel paneeli = new JPanel(new GridLayout(1, 3));

        JList liikelista = new JList();
        JToolBar napit = new JToolBar();
        JEditorPane koreografiaEsitys = new JEditorPane();
        
        paneeli.add(liikelista);
        paneeli.add(napit);
        paneeli.add(koreografiaEsitys);
        return paneeli;
    }
    
    private JPanel alaBlokki() {
        JPanel paneeli = new JPanel();
        
        JTextField kesto = new JTextField("Tanssin kesto: ");
        JButton tallennusnappi = new JButton("Tallenna");
        
        paneeli.add(tallennusnappi);
        
        return paneeli;
    }

    public JFrame getFrame() {
        return frame;
    }
}
