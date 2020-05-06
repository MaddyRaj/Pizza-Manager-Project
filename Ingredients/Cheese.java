package ingredients;

import mainClasses.Money;

/*
 * The purpose of the Cheese class was to take in a description of the
 * cheese, the cost of it, using the Money object, and the amount of calories
 * for the particular description. The class does the above by calling to
 * the super class's, meaning the Ingredient class which it inherits from. The
 * constructor in the Cheese class calls the constructor in the super class,
 * or the Ingredient class, with the same parameters taken in the Cheese
 * constructor.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/3/19
 */
public class Cheese extends Ingredient {
    /*
     * The purpose of the Cheese constructor was to take the description of
     * the cheese, the cost of the cheese and the number of calories in the
     * particular cheese description provided. This constructor will be used
     * to add Cheese to the Pizza object.
     *
     * @param String description, Money cost, int calories
     */
    public Cheese(String description, Money cost, int calories)
    {
        super(description,cost,calories);
    }
}
