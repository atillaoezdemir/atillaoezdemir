package de.thws.lektion14;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class SignTest {
    @Test
     public void testNull() {
        double radius = 0;
        double erwartet = 0;
        double tatsaechlich = KugelVolumen.berechneKugelvolumen(radius);
        assertEquals(erwartet, tatsaechlich, 0.0001);
    }

    @Test
    public void testEins() {
        double radius = 1;
        double erwartet = 4.188;
        double tatsaechlich = KugelVolumen.berechneKugelvolumen(radius);
        assertEquals(erwartet, tatsaechlich, 0.001);
    }

    @Test
    public void testFuenf() {
        double radius = 5;
        double erwartet = 523.5988;
        double tatsaechlich = KugelVolumen.berechneKugelvolumen(radius);
        assertEquals(erwartet, tatsaechlich, 0.0001);
    }

    @Test
    public void testMinus() {
        double radius = -1;
        try{
            KugelVolumen.berechneKugelvolumen(radius);
            fail("RuntimeException erwartet!");
        } catch (RuntimeException e){
            String errorMessage = e.getMessage();
            assertEquals("Radius muss positiv sein!" , errorMessage);
        }
    }
}
