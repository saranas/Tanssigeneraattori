# Rakennekuvaus

Liike-rajapinnan toteuttaa kaksi luokkaa: LiikeElementti ja Liikesarja. LiikeElementti on yksinkertainen palikka, joita yhdistelemällä voi rakentaa monimutkaisempia kokonaisuuksia. Liikesarja on luokka, joka on tehty säilömään listaan Liike-rajapinnan toteuttavia olioita. Koska Liikesarja toteuttaa itsekin rajapinnan, tämä mahdollistaa kokonaisten Liikesarjojen lisäämisen listaan. Liikesarjan toiminnallisuus on hyvin samankaltainen kuin mitä tarvitaan Koreografiassa, joten Koreografia käyttää Liikesarjaa koreografian säilömiseen.

Liikkeeseen liittyy kaksi Tilaa: alkutila ja lopputila. Lisäksi liikkeeseen liittyy yksi Tanssilaji. Liikkeitä voi lisätä Koreografiaan rajattoman paljon.

LiikevarastonKasittelija on olennainen sovelluslogiikkaluokka, joka lukee liikkeitä varastoivaa tiedostoa ja luo sen pohjalta LiikeElementti-olioita. Luokka säilöö valikomassa olevat liikkeet listaan ja tarjoaa metodeja listaan käsiksi pääsemiseksi.

Graafisen käyttöliittymän luokat ovat enimmäkseen kuuntelijoita, jotka liittyvät pääluokassa GraafinenKayttoliittyma luotuihin painikkeisiin ja listoihin.

Käyttöliittymällä on useita apuluokkia kayttoliittymanapu-pakkauksessa. Niiden pääasiallinen tehtävä on toimia työkaluina graafisen käyttöliittymän kuuntelijoille. Pakkauksessa on myös luokka tekstikäyttöliittymää varten.



