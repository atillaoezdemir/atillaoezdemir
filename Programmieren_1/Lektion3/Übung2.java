package Lektion3;
import java.util.Scanner;
public class Übung2 {
public static void main(String[] args) {
	
	float PI = 3.14f;
	Scanner scanner = new Scanner(System.in);
	System.out.print("1. pizza price: ");
	float Pizza1p = scanner.nextFloat();
	System.out.print("1. pizza ratio: ");
	float Pizza1r = scanner.nextFloat();
	
	System.out.print("2. pizza price: ");
	float Pizza2p = scanner.nextFloat();
	System.out.print("2. pizza ratio: ");
	float Pizza2r = scanner.nextFloat();
	
	float Erste = ((PI * ((float)Math.sqrt(Pizza1r / 2f)) / Pizza1p));
	float Zweite = ((PI * ((float)Math.sqrt(Pizza2r / 2f)) / Pizza2p));
	
	if (Erste < Zweite) System.out.println("Zweite ist sinnvoll!");
	else if (Erste == Zweite) System.out.println("Beide sind gleich!");
	else System.out.println("Erste ist sinnvoll!");
	
	
	System.out.println(Math.sqrt(4));
	scanner.close();
}
}
