package miikanTietovisa;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

public class Kysymys {
    private String kysymysteksti;
    private List<String> vastaukset = new ArrayList<>();
    private String oikea;

    Kysymys(String teksti) {
        int kyssarinIndeksi = teksti.indexOf("?");
        this.kysymysteksti = teksti.substring(0, kyssarinIndeksi + 1);
        String[] jako = teksti.substring(kyssarinIndeksi + 1).split(",");
        for (int i = 0; i < jako.length - 1; i++) {
            this.vastaukset.add(jako[i].trim());
        }
        shuffle(vastaukset);
        oikea = jako[jako.length - 1].trim();
    }

    public boolean onkoOikein(char vastaus) {
        if (vastaus == 'a') {
            if (vastaukset.get(0).equals(this.oikea)) {
                return true;
            }
        } else if (vastaus == 'b') {
            if (vastaukset.get(1).equals(this.oikea)) {
                return true;
            }
        } else if (vastaus == 'c') {
            if (vastaukset.get(2).equals(this.oikea)) {
                return true;
            }
        }
        return false;
    }

    public void tulostaKysymys() {
        System.out.println(kysymysteksti +
                "\ta) " + vastaukset.get(0) +
                "\tb) " + vastaukset.get(1) +
                "\tc) " + vastaukset.get(2));
    }

    public String getOikea() {
        return oikea;
    }


}
