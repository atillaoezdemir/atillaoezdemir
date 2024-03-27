package Lektion4;
import java.util.Scanner;
public class Übung3b {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Geben Sie ein Zahl ein: ");
		int zahl = scanner.nextInt();
		int prüfer = 0;
			
		for(int divisor = zahl-1; divisor > 1 ; divisor--) {
			if(zahl % divisor == 0) prüfer++;
			int prüfer2 = 0;
			
			for(int divisorsDivisor = divisor-1; divisorsDivisor > 1 ; divisorsDivisor--) {
				if(divisor % divisorsDivisor == 0) prüfer2++;
			}
			if(prüfer2 == 0) System.out.println(divisor);
		}		
		if(prüfer == 0 && zahl >1 )System.out.println(zahl);
		scanner.close();
	}
}
