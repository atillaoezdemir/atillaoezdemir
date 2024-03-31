package de.thws.lektion22.Aufgabe1;
public class Anonym {
        public static void main(String[] args) {
            Thread yangThread = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        System.out.println("Yang");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            Thread yinThread = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        System.out.println("Yin");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            yangThread.start();
            yinThread.start();
        }
}
