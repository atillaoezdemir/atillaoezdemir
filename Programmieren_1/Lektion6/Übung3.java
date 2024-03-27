package Lektion6;

public class Übung3 {
	public static void main(String[] args) {
		int satir = 5;
		
		for(int i = satir ; i > 0 ; i--) {
			for(int l = i - 1; l > 0 ; l--) {
				System.out.print(" ");
			}
			for(int j = satir - i + 1 ; j > 0 ; j--) {
				System.out.print("* ");
			}
			System.out.println("");
		}
		
	}
}
