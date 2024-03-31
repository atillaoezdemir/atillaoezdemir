package de.thws.lektion20;
import java.util.ArrayList;
public class Spieler {
    protected ArrayList<Karte> hand;
    static Hauptdeck hauptdeck = new Hauptdeck();
    public Spieler() {
        hauptdeck.mischeKarten();
        hand = new ArrayList<>();
        zieheKartenhand();
    }

    private void zieheKartenhand() {
        // Ziehe eine zufällige Kartenhand ohne doppelte Karten
        for (int i = 0; i < 5; i++) {
            Karte karte = hauptdeck.get(i);
            hand.add(karte);
            hauptdeck.remove(i);
        }
    }
}
