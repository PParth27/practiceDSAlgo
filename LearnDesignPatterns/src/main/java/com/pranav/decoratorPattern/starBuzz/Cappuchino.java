package com.pranav.decoratorPattern.starBuzz;

/**
 * Created by pparth on 8/6/17.
 */
public class Cappuchino implements Beverage {
    Beverage beverage;

    public Cappuchino(Beverage beverage) {
        this.beverage = beverage;
    }

    public Double cost() {
        return (beverage != null) ? beverage.cost() + 10.0 : 10.0;
    }

    public String getDescription() {
        return (beverage != null) ? beverage.getDescription() + ", Cappuchino" : "Cappuchino";
    }
}
