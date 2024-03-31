package de.thws.lektion20;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        Spieler a = new Spieler();

        for (Karte karte : a.hand) {
            System.out.println(karte);
        }
        Collections.sort(a.hand);
        for (Karte karte : a.hand) {
            System.out.println(karte);
        }
    }
}
