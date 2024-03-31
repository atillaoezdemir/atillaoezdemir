package de.thws.lektion14;

public class Strecke {
    private final int anfangspunkt;
    private final int endpunkt;
    public Strecke(int a, int b){
        if(a < 0 || b < 0){
            throw new RuntimeException("Weder anfangspunkt noch endpunkt können negativ sein!");
        }
        else if(a > b){
            throw new RuntimeException("anfangspunkt kann nicht größer als endpunkt sein!");
        }
        else{
            this.anfangspunkt = a;
            this.endpunkt = b;
        }
    }
    public boolean ueberschneidung(Strecke neu){
        return neu.endpunkt > this.anfangspunkt || neu.anfangspunkt < this.endpunkt;
    }
    public String streckeToString() {
        if (this.anfangspunkt == this.endpunkt) {
            return String.valueOf(anfangspunkt);
        }
        else{
            String dash = "";
            for(int i = 1; i < endpunkt - anfangspunkt ; i++) {
                dash += "-";
            }
            return anfangspunkt + dash + endpunkt;
        }
    }
}
