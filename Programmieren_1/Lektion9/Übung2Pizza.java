package Lektion9;

import java.util.ArrayList;

public class Übung2Pizza {
  
    private final String name;
    private final ArrayList<DiameterPrice> diameterPrices;

    public Pizza(String name) {
        this.name = name;
        this.diameterPrices = new ArrayList<>();
    }

    public static void main(String[] args) {
      
        Pizza pizza1 = new Pizza("Pizza Margherita");
        pizza1.addDiameterPrice(30, 10);
        pizza1.addDiameterPrice(40, 12);
        pizza1.addDiameterPrice(50, 15);

        Pizza pizza2 = new Pizza("Pizza Salami");
        pizza2.addDiameterPrice(30, 12);
        pizza2.addDiameterPrice(40, 15);
        pizza2.addDiameterPrice(50, 18);

        Pizza pizza3 = new Pizza("Nonpizza Hawaii(");
        pizza3.addDiameterPrice(30, 11);
        pizza3.addDiameterPrice(40, 14);
        pizza3.addDiameterPrice(50, 17);

        Pizza pizza4 = new Pizza("Pizza Vegetariana");
        pizza4.addDiameterPrice(30, 13);
        pizza4.addDiameterPrice(40, 16);
        pizza4.addDiameterPrice(50, 19);

        Pizza pizza5 = new Pizza("Pizza Quattro Stagioni");
        pizza5.addDiameterPrice(30, 14);
        pizza5.addDiameterPrice(40, 17);
        pizza5.addDiameterPrice(50, 20);

        Pizza[] pizzas = {pizza1, pizza2, pizza3, pizza4, pizza5};
        Pizza bestValuePizza = null;
        double bestValue = Double.MAX_VALUE;

        for (Pizza pizza : pizzas) {
            DiameterPrice bestCombination = pizza.getBestValue();
            double value = bestCombination.getPrice() / bestCombination.getDiameter();
            if (value < bestValue) {
                bestValue = value;
                bestValuePizza = pizza;
            }
        }

        System.out.println("Die Pizza mit dem besten Preisleistungsverhältnis ist: " + bestValuePizza.getName());
        System.out.println("Durchmesser: " + bestValuePizza.getBestValue().getDiameter() + " cm, Preis: " + bestValuePizza.getBestValue().getPrice() + " €");
    }

    public void addDiameterPrice(double diameter, double price) {
        diameterPrices.add(new DiameterPrice(diameter, price));
    }

    public DiameterPrice getBestValue() {
        double bestValue = Double.MAX_VALUE;
        DiameterPrice bestCombination = null;

        for (DiameterPrice dp : diameterPrices) {
            double value = dp.getPrice() / dp.getDiameter();
            if (value < bestValue) {
                bestValue = value;
                bestCombination = dp;
            }
        }
        return bestCombination;
    }

    public String getName() {
        return name;
    }
}

class DiameterPrice {
    private final double diameter;
    private final double price;

    public DiameterPrice(double diameter, double price) {
        this.diameter = diameter;
        this.price = price;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getPrice() {
        return price;
    }
}





}
