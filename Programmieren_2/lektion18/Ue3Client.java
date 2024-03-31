package de.thws.lektion18;

import java.net.*;
import java.io.*;
public class Ue3Client {
    public static void main(String[] args)
    {
        try {
            Socket socket = new Socket("localhost", 8000);

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String line;
            while ((line = in.readLine()) != null) {
                out.println(line);
                String response = in.readLine();
                System.out.println("Received from server: " + response);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
