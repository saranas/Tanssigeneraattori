package main;

import graafinenkali.GraafinenKayttoliittyma;
import kayttoliittymanapu.Tekstikayttoliittyma;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import liikkeidenmallinnus.LiikevarastonKasittelija;
import liikkeidenmallinnus.Tanssilaji;

/**
 * Ohjelman avulla voi luoda ja muokata tanssikoreografioita.
 *
 * @author Akkanen
 */
public class Tanssigeneraattori {

    public static void main(String[] args) {

        LiikevarastonKasittelija kasittelija = new LiikevarastonKasittelija("liikevarasto.txt");
        GraafinenKayttoliittyma graafkali = new GraafinenKayttoliittyma(kasittelija);
        
        try {
            kasittelija.lue();
        } catch (Exception ex) {
            graafkali.naytaVirheilmoitus(ex);
        }

        SwingUtilities.invokeLater(graafkali);
        
        //Scanner lukija = new Scanner(System.in);
        //Tekstikayttoliittyma tekstikali = new Tekstikayttoliittyma(kasittelija, lukija);
//        tekstikali.esitteleTanssilajit();
//        Tanssilaji tanssilaji = tekstikali.pyydaTanssilajia();
//        tekstikali.esitteleLiikkeet(tanssilaji);
//
//        tekstikali.pyydaKoreografianNimea();
//        tekstikali.lisaaLiikkeitaKoreografiaan();
//        tekstikali.kysyTallennetaanko();
    }

}
