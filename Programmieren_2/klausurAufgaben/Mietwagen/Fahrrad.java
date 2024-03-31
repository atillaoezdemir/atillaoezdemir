package de.thws.klausurAufgaben.Mietwagen;

public class Fahrrad extends Fahrzeug {
    public Fahrrad() {
        super();
    }

    @Override
    public double berechneGeld(Fahrt f) {
        return f.min * 12.5;
    }
}
