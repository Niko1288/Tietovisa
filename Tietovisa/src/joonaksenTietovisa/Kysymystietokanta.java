package joonaksenTietovisa;

import java.io.File;
import java.util.*;

public class Kysymystietokanta {
    private List<Kysymys> kysymykset;

    public Kysymystietokanta(String tiedosto){
        this.kysymykset = new LinkedList<>();
        lisaaKysymyksetTiedostosta(tiedosto);
    }

    //lisätään kysymys listalle
    public void lisaaKysymys(Kysymys k) {
        this.kysymykset.add(k);
    }

    //luetaan kysymykset tiedostosta ja lisätään ne listalle
    public void lisaaKysymyksetTiedostosta(String tiedosto){
        try (Scanner tiedostonLukija = new Scanner(new File(tiedosto))) {

            // luetaan kysymykset
            while (tiedostonLukija.hasNextLine()) {
                // luetaan kysymys ja luodaan sitä vastaava olio
                String kysymyksenKysymys = tiedostonLukija.nextLine();
                Kysymys kysymys = new Kysymys(kysymyksenKysymys);

                //lisätään kysymykseen oikea vastaus, ja lisätään se vaihtoehtojen listalle
                String vastaus = tiedostonLukija.nextLine();
                kysymys.lisaaVastaus(vastaus);
                kysymys.lisaaVaihtoehto(vastaus);

                // lisätään kysymykseen vastausvaihtoehdot
                while (tiedostonLukija.hasNextLine()) {
                    String vaihtoehto = tiedostonLukija.nextLine();

                    // kysymyksen vaihtoehdot lopetetaan tyhjällä rivillä
                    if(vaihtoehto.isEmpty()) {
                        // poistutaan tästä while-toistolauseesta
                        // (ulompi jatkaa)
                        break;
                    }

                    kysymys.lisaaVaihtoehto(vaihtoehto);
                }

                // lisätään kysymys listalle
                this.kysymykset.add(kysymys);
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }

    //kysytään kysymys ja poistetaan se listalta
    public void kysy(Scanner lukija, PisteidenLaskija laskuri){
        Collections.shuffle(kysymykset);
        Kysymys kysymys = kysymykset.get(0); // haetaan listan ensimmäinen kysymys
        System.out.println();
        System.out.println(kysymys.getKysymys()); //tulostetaan kysymys
        System.out.println();

        // jos kysymyksessä on annettu vaihtoehtoja
        if (kysymys.getVaihtoehdot().size() > 1) {
            Collections.sort(kysymys.getVaihtoehdot());
            for (String vaihtoehto: kysymys.getVaihtoehdot()){
                 System.out.println(vaihtoehto);
            }

            // pyydetään vastaus pelaajalta
            System.out.println();
            System.out.print("Vastauksesi (kirjoita vastausta vastaava kirjain): ");

            char kirjain = 'a';
            String vastaus = lukija.nextLine();

            if (vastaus.length()>0) {
                kirjain =  vastaus.charAt(0);
            }

            if (vastaus.equals("")) System.out.println(laskuri);

            else if (kysymys.getVastaukset().get(0).charAt(0) == kirjain){
                System.out.println("Oikein!");
                laskuri.oikeaVastaus();
                System.out.println(laskuri);
            }

            else {
                System.out.println("Väärin...");
                laskuri.vaaraVastaus();
                System.out.println(laskuri);
            }
            kysymykset.remove(0); //poistetaan kysytty kysymys listalta
        }

        //jos kysymyksessä ei ole vaihtoehtoja
        else {
            // pyydetään vastaus pelaajalta
            System.out.println();
            System.out.print("Vastauksesi: ");
            String vastaus = lukija.nextLine();

            if (vastaus.equals("")) System.out.println(laskuri);

            else if (kysymys.getVastaukset().contains(vastaus)){
                System.out.println("Oikein!");
                laskuri.oikeaVastaus();
                System.out.println(laskuri);
            }

            else {
                System.out.println("Väärin...");
                laskuri.vaaraVastaus();
                System.out.println(laskuri);
            }
            kysymykset.remove(0); //poistetaan kysytty kysymys listalta
        }
    }

    public int kysymyslistanKoko(){
        return kysymykset.size();
    }
}
