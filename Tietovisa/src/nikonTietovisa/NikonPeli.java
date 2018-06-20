package nikonTietovisa;

import nikonTietovisa.kayttis.Kayttoliittyma;
import nikonTietovisa.kysymykset.Kysymys;
import nikonTietovisa.kysymykset.Kysymystenlukija;

import java.util.List;

public class NikonPeli {

    public void kaynnista() {
        Kysymystenlukija kys = new Kysymystenlukija();
        List<Kysymys> kysymykset = kys.kysymyslista();
        Kayttoliittyma kl = new Kayttoliittyma(kysymykset);
        kl.kaynnista();
    }
}