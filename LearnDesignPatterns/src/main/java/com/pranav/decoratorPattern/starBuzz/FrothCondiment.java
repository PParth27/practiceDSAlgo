package com.pranav.decoratorPattern.starBuzz;

/**
 * Created by pparth on 8/6/17.
 */
public class FrothCondiment implements Beverage {
    Beverage beverage;

    public FrothCondiment(Beverage beverage) {
        this.beverage = beverage;
    }

    public Double cost() {
        return beverage.cost() + 7.0;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Froth";
    }
}
