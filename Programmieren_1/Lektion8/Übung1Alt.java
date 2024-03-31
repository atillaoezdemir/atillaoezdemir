package Lektion8;

import java.util.Scanner;

public class Übung1Alt {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
	    	String sentence = input.nextLine();
	   	String buch ;
	   	int erfolg = 0;
	    	char[] chars = sentence.toCharArray();
	    	char[] empty = sentence.toCharArray();
	      
	    	for(int i = 0; i < chars.length; i++) {
	    		empty[i]='_';
	    		System.out.println("_");
	    	}
		
	    	int j = 0;
	    	
		while ((erfolg<chars.length) && (j<=15)) {
	    		buch =input.nextLine();
	    	
		for (int i = 0; i<chars.length; i++) {
	    		char c = buch.charAt(0);
	    		if (c == chars[i]) {
	    			empty [i]=chars[i];
	    			erfolg = erfolg+1;
	    		}
	    	}
			
	    	System.out.print((j+1)+". Versuche: ");
	    	System.out.println(empty);
	    	j++;
	    	}
		
	    	input.close();
	}
}
