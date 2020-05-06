package ingredients;

import mainClasses.Money;
/*
 * The purpose of the Marinara class was to be able to represent the Marinara
 * sauce as a Base. This is done so by Marinara extending to the Base class,
 * and using the super class's constructor, but this time assigning default
 * values like the description, the price of the sauce, and the calories. The
 * class just uses the super class's constructor in order to avoid having to
 * make another constructor in this class, which will be the exact same as
 * the constructor in the Base class.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/9/19
 */
public class Marinara extends ingredients.Base {
    /*
     * The purpose of the constructor was to assign default values and
     * allow the class to represent the Marinara sauce, instead of just the
     * Base. This constructor will represent the Marinara sauce on the Pizza,
     * as in can be used to represent Marinara sauce in the Pizza Object.
     *
     * @param none
     */
    public Marinara()
    {
        super("Marinara",new Money(2,0),70);
    }
}