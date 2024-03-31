package de.thws.lektion22.Aufgabe1;
public class Implement implements Runnable {
    private String message;
    public Implement(String message) {
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
        Thread yangThread = new Thread("Yang");
        Thread yinThread = new Thread("Yin");

        yangThread.start();
        yinThread.start();
    }
}
