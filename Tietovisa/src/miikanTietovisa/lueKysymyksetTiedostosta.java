package miikanTietovisa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;


public class lueKysymyksetTiedostosta {

    public static List<Kysymys> teeKysymyslista(String polku) {

        List<Kysymys> kysymysLista = new ArrayList<>();
        try (FileReader fr = new FileReader("miikanKysymykset.txt");
             BufferedReader br = new BufferedReader(fr)) {
            StringBuilder teksti = new StringBuilder();
            String rivi;
            int i = 0;
            outer:
            while ((rivi = br.readLine()) != null) { //luetaan rivi kerrallaan
                if (i < 3) {
                    i++;
                    continue;
                }
                if (rivi.trim().isEmpty()) continue; // Ei tyhjiä rivejä
                teksti.append(rivi).append("\n");
            }
            String kysymystekstit = teksti.toString();
            String[] rivit = kysymystekstit.split("\n");
            for (int j = 0; j < rivit.length; j++) {
                kysymysLista.add(new Kysymys(rivit[j])); //Muodostetaan jokaisesta rivistä uusi kysymysolio
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        shuffle(kysymysLista);

        return kysymysLista.subList(0,Math.min(10,kysymysLista.size()));
    }
}
