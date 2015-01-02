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
    private JList liikelista;
    private Taulukontekija taulukoija;
    private Koreografia koreografia;

    public GraafinenKayttoliittyma(LiikevarastonKasittelija kasittelija) {
        this.kasittelija = kasittelija;
        this.taulukoija = new Taulukontekija();
        this.koreografia = new Koreografia("Tanssin nimi");
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

    public void setLiikelista(JList liikelista) {
        this.liikelista = liikelista;
    }
    

    private void luoKomponentit(Container container) {

        JPanel paneeli1 = new JPanel(new GridLayout(1, 2));

        ArrayList<Tanssilaji> tanssilajilista = kasittelija.annaTanssilajit();
        String[] tanssilista = taulukoija.annaLajitTaulukkona(tanssilajilista);

        JComboBox tanssivalikko = new JComboBox(tanssilista);
        

        paneeli1.add(tanssivalikko);
        paneeli1.add(new JTextField("Tanssin nimi"));
        
        
        JPanel paneeli2 = new JPanel();
        paneeli2.setLayout(new BoxLayout(paneeli2, BoxLayout.LINE_AXIS));

        //Luo skrollivalikon liikkeistä
        ArrayList<Liike> liikkeet = kasittelija.annaLiikevalikoima();
        String[] liiketaulukko = taulukoija.annaLiikkeetTaulukkona(liikkeet);
        liikelista = new JList(liiketaulukko); 
        JScrollPane liikevalikko = new JScrollPane(liikelista);      
        liikevalikko.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel napit = new JPanel();
        napit.setLayout(new BoxLayout(napit, BoxLayout.PAGE_AXIS));
        
        JButton lisaysnappi = new JButton(">");       
        JButton poistonappi = new JButton("X");

        JEditorPane koreografiaEsitys = new JEditorPane();
        koreografiaEsitys.setEditable(false);
        koreografiaEsitys.setText("muuvei");
        JScrollPane koreografiaesitysSkrolli = new JScrollPane(koreografiaEsitys);
        koreografiaesitysSkrolli.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //koreografiaesitysSkrolli.setPreferredSize(new Dimension(250, 145));
        //koreografiaesitysSkrolli.setMinimumSize(new Dimension(10, 10));
        
        
        napit.add(lisaysnappi);
        napit.add(poistonappi);
        paneeli2.add(liikevalikko);
        paneeli2.add(napit);
        paneeli2.add(koreografiaEsitys);
        
        
        JPanel paneeli3 = new JPanel();

        JLabel kesto = new JLabel("Tanssin kesto: " + String.valueOf(koreografia.tanssinKesto()));
        JButton tallennusnappi = new JButton("Tallenna");

        paneeli3.add(kesto);
        paneeli3.add(tallennusnappi);
        
        LiikkeenlisayksenKuuntelija lisaaja = 
                new LiikkeenlisayksenKuuntelija(kasittelija, 
                        koreografia, liikelista, 
                        koreografiaEsitys, kesto);
        lisaysnappi.addActionListener(lisaaja);
        
        LiikkeenpoistonKuuntelija poistaja = 
                new LiikkeenpoistonKuuntelija(koreografia, koreografiaEsitys, kesto);
        poistonappi.addActionListener(poistaja);
        
        LajinvalintaKuuntelija lajivalitsija = 
                new LajinvalintaKuuntelija(kasittelija, tanssivalikko, liikelista);
        tanssivalikko.addActionListener(lajivalitsija);

        
        
        container.add(paneeli1, BorderLayout.NORTH);
        container.add(paneeli2, BorderLayout.CENTER);
        container.add(paneeli3, BorderLayout.SOUTH);
   
    }


    public JFrame getFrame() {
        return frame;
    }


}
