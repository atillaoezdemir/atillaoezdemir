package de.thws.lektion15;

public class Professor extends Person{
    public Professor(String fach) {
       super(fach);
    }
    public void gibTaetigkeitAus() {
        System.out.println("Der Professor unterrichtet " + fach + ".");
    }
}
