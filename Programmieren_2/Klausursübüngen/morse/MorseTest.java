package de.thws.klausurAufgaben;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseTest {
    
    @Test
    public void testZeichenketteToMorse() {
        Morse m = new Morse();
        assertEquals("−.-. .- - ", Morse.zeichenketteToMorse("CAT"));
    }
}
