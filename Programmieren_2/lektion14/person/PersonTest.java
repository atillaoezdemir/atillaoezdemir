package de.thws.lektion14.person;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.lektion14.person.Person;
import org.junit.jupiter.api.Test;

public class PersonTest {

    // Code duplication can be greatly reduced with BeforeEach or BeforeAll

    @Test
    public void vornameTest() {
        String strasse = "Beispielstraße";
        String hausnummer = "1";
        String postleitzahl = "1";
        String ort = "Beispielort";
        String vorname = "beispiel";
        String nachname = "Beispiel";
        try {
            new Person(vorname, nachname, strasse, hausnummer, postleitzahl, ort);
            fail("Runtime Exception erwartet!");
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            assertEquals("Vorname muss mit einem Großbuchstaben beginnen!", errorMessage);
        }
    }
    
    @Test
    public void strasseTest() {
        String strasse = "beispielstraße";
        String hausnummer = "1";
        String postleitzahl = "1";
        String ort = "Beispielort";
        String vorname = "Beispiel";
        String nachname = "Beispiel";
        try {
            new Person(vorname, nachname, strasse, hausnummer, postleitzahl, ort);
            fail("Runtime Exception erwartet!");
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            assertEquals("Straße muss mit einem Großbuchstaben beginnen!", errorMessage);
        }
    }

    @Test
    public void ortTest() {
        String strasse = "Beispielstraße";
        String hausnummer = "1";
        String postleitzahl = "1";
        String ort = "beispielort";
        String vorname = "Beispiel";
        String nachname = "Beispiel";
        
        try {
            new Person(vorname, nachname, strasse, hausnummer, postleitzahl, ort);
            fail("Runtime Exception erwartet!");
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            assertEquals("Ort muss mit einem Großbuchstaben beginnen!", errorMessage);
        }
    }

    @Test
    public void hausnummerTest() {
        String strasse = "Beispielstraße";
        String hausnummer = "A";
        String postleitzahl = "1";
        String ort = "Beispielort";
        String vorname = "Beispiel";
        String nachname = "Beispiel";
        
        try {
            new Person(vorname, nachname, strasse, hausnummer, postleitzahl, ort);
            fail("Runtime Exception erwartet!");
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            assertEquals("Hausnummer muss mit einer Ziffer beginnen!", errorMessage);
        }
    }

    @Test
    public void postleitzahlTest() {
        String strasse = "Beispielstraße";
        String hausnummer = "1";
        String postleitzahl = "A";
        String ort = "Beispielort";
        String vorname = "Beispiel";
        String nachname = "Beispiel";
        try {
            new Person(vorname, nachname, strasse, hausnummer, postleitzahl, ort);
            fail("Runtime Exception erwartet!");
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            assertEquals("Postleitzahl muss mit einer Ziffer beginnen!", errorMessage);
        }
    }
}
