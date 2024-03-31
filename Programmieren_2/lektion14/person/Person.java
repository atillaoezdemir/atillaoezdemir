package de.thws.lektion14.person;

public class Person {
    private String vorname,nachname;
    private Adresse adresse;
    class Adresse {
        private String strasse, hausnummer, postleitzahl, ort;
        public Adresse(String strasse, String hausnummer, String postleitzahl, String ort) {
            if (Character.isUpperCase(strasse.charAt(0))) {
                this.strasse = strasse;
            } else {
                throw new RuntimeException("Straße muss mit einem Großbuchstaben beginnen!");
            }

            if (Character.isUpperCase(ort.charAt(0))) {
                this.ort = ort;
            } else {
                throw new RuntimeException("Ort muss mit einem Großbuchstaben beginnen!");
            }

            if (Character.isDigit(hausnummer.charAt(0))) {
                this.hausnummer = hausnummer;
            } else {
                throw new RuntimeException("Hausnummer muss mit einer Ziffer beginnen!");
            }

            if (Character.isDigit(postleitzahl.charAt(0))) {
                this.postleitzahl = postleitzahl;
            } else {
                throw new RuntimeException("Postleitzahl muss mit einer Ziffer beginnen!");
            }


        }
    }
    public Person(String vorname, String nachname, String strasse, String hausnummer, String postleitzahl, String ort) {
        Adresse a = new Adresse(strasse, hausnummer, postleitzahl, ort);
        if (Character.isUpperCase(vorname.charAt(0))) {
            this.vorname = vorname;
            this.nachname = nachname;
            this.adresse = a;
        } else {
            throw new RuntimeException("Vorname muss mit einem Großbuchstaben beginnen!");
        }
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
