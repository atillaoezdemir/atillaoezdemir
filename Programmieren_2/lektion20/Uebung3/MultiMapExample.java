package de.thws.lektion20.Uebung3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MultiMapExample {
    private Map<String, List<String>> multiMap;
    public MultiMapExample() {
        multiMap = new HashMap<>();
    }
    public void put(String key, String value) {
        List<String> values;
        if (multiMap.containsKey(key)) {
            values = multiMap.get(key);
            values.add(value);
        } else {
            values = new ArrayList<>();
            values.add(value);
        }
            multiMap.put(key, values);
    }
    public void putAll(String key, List<String> values) {
        if (multiMap.containsKey(key)) {
            List<String> existingValues = multiMap.get(key);
            existingValues.addAll(values);
        } else {
            multiMap.put(key, values);
        }
    }
    public List<String> get(String key) {
        return multiMap.get(key);
    }
    public static void main(String[] args) {
        MultiMapExample multiMapExample = new MultiMapExample();
        List<String> bedeutungen = new ArrayList<>();
        bedeutungen.add("reinigen");
        bedeutungen.add("temizlemek");
        multiMapExample.putAll("to clean", bedeutungen);

        multiMapExample.put("to expand", "vergrößern");
        multiMapExample.put("to expand", "wachsen");

        List<String> cleanTranslations = multiMapExample.get("to clean");
        System.out.println("Translations of 'to clean': " + cleanTranslations);

        List<String> expandTranslations = multiMapExample.get("to expand");
        System.out.println("Translations of 'to expand': " + expandTranslations);
    }
}