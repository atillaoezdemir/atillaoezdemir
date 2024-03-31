package de.thws.lektion22.Aufgabe1;

public class Extend extends Thread {
    private String message;

    public Extend(String message) {
        this.message = message;
    }

    public void run() {
        while (true) {
            System.out.println(message);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Extend yangThread = new Extend("Yang");
        Extend yinThread = new Extend("Yin");

        yangThread.start();
        yinThread.start();
    }
}

