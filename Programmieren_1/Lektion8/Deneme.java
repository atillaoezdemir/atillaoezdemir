package Lektion8;
import Lektion9.Übung1Auto;
public class Deneme {
	public static void Main(String[] args) {
		System.out.println("1");
		Übung1Auto Auto1 = new Übung1Auto("Mercedes" , "Schwarz" , 1000);
		Übung1Auto Auto2 = new Übung1Auto("BMW" , "Rot" , 2000);
		Übung1Auto Auto3 = new Übung1Auto("Porsche" , "Weiß" , 3000);
		Übung1Auto Auto4 = new Übung1Auto("Kein" , "Kein" , -1);
		
		System.out.println(Auto1.getMarke() + " " +  Auto1.getFarbe() + Auto1.getHubraum());
		System.out.println(Auto2.getMarke() + Auto2.getFarbe() + Auto2.getHubraum());
		System.out.println(Auto3.getMarke() + Auto3.getFarbe() + Auto3.getHubraum());
		System.out.println(Auto4.getMarke() + Auto4.getFarbe() + Auto4.getHubraum());
		System.out.println("1");
	}
}
