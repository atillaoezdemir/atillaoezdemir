package de.thws.klausurAufgaben;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class selfStudy {
    public static void main(String[] args) {
        List<Double> articlePrices = Arrays.asList(10.0, 20.0, 30.0);
        articlePrices.forEach(price -> System.out.println(price * 0.7));

        Thread ying = new Thread(new Runnable() {
            public void run() {

            }
        });

        // TreeSet<String> customOrderSet = new TreeSet<>(new CustomComparator());

        articlePrices.forEach(price -> System.out.println(price * 0.7));

        Consumer<String> printOut = name -> System.out.println(name);
        printOut.accept("Würzburg");

        // Obje okurken bu şekilde kullanılır:
        // List<Object> nesneler = (List<Object>) objectInputStream.readObject();

        /*
        bundesligaTabelle.stream()
                .map(Mannschaft::getName)            // Alternatifler: .map(String::toUpperCase)
                .filter(name -> name.startsWith("F")).map(x -> x * x)
                .sorted(new VergleichKriterien())
                .forEach(System.out::println);
    */
    }
}



