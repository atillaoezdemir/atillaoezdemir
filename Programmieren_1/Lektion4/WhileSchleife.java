package Lektion4;
import java.util.Scanner;
public class WhileSchleife {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Geben Sie ein Zahl ein: ");
		int Zahl = scanner.nextInt();
		int toplam = 0;
		
		while (Zahl>0) {
			toplam = toplam + Zahl % 10;
			Zahl= Zahl / 10;
		}
		System.out.println("Toplam: " + toplam);
		scanner.close();
		
	}

}
