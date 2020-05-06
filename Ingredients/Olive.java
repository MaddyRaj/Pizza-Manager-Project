package ingredients;

import mainClasses.Money;

import java.awt.Color;

/*
 * The purpose of the Olive class was to be able to create an object that
 * represents an olive. Since the class extends Vegetable, it will have a set
 * amount for the price of the Olive object, a definite Black color, and the
 * description will be the name, which is Olive. Since the super class is
 * Vegetable, that class has a constructor which takes a description, cost
 * and calories, so this class will call the super constructor and provide
 * all of those 3 parameters will actual values this time. This time the
 * difference will be that there will be no parameters in the olive
 * constructor, and the values will be default chosen instead of having
 * values be given through the constructor in the Olive class.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/9/19
 */
public class Olive extends ingredients.Vegetable {
    /*
     * The purpose of the Olive constructor was to set values in the super
     * class constructor, or the Vegetable class constructor.
     *
     * @param none
     */
    public Olive()
    {
        super("Olive",new Money(2,50),100, Color.black);
    }
}