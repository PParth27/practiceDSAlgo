package com.pranav.decoratorPattern.starBuzz;

/**
 * Created by pparth on 8/6/17.
 */
public class RunAll {

    public static void main(String args[]) {
        /**
         * Create an order of single cappuchino with mocha and froth
         */
        Beverage firstCappuchino = new Cappuchino(null);
        Beverage secondCappuchino = new Cappuchino(firstCappuchino);
        Beverage mocha = new Mocha(secondCappuchino);
        Beverage finalOrder = new FrothCondiment(mocha);

        System.out.println(finalOrder.getDescription() + " : " + finalOrder.cost());
    }
}
