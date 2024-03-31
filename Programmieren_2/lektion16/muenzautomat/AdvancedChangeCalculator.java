package de.thws.lektion16.muenzautomat;

public class AdvancedChangeCalculator {
    public static int[] getChange(int euros, int cent)
    {
        int totalCent = euros * 100 + cent;
        int[] result = new int[8];
        result[7] = totalCent / 200;
        result[6] = (totalCent - (result[7] * 200)) / 100;
        result[5] = (totalCent - (result[7] * 200) - (result[6] * 100)) / 50;
        result[4] = (totalCent - (result[7] * 200) - (result[6] * 100) - (result[5] * 50)) / 20;
        result[3] = (totalCent - (result[7] * 200) - (result[6] * 100) - (result[5] * 50) - (result[4] * 20)) / 10;
        result[2] = (totalCent - (result[7] * 200) - (result[6] * 100) - (result[5] * 50) - (result[4] * 20) - (result[3] * 10)) / 5;
        result[1] = (totalCent - (result[7] * 200) - (result[6] * 100) - (result[5] * 50) - (result[4] * 20) - (result[3] * 10) - (result[2] * 5)) / 2;
        result[0] = (totalCent - (result[7] * 200) - (result[6] * 100) - (result[5] * 50) - (result[4] * 20) - (result[3] * 10) - (result[2] * 5) - (result[1] * 2));
        return result;
    }
}
