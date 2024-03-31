package de.thws.lektion18;
import java.net.*;
import java.io.*;

public class Ue3Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8000);
            System.out.println("Server is running and waiting for connections...");

            do {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Received from client: " + line);
                    out.println("OK");
                }

                System.out.println("Client disconnected: " + socket.getInetAddress());
                socket.close();
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
