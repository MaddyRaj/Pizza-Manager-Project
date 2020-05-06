package ingredients;

import mainClasses.Money;
/*
 * The purpose of the Sausage class was to represent a Sausage on the Pizza.
 * This class's object used in the Pizza class will represent the Sausage.
 * The class extends the Meat class, and uses the constructor of the super
 * class to set values for this particular type of Meat.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/9/19
 */
public class Sausage extends ingredients.Meat {
    /*
     * The purpose of the Sausage class was to use the constructor of the
     * Meat class and set particular values for the Sausage, get particular
     * cost for the Sausage object, and the calories for the Sausage type of
     * Meat.
     *
     * @param none
     */
    public Sausage()
    {
        super("Sausage",new Money(2,20),200);
    }
}
