package de.thws.lektion14;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StreckeTest {
    @Test
    public void variablenTest(){
        try {
            new Strecke(4,1);
            fail("Runtime Exception erwartet!");
        }catch (RuntimeException e){
            String errorMessage = e.getMessage();
            assertEquals("anfangspunkt kann nicht größer als endpunkt sein!", errorMessage);
        }
    }
    @Test
    public void negativeVariablenTest(){
        try{
            new Strecke(-1,-5);
        }catch(RuntimeException e){
            String errorMessagge = e.getMessage();
            assertEquals("Weder anfangspunkt noch endpunkt können negativ sein!", errorMessagge);
        }
    }
    @Test
    public void ueberschneidungTest(){
        new Strecke(2,8);
        Strecke neu = new Strecke(5,40);
        assertTrue(neu.ueberschneidung(neu));
    }
    @Test
    public void stringMethodeTest(){
        Strecke neu = new Strecke(1,6);
        assertEquals("1----6",neu.streckeToString());
    }
}
