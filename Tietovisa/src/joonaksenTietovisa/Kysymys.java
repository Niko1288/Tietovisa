package joonaksenTietovisa;

import java.util.ArrayList;
import java.util.List;

public class Kysymys {
    private String kysymys;
    private List<String> vastaukset;
    private List<String> vaihtoehdot;

    public Kysymys(String kysymys) {
        this.kysymys = kysymys;
        this.vaihtoehdot = new ArrayList<>();
        this.vastaukset = new ArrayList<>();
    }

    public String getKysymys() {
        return kysymys;
    }

    public void setKysymys(String kysymys) {
        this.kysymys = kysymys;
    }

    public void lisaaVastaus(String vastaus){
        this.vastaukset.add(vastaus);
    }

    public void lisaaVaihtoehto(String vaihtoehto){
        this.vaihtoehdot.add(vaihtoehto);
    }

    public List<String> getVastaukset() {
        return vastaukset;
    }

    public List<String> getVaihtoehdot() {
        return vaihtoehdot;
    }
}
