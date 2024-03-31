package de.thws.lektion15;

public class Student extends Person{
    public Student(String fach) {
        super(fach);
    }
    public void gibTaetigkeitAus() {
        System.out.println("Der Student besucht das Fach " + fach + ".");
    }
}
