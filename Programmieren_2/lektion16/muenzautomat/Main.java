package de.thws.lektion16.muenzautomat;

public class Main {
    public static void main(String[] args){
        int[] a = AdvancedChangeCalculator.getChange(3, 88);
        for (int j : a) System.out.println(j);

    }
}
