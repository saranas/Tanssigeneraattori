package liikkeidenmallinnus;

public interface Liike {
    
    String getNimi();
    Tanssilaji getTanssilaji();
    int getKesto();
    Tila getAlkutila();
    Tila getLopputila();

}
