package de.thws.lektion15;

public class PersonMain {
    public static void main(String[] args) {
        Person[] personen = new Person[100];
        String fach = "Programmieren";

        for (int i = 0; i < personen.length; i++) {
            if (i % 2 == 0) {
                personen[i] = new Student(fach);
            } else {
                personen[i] = new Professor(fach);
            }
        }

        for (Person person : personen) {
            person.gibTaetigkeitAus();
        }
    }
}
