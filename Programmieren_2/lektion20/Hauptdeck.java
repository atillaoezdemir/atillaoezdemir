package de.thws.lektion20;
import java.util.ArrayList;
import java.util.Collections;
public class Hauptdeck  extends ArrayList<Karte>{
    static protected ArrayList<Karte> karten;
    public Hauptdeck() {
        super();
        erstelleKarten();
    }
    private void erstelleKarten() {
        for (Farbe farbe : Farbe.values()) {
            for (Wert wert : Wert.values()) {
                Karte karte = new Karte(farbe, wert);
                super.add(karte);
            }
        }
    }
    protected void mischeKarten() {
        Collections.shuffle(this);
    }
}
