package nikonTietovisa.kysymykset;

import java.util.List;

public class Kysymys {
    private String kysymysteksti;
    private List<String> vastausvaihtoehdot;
    private int oikeanVaihtoehdonIndeksi;

    public Kysymys(String kysymysteksti, List<String> vastausvaihtoehdot, int oikeanVaihtoehdonIndeksi) {
        this.kysymysteksti = kysymysteksti;
        this.vastausvaihtoehdot = vastausvaihtoehdot;
        this.oikeanVaihtoehdonIndeksi = oikeanVaihtoehdonIndeksi;
    }

    public String getKysymysteksti() {
        return kysymysteksti;
    }

    public List<String> getVastausvaihtoehdot() {
        return vastausvaihtoehdot;
    }

    public String oikeaVastausMerkkijonona() {
        return ""+ (char)(this.oikeanVaihtoehdonIndeksi + 97);
    }

    public String vaihtoehtoKirjaimena(int numero) {
        return ""+ (char)(numero + 97);
    }
}