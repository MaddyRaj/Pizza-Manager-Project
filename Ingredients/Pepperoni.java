package ingredients;

import mainClasses.Money;
/*
 * The purpose of the class was to represent the Pepperoni on the Pizza, as
 * in use the class in the Pizza class. so this class extends Meat, uses the
 * super class's constructor, and sets the default values of the Pepperoni in
 * the description, sets the value of one pepperoni order, and the calories
 * for one object or one object of the Pepperoni.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/9/19
 */
public class Pepperoni extends ingredients.Meat {
    /*
     * The purpose of the constructor was to represent Pepperoni on the Pizza
     * . This is done so by this class using the Meat superclass and using
     * the constructor in that class, but here assigning default values for
     * the name, the price and the calories instead of taking input in the
     * parameter for this class.
     *
     * @param none
     */
    public Pepperoni()
    {
        super("Pepperoni",new Money(2,20),100);
    }
}