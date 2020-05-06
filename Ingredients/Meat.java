package ingredients;

import mainClasses.Money;
/*
 * The purpose of the meat class was to save the particular description,
 * cost, and the calories for the Meat object. Since the class inherits from
 * the Ingredient class, in the constructor created for the Meat class, all
 * the parameters are just passed into the super class's constructor, which
 * is the constructor for the Ingredient class, the super called below. All
 * the parameters are passed in so the class can be used as the Meat for any
 * objects, like for the Pizza.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/3/19
 */
public class Meat extends Ingredient {
    /*
     * The purpose of the constructor was to get the description, cost, and
     * calories for the particular Meat object. Since the class extends to
     * the Ingredient class, the super class's constructor is called, passing
     * in all the values we just received through the parameters, so we
     * don't unnecessarily make more instance variables here where its not
     * required.
     *
     * @param String description, Money cost, int calories
     */
    public Meat(String description, Money cost, int calories)
    {
        super(description,cost,calories);
    }
}
