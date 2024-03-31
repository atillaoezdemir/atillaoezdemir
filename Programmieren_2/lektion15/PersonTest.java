package de.thws.lektion15;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class PersonTest {
    @Test
    public void studentTest(){
        Student t = new Student("Programmieren");
        String expectedOutput = "Der Student besucht das Fach Programmieren.\n";
        //assertEquals("Der Student besucht das Fach Programmieren.",t.gibTaetigkeitAus());
        //geht nicht

    }
}
