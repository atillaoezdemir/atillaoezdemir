package Lektion6;

public class Übung1 {
	public static int powerTen(int a) {
		if (a == 1) return 10;
		else return 10 * powerTen(a - 1);
	}
	public static void main(String[] args) {
		double a = 3.6;
		int i;
		for(i = 1 ; i < 16 ; i++) {
			a = a * 10;
			if (a % 1 == 0) break;
		}
		if(a % 10 < 5) {
			a = a - (a % 10);
			a= a / powerTen(i);
		}
		else {
			a = a + (10 - (a % 10));
			a= a / powerTen(i);
		}
		System.out.println(a);
	}
}
