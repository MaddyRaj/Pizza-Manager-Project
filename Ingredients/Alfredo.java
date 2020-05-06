package ingredients;

import mainClasses.Money;
/*
 * The purpose of the Alfredo class was to represent the Alfredo sauce. This
 * is done so by the class extending the Base class, and using the
 * constructor of the superclass to assign default values, since this class
 * represents a specific sauce. The description, cost and calories are set to
 * default in the superclass constructor, and to avoid making another
 * constructor that will be the same as the superclass constructor.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/9/19
 */
public class Alfredo extends ingredients.Base {
    /*
     * The purpose of the constructor was to assign values to the Base
     * constructor and represent this class as the Alfredo sauce. The
     * description is the name Alfredo and the price will be a default $2.20,
     * and the calories are 120, since the sauce is caloric heavy.
     *
     * @param none
     */
    public Alfredo()
    {
        super("Alfredo",new Money(2,20),120);
    }
}