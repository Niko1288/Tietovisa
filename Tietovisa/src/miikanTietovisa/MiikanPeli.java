package miikanTietovisa;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MiikanPeli {
    public void kaynnista() {
        List<Kysymys> kysymyssetti = lueKysymyksetTiedostosta.teeKysymyslista("miikanKysymykset.txt");
        Scanner lukija = new Scanner(System.in);
        int pisteet = 0;
        System.out.println("Pelataan hauskaa kysymyspeliä!!\n" +
                "Vastaa yhdellä kirjaimella (a b tai c)\n");
        String[] harmitukset = {"Ei ollut oikein.","Harmillisesti hieman pieleen.","Voi räkä, väärin meni.",
                "Olisi kannattanut miettiä uudelleen, ei ollut nimittäin oikein.","Nyt ei osunut oikeaan.",
                "Himpura, väärin meni.","Ei osunut tällä kertaa.","Hupsis, meni väärin.",
                "Mieti ensi kerralla hieman tarkemmin, osaat varmasti, vaikka nyt menikin väärin..",
                "Väärin."};

        String[] riemut = {"Jihuu, oikein!", "Aivan mahtavaa!",
                "Hienosti!","Huraa, Huraa! Olet superhyvä!",
                "Prikulleen niin!","Jes, oikein!",
                "Juurikin niin, hyvin tiesit!","Oikein meni!",
                "Oikein! Mahdatko huijata, kun tiedät noin hyvin?","Huippua, oikein!"};

        Random arpoja = new Random();

        for (Kysymys kysymys : kysymyssetti) {
            kysymys.tulostaKysymys();
            char vastaus2;
            while (true) {
                String vastaus = lukija.next().toLowerCase();
                if (vastaus.length()==1){
                    vastaus2 = (char) vastaus.charAt(0);
                } else {
                    System.out.println("Vastaus ei kelpaa!\nVastaa yhdellä kirjaimista a, b tai c.");
                    continue;
                }
                break;
            }
            if (kysymys.onkoOikein(vastaus2)) {
                System.out.println(riemut[arpoja.nextInt(riemut.length)] + "\n");
                pisteet++;
            } else {
                System.out.println(harmitukset[arpoja.nextInt(harmitukset.length)] + "\n" +
                        "Oikea vastaus: " + kysymys.getOikea() + "\n");
            }
        }

        System.out.println("Peli ohi. Pisteesi: " + pisteet + "/" + kysymyssetti.size());
    }
}
