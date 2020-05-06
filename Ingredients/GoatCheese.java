package ingredients;

import mainClasses.Money;
/*
 * The purpose of the GoatCheese class was to use the constructor of the superclass
 * Cheese, and assign the particular value of the GoatCheese cheese, instead of
 * taking the values through the parameter for the GoatCheese class, since we don't
 * need values from the user for this class, since the values are the same
 * since the GoatCheese is a specific type of cheese.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/9/19
 */
public class GoatCheese extends Cheese{
    /*
     * The constructor uses the super class's constructor to set specific
     * values for the GoatCheese cheese, instead of using a constructor in this
     * class, since the constructor will be identical to the constructor in
     * the super class. The description will be the GoatCheese cheese, the cost
     * will be the set cost for adding 1 GoatCheese cheese object, and the calories
     * will be set calories for 1 GoatCheese cheese object.
     *
     * @param none
     */
    public GoatCheese()
    {
        super("Goat Cheese", new Money(2,0),200);
    }
}