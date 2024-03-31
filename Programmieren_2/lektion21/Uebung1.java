package de.thws.lektion21;

public class Uebung1 {
    private int portionsgröße;
    private int anzahlPortionen;
    private double eiweiß;
    private double fett;

    private Uebung1(Builder builder) {
        this.portionsgröße = builder.portionsgröße;
        this.anzahlPortionen = builder.anzahlPortionen;
        this.eiweiß = builder.eiweiß;
        this.fett = builder.fett;
    }
    public static class Builder {
        private final int portionsgröße;
        private final int anzahlPortionen;
        private double eiweiß;
        private double fett;

        public Builder(int portionsgröße, int anzahlPortionen) {
            this.portionsgröße = portionsgröße;
            this.anzahlPortionen = anzahlPortionen;
        }

        public Builder eiweiß(double eiweiß) {
            this.eiweiß = eiweiß;
            return this;
        }

        public Builder fett(double fett) {
            this.fett = fett;
            return this;
        }
        public Uebung1 build() {
            return new Uebung1(this);
        }
    }
}
