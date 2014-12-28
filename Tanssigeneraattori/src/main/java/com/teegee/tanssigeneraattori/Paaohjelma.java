package com.teegee.tanssigeneraattori;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Akkanen
 */
public class Paaohjelma {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        LiikevarastonKasittelija kasittelija = new LiikevarastonKasittelija("liikevarasto.txt");
        Tekstikayttoliittyma tekstikali = new Tekstikayttoliittyma(kasittelija, lukija);

        kasittelija.lue();

        tekstikali.esitteleTanssilajit();
        String tanssilaji = tekstikali.pyydaTanssilajia();
        tekstikali.esitteleLiikkeet(tanssilaji);

        tekstikali.pyydaKoreografianNimea();
        tekstikali.lisaaLiikkeita();
        tekstikali.kysyTallennetaanko();

    }

}
