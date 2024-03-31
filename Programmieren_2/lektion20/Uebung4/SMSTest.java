package de.thws.lektion20.Uebung4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SMSTest {
    private SMS sms;
    String line;
    @BeforeEach
    public void beforeEach(){
        File file = new File("characters.txt");
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File("numbers.txt");
        if (file2.exists()) {
            file2.delete();
        }
        line = null;
        sms = new SMS();
    }
    @Test
    public void testDefaultMode(){
        assertEquals('2', sms.multiMap.get('A'));
        assertEquals('8', sms.multiMap.get('T'));
    }

    @Test
    public void testUebersetzer() throws SMS.IllegalTelephoneNumberException {
        assertEquals('2', sms.uebersetzer('a'));
        assertEquals('8', sms.uebersetzer('T'));
    }

    @Test
    public void testLeserUndSchreiber() throws IOException {
        try (FileWriter writer = new FileWriter("characters.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            String characters = "abcdefghi";
            bufferedWriter.write(characters);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sms.leserUndSchreiber();
        try (FileReader reader = new FileReader("numbers.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)){
            while ((line = bufferedReader.readLine()) != null) {
                assertEquals("222333444", line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLeserUndSchreiberFalsch() throws IOException {
        try (FileWriter writer = new FileWriter("characters.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            String characters = "abcdef123ghi";
            bufferedWriter.write(characters);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sms.leserUndSchreiber();
        try (FileReader reader = new FileReader("numbers.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)){
            while ((line = bufferedReader.readLine()) != null) {
                assertEquals("222333444", line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
