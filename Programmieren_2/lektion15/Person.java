package de.thws.lektion15;

public abstract class Person {
    protected String fach;
    public Person(String fach){
        this.fach = fach;
    }
    abstract void gibTaetigkeitAus();
}
