package de.thws.lektion20.Uebung4;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SMS {
    protected Map<Character, Character> multiMap;
    public SMS(){
        multiMap = new HashMap<>();
        multiMap.put('A', '2');
        multiMap.put('B', '2');
        multiMap.put('C', '2');
        multiMap.put('D', '3');
        multiMap.put('E', '3');
        multiMap.put('F', '3');
        multiMap.put('G', '4');
        multiMap.put('H', '4');
        multiMap.put('I', '4');
        multiMap.put('J', '5');
        multiMap.put('K', '5');
        multiMap.put('L', '5');
        multiMap.put('M', '6');
        multiMap.put('N', '6');
        multiMap.put('O', '6');
        multiMap.put('P', '7');
        multiMap.put('Q', '7');
        multiMap.put('R', '7');
        multiMap.put('S', '7');
        multiMap.put('T', '8');
        multiMap.put('U', '8');
        multiMap.put('V', '8');
        multiMap.put('W', '9');
        multiMap.put('X', '9');
        multiMap.put('Y', '9');
        multiMap.put('Z', '9');
    }
    public char uebersetzer(char c) throws IllegalTelephoneNumberException{
        char temp = multiMap.getOrDefault(Character.toUpperCase(c), '1');
        if(temp == '1'){
            throw new IllegalTelephoneNumberException("Ungültige Ziffere: ");
        }
        else{
            return multiMap.get(Character.toUpperCase(c));
        }
    }

    public void leserUndSchreiber() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("characters.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("numbers.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int i = 0;
                while (i < line.length()) {
                    try{
                            char character = uebersetzer(line.charAt(i));
                            bufferedWriter.write((byte) character);
                    } catch (IllegalTelephoneNumberException e){
                        System.out.println("Ungültige Ziffer: '" + line.charAt(i) + "'");
                    } finally{
                        i++;
                    }
                }
            }
        }
    }
    class IllegalTelephoneNumberException extends Exception {
        public IllegalTelephoneNumberException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws IOException, IllegalTelephoneNumberException {
        SMS sms = new SMS();
        String line;
        try (FileWriter writer = new FileWriter("characters.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            String characters = "123a\nãbcdef123ghi";
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

