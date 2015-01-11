#Testausdokumentaatio

Kayttoliittymanapu-pakkauksen luokat olivat yksikkötestauksen suhteen vähän siinä ja siinä, koska ne enimmäkseen palauttavat satunnaisia asioita, muuttavat jotakin joksikin tai ovat jäänteitä tekstikäyttöliittymästä. Lisäksi ne ovat hyvin lähellä graafista käyttöliittymää, jonka testausta ei ole opetettu. Siksi niiden toimintaa on testattu lähinnä tutkimalla käsin, että ne toimivat suunnilleen niinkuin niiden tulisikin. 

Arpoja-luokkaa on yritetty toteuttaa niin, että se palauttaisi tasan tietynpituisen koreografian. Ongelma on kuitenkin kuulemma NP-vaikea, joten on tyydytty siihen, että luokka toimii suunnilleen tarkoituksenmukaisesti ja palauttaa jonkinlaisen satunnaisen koreografian. Myös Sanakasan on silmämääräisesti todettu toimivan riittävän hyvin.

KoreografianLukija lukee tiedostoja. Jos käyttäjä yrittää avata tiedostoa, joka ei ole ohjelman luoman formaatin mukainen, niin tiedoston tyypistä riippuen tiedoston ensimmäinen rivi saatetaan lukea koreografian nimeksi, tai vaihtoehtoisesti ei tapahdu yhtään mitään. Oikeanlaisella tiedostolla luokan metodit toimivat niinkuin pitääkin. 

Taulukontekijä muuttaa ArrayListejä taulukoiksi. Tämän toimintaa on tutkittu toteamalla, että se palauttaa todellakin taulukoita, ja niiden sisältämät kohteet ovat samoilla paikoilla kuin alkuperäisessä listassakin. 

LiikelistaSuodatin vain sisältää useille graafisen käyttöliittymän kuuntelijoille yhteistä koodia. Sen on todettu toimivan katsomalla ohjelmaa ajettaessa, että liikelista päivittyy oikein.