package de.thws.lektion22.Aufgabe2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimzahlThread extends Thread {
    private final List<Integer> zahlenListe;
    private final Map<Integer, Boolean> ergebnis;

    public PrimzahlThread(List<Integer> zahlenListe) {
        this.zahlenListe = zahlenListe;
        this.ergebnis = new HashMap<>();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> zahlenListe1 = Arrays.asList(341, 633910099);
        List<Integer> zahlenListe2 = List.of(29, 100, 17);
        List<Integer> zahlenListe3 = List.of(11, 13, 19);

        PrimzahlThread thread1 = new PrimzahlThread(zahlenListe1);
        PrimzahlThread thread2 = new PrimzahlThread(zahlenListe2);
        PrimzahlThread thread3 = new PrimzahlThread(zahlenListe3);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        Map<Integer, Boolean> gesamtErgebnis = new HashMap<>();
        gesamtErgebnis.putAll(thread1.ergebnis);
        gesamtErgebnis.putAll(thread2.ergebnis);
        gesamtErgebnis.putAll(thread3.ergebnis);

        for (Integer key : gesamtErgebnis.keySet()) {
            Boolean value = gesamtErgebnis.get(key);
            System.out.println(key + " -> " + value);
        }
    }

    public void run() {
        for (int zahl : zahlenListe) {
            ergebnis.put(zahl, isPrimzahl(zahl));
        }
    }

    private boolean isPrimzahl(int zahl) {
        if (zahl <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(zahl); i++) {
            if (zahl % i == 0) {
                return false;
            }
        }
        return true;
    }
}
