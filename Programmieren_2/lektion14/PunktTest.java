package de.thws.lektion14;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PunktTest {

    @Test
    public void testGueltigeKoordinaten() {
        Punkt p = new Punkt();
        p.verschiebePunkt(100, 200);
        assertEquals(100, p.x);
        assertEquals(200, p.y);
    }
    
    @Test
    public void testNegativeX() {
        Punkt p = new Punkt();
            try {
                p.verschiebePunkt(-100, 200);
                fail("Runtime Exception erwartet");
            }
            catch(RuntimeException e) {
                String errorMessage = e.getMessage();
                assertEquals("Ungültige Zahlen!", errorMessage);
            }
    }    
    
    @Test
    public void testNegativeY() {
        Punkt p = new Punkt();
        try {
            p.verschiebePunkt(-100, 200);
            fail("Runtime Exception erwartet");
        }
        catch(RuntimeException e) {
            String errorMessage = e.getMessage();
            assertEquals("Ungültige Zahlen!", errorMessage);
        }
    }
    
    @Test
    public void testGrosseX() {
        Punkt p = new Punkt();
        try {
            p.verschiebePunkt(1921, 200);
            fail("Runtime Exception erwartet");
        } catch(RuntimeException e) {
            String errorMessage = e.getMessage();
            assertEquals("Ungültige Zahlen!", errorMessage);
        }
    }
    
    @Test
    public void testGrosseY() {
        Punkt p = new Punkt();
        try {
            p.verschiebePunkt(100, 1081);
            fail("Runtime Exception erwartet");
        } catch(RuntimeException e) {
            String errorMessage = e.getMessage();
            assertEquals("Ungültige Zahlen!", errorMessage);
        }
    }
}

