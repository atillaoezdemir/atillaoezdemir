package Klausurübungs;

public class Aufgabe4 { //Lektion 8 String Methoden
	public static void main(String[] args) {
		String deneme= "Ich gehe morgen mit meinen 11 Freund*innen zum Essen!";
		String denemes =  "Ich gehe morgen mit meinen 11 Freund*innen zum Essen!";
		char[] denemee = new char[1];
		denemee[0] = 'I';
		char[] denemees = new char[1];
		denemees[0] = 'I';
		//System.out.println(deneme.charAt(16));
		//System.out.println(deneme.substring(4));
		//System.out.println(deneme.substring(4 , 7));					substring metodu 4. indexi dahil eder ama 7. indexi dahil etmez!
//		System.out.println(deneme.length());							//Array ve String arasında length kullanım farkı var dikkat!
//		System.out.println(denemee.length);
		//System.out.println(deneme.equals(denemes));
		//System.out.println(equals(denemee , denemees)); 				Dizilerde equals metodu kullanılamaz!
		//System.out.println(deneme.compareTo(denemes));				compareTo yapısı harf sayısı ile birlikte harflerin farklılıklarını da kaşılaştırıyor
//		char[] abc = deneme.toCharArray();								0'dan String uzunluğuna kadar olan sayılar String'i bastırmak için yeterli!
//		for(int i = 0 ; i < deneme.length() ; i++) {
//			System.out.println(abc[i]);
//		}
//		String a = "Ha llo Welt";										.replace( , ) fonksiyonu ile aynı olan bütün karakterleri bir yenisi ile değişitrebiliriz!
//		a = a.replace(" ", "?");
//		System.out.println(a);
//		System.out.println(deneme.equalsIgnoreCase(denemes));			.equalsIgnoreCase(String) ile harflerin büyüklüğüne takılmadan karşılaştırabiliriz!
//		System.out.println(deneme.indexOf("m"));
//		String example = "This is an example";							.startsWith() yapısı String'in başını kontrol etmek için kullanılır!
//		System.out.println("example starts with 'This': " + example.startsWith("This"));
	}
}
