package ingredients;

import mainClasses.Money;
import java.awt.Color;
/*
 * The purpose of the Pepper class was to have an Object which is supposed to
 * represent a type of vegetable, which in this case would be a pepper.
 * There is only 1 constructor in the class, which will use the Vegetable
 * constructor to save all the values that will be set for a Pepper class,
 * which will be a default name, price, and the color. All of these things
 * are default and since all of the values have been used in the constructor
 * in Vegetable, we use all the values through the constructor of the
 * superclass in order to avoid making another constructor in this class.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/9/19
 */
public class Pepper extends ingredients.Vegetable {

    /*
     * The purpose of the constructor was to use default values for this
     * Pepper class, which represents a pepper vegetable, so the description,
     * the cost and the color were set default and were set through the
     * constructor of the Vegetable class, which avoided the need to make
     * another constructor which will be a replication of the Vegetable
     * class, so the Vegetable class's, or the superclass constructor, in
     * order to set the values.
     *
     * @param none
     */
    public Pepper()
    {
        super("Pepper",new Money(2,50),30, Color.orange);
    }

}
