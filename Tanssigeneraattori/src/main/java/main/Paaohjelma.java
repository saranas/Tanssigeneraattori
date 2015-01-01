package main;

import graafinenkali.GraafinenKayttoliittyma;
import tekstikayttoliittyma.Tekstikayttoliittyma;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import liikkeidenmallinnus.LiikevarastonKasittelija;
import liikkeidenmallinnus.Tanssilaji;

/**
 *
 * @author Akkanen
 */
public class Paaohjelma {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        LiikevarastonKasittelija kasittelija = new LiikevarastonKasittelija("liikevarasto.txt");
        Tekstikayttoliittyma tekstikali = new Tekstikayttoliittyma(kasittelija, lukija);
        
        GraafinenKayttoliittyma graafkali = new GraafinenKayttoliittyma(kasittelija);
        SwingUtilities.invokeLater(graafkali);

        kasittelija.lue();

        tekstikali.esitteleTanssilajit();
        Tanssilaji tanssilaji = tekstikali.pyydaTanssilajia();
        tekstikali.esitteleLiikkeet(tanssilaji);

        tekstikali.pyydaKoreografianNimea();
        tekstikali.lisaaLiikkeitaKoreografiaan();
        tekstikali.kysyTallennetaanko();

    }

}
