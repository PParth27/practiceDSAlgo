package com.pranav.decoratorPattern.starBuzz;

/**
 * Created by pparth on 8/6/17.
 */
public class Mocha implements Beverage {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public Double cost() {
        return beverage.cost() + 5.0;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
