package de.thws.lektion14;

public class KugelVolumen {
    
    public static double berechneKugelvolumen(double radius) {
       if (radius < 0)
            throw new RuntimeException("Radius muss positiv sein!");

        return  Math.PI * radius * radius * radius * 4.0 / 3.0 ;
    }
}
