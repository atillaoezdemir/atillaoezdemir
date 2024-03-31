package de.thws.lektion18;

import java.io.*;

public class Uebung1 {
    static void splitStudiengaenge(String dateiname) throws IOException, MatrikelNummerException{
        try(BufferedReader br = new BufferedReader(new FileReader(dateiname));
            BufferedWriter winf = new BufferedWriter(new FileWriter("WInf.txt"));
            BufferedWriter inf = new BufferedWriter(new FileWriter("Inf.txt"));
            BufferedWriter ec = new BufferedWriter(new FileWriter("EC.txt")))
        {
            do
            {
                String line = br.readLine();
                if (line == null || line.isEmpty()) break;
                if(Integer.parseInt(line) >= 5000000 && Integer.parseInt(line) <= 5099999){
                    winf.write(line);
                    winf.newLine();
                }
                else if(Integer.parseInt(line) >= 5100000 && Integer.parseInt(line) <= 5199999){
                    inf.write(line);
                    inf.newLine();

                }
                else if(Integer.parseInt(line) >= 6100000 && Integer.parseInt(line) <= 6199999){
                    ec.write(line);
                    ec.newLine();
                }
                else {
                    throw new MatrikelNummerException("Ungültige Matrikelnummer: " + line);
                }
            }
            while(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try {
            splitStudiengaenge("C:\\Users\\Ati\\IdeaProjects\\programmieren2\\nums.txt");
        } catch (IOException | MatrikelNummerException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

