package joonaksenTietovisa;

public class PisteidenLaskija {
    private int pisteet;

    public PisteidenLaskija(){
        this.pisteet = 0;
    }

    public int getPisteet() {
        return pisteet;
    }

    public void oikeaVastaus(){
        this.pisteet++;
    }

    public void vaaraVastaus(){
        if (pisteet > 0) this.pisteet--;
    }

    @Override
    public String toString() {
        return "Pistetilanne: " + pisteet;
    }
}
