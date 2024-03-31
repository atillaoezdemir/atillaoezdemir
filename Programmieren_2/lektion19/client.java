package de.thws.lektion19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main(String[] args){
        System.out.println("Client started.");
        try {
            Socket socket = new Socket("localhost" , 9806);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a String: ");
            String str = bufferedReader.readLine();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(str);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
