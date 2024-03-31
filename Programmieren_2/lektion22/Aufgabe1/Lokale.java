package de.thws.lektion22.Aufgabe1;
public class Lokale {
    public class Main {
        public static void main(String[] args) {
            class YinYangRunnable extends Thread {
                private String message;
                public YinYangRunnable(String message) {
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
            }
            Thread yangThread = new Thread(new YinYangRunnable("Yang"));
            Thread yinThread = new Thread(new YinYangRunnable("Yin"));
            yangThread.start();
            yinThread.start();
        }
    }
}
