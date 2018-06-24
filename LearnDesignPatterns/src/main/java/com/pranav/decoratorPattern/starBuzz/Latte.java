package com.pranav.decoratorPattern.starBuzz;

/**
 * Created by pparth on 8/6/17.
 */
public class Latte implements Beverage {
    Beverage beverage;
    public Latte(Beverage beverage) {
        this.beverage = beverage;
    }
    public Double cost() {
        return (beverage != null) ? beverage.cost() + 9.00 : 9.00;
    }

    public String getDescription() {
        return (beverage != null) ? beverage.getDescription() + ", latte" : "latte";
    }
}
