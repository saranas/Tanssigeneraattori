package main;

import graafinenkali.GraafinenKayttoliittyma;
import kayttoliittymanapu.Tekstikayttoliittyma;
import java.util.Scanner;
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

        //Scanner lukija = new Scanner(System.in);
        LiikevarastonKasittelija kasittelija = new LiikevarastonKasittelija("liikevarasto.txt");
        //Tekstikayttoliittyma tekstikali = new Tekstikayttoliittyma(kasittelija, lukija);
        kasittelija.lue();
        
        GraafinenKayttoliittyma graafkali = new GraafinenKayttoliittyma(kasittelija);
        SwingUtilities.invokeLater(graafkali);
        

//        tekstikali.esitteleTanssilajit();
//        Tanssilaji tanssilaji = tekstikali.pyydaTanssilajia();
//        tekstikali.esitteleLiikkeet(tanssilaji);
//
//        tekstikali.pyydaKoreografianNimea();
//        tekstikali.lisaaLiikkeitaKoreografiaan();
//        tekstikali.kysyTallennetaanko();

    }

}
