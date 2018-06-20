import joonaksenTietovisa.*;
import miikanTietovisa.*;
import nikonTietovisa.*;

import java.util.Scanner;

public class Paavalikko {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        JoonaksenPeli joonas = new JoonaksenPeli();
        MiikanPeli miika = new MiikanPeli();
        NikonPeli niko = new NikonPeli();


        System.out.println("Tervetuloa pelaamaan!");

        outer:
        while (true) {
            inner:
            while (true) {
                System.out.println("Kenen peliä haluaisit pelata? (Joonas, Miika tai Niko)");
                String vastaus = lukija.nextLine().toLowerCase();
                switch (vastaus) {
                    case "joonas":
                        joonas.kaynnista();
                        break inner;
                    case "miika":
                        miika.kaynnista();
                        break inner;
                    case "niko":
                        niko.kaynnista();
                        break inner;
                    default:
                        System.out.println("Väärä nimi, yritä uudelleen!");
                }
            }
            System.out.println("Haluatko jatkaa? y/n");
            String vastaus = lukija.nextLine();

            if (vastaus.equals("n")) {
                System.out.println("Kiitos pelaamisesta ja mukavaa päivänjatkoa!");
                break;
            }
        }
    }
}
