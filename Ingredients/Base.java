package ingredients;

import mainClasses.Money;
/*
 * The purpose of the Base class was to take a particular description, cost
 * and calories for the particular base on the Pizza, and call the super, or
 * the Ingredient class constructor, to save all the of the values above
 * instead of making another constructor here where its not necessary. This
 * is done so by first making a constructor in the Base class with
 * description, cost and calories in the parameters, and then these values
 * are passed into the super constructor as parameters in the Ingredient
 * class constructor. Since the Base class extends to the Ingredient class,
 * the super constructor can be used to save all the values in the constructor.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/3/19
 */
public class Base extends Ingredient{
    /*
     * The purpose of the constructor below was to take the description, cost
     * and calories for the particular Base object and pass them through the
     * super constructor or the constructor of the Ingredient class, and
     * save all of these values in the Ingredient constructor, since the Base
     * class extends the Ingredient class.
     *
     * @param String description, Money cost, int calories
     */
    public Base(String description, Money cost, int calories)
    {
        super(description,cost,calories);
    }
}