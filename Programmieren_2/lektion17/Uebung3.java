package de.thws.lektion17;
import java.io.*;
import java.util.Scanner;

public class Uebung3 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the path of the music file to copy: ");
            String filePath = scanner.nextLine();

            // Unbuffered stream - byte by byte
            FileInputStream fis = new FileInputStream(filePath);
            FileOutputStream fos1 = new FileOutputStream("unbuffered_copy.mp3");
            long startTime1 = System.currentTimeMillis();
            int b;
            while ((b = fis.read()) != -1) {
                fos1.write(b);
            }
            long endTime1 = System.currentTimeMillis();
            long duration1 = endTime1 - startTime1;
            System.out.println("Time taken for unbuffered byte stream copy: " + duration1 + " milliseconds");
            fis.close();
            fos1.close();

            // Buffered stream - byte by byte
            FileInputStream fis2 = new FileInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(fis2);
            FileOutputStream fos2 = new FileOutputStream("buffered_copy.mp3");
            BufferedOutputStream bos = new BufferedOutputStream(fos2);
            long startTime2 = System.currentTimeMillis();
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
            long endTime2 = System.currentTimeMillis();
            long duration2 = endTime2 - startTime2;
            System.out.println("Time taken for buffered byte stream copy: " + duration2 + " milliseconds");
            bis.close();
            bos.close();

            // Unbuffered stream - byte array of size 1024
            FileInputStream fis3 = new FileInputStream(filePath);
            FileOutputStream fos3 = new FileOutputStream("unbuffered_1024_copy.mp3");
            long startTime3 = System.currentTimeMillis();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis3.read(buffer)) != -1) {
                fos3.write(buffer, 0, length);
            }
            long endTime3 = System.currentTimeMillis();
            long duration3 = endTime3 - startTime3;
            System.out.println("Time taken for unbuffered 1024 byte array copy: " + duration3 + " milliseconds");
            fis3.close();
            fos3.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
}
