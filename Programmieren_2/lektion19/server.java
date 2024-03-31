package de.thws.lektion19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args){
        try{
            System.out.println("Waiting for clients...");
            ServerSocket serverSocket = new ServerSocket(9806);
            Socket socket = serverSocket.accept();
            System.out.println("Connection established.");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = in.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Server says: " + str);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
