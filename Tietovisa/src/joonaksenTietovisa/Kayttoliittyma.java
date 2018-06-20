package joonaksenTietovisa;

import java.util.Scanner;

public class Kayttoliittyma {
    public void kaynnista(Kysymystietokanta kysymykset, Scanner lukija, PisteidenLaskija laskuri){

        int kysytyt = 0;

        System.out.println("Tervetuloa tietovisaan!");
        System.out.println();
        System.out.print("Säännöt: ");
        System.out.println("Oikeasta vastauksesta saa yhden pisteen, tyhjästä vastauksesta 0 ja väärästä -1.");
        System.out.println("Huomioi, että kirjoitat isot ja pienet kirjaimet oikein!");
        System.out.println("Kun olet valmis aloittamaan, paina Enter-näppäintä!");
        System.out.println();
        System.out.println("----------------------------------------");

        if (lukija.nextLine().equals("")) {
            while (kysymykset.kysymyslistanKoko()>0) {
                kysymykset.kysy(lukija,laskuri);
                kysytyt++;
            }

            System.out.println("Kiitos pelaamisesta! Lopullinen tuloksesi: " + laskuri.getPisteet() + "/" + kysytyt);
        }
    }
}
