package de.thws.lektion18;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BeispielClient {
    public static void main(String[] args)
    {
        final int PORT = 5000;
        final String HOST = "localhost";
        try (Socket s = new Socket(HOST, PORT);
             OutputStream os = s.getOutputStream();)
        {
            os.write("Suppe mit dem Löffel löffeln\n".getBytes()); //Charset.defaultCharset()
            os.write("Suppe mit dem Löffel löffeln\n".getBytes(StandardCharsets.ISO_8859_1));
            os.write("Suppe mit dem Löffel löffeln\n".getBytes(StandardCharsets.UTF_16));
            os.write("Suppe mit dem Löffel löffeln\n".getBytes(StandardCharsets.UTF_8));
            os.write("Suppe mit dem Löffel löffeln\n".getBytes(StandardCharsets.US_ASCII));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
