/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teegee.tanssigeneraattori;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Akkanen
 */
public class Paaohjelma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Koreografia tanssi1 = new Koreografia("Jenkka");

        System.out.println(tanssi1);
        
        LiikevarastonKasittelija kasittelija = new LiikevarastonKasittelija();
        kasittelija.lue();
        

    }

}
