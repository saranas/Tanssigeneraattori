package graafinenkali;

import java.util.ArrayList;
import liikkeidenmallinnus.Liike;
import liikkeidenmallinnus.Tanssilaji;

public class Taulukontekija {
    
    
    public String[] annaLiikkeetTaulukkona(ArrayList<Liike> vanhalista) {
        String[] uusitaulukko = new String[vanhalista.size()];
        for (int i = 0; i < vanhalista.size(); i++) {
            uusitaulukko[i] = vanhalista.get(i).getNimi();
        }
        return uusitaulukko;
    }
    
    public String[] annaLajitTaulukkona(ArrayList<Tanssilaji> vanhalista) {
        String[] uusitaulukko = new String[vanhalista.size()];
        for (int i = 0; i < vanhalista.size(); i++) {
            uusitaulukko[i] = vanhalista.get(i).getNimi();
        }
        return uusitaulukko;
    }

}
