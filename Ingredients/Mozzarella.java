package ingredients;

import mainClasses.Money;
/*
 * The purpose of the Mozzarella class was to use the class's object to
 * represent Mozzarella on the Pizza, or use it in the Pizza class. The class
 * extends to the Cheese class and uses the constructor of the Cheese class,
 * in order to avoid making another duplicate constructor here unnecessarily.
 * This class assigns particular values for the description, the cost and the
 * calories instead of taking the parameter values, since the class
 * represents the particular type of cheese.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/9/19
 */
public class Mozzarella extends Cheese {
    /*
     * The purpose of the constructor was to give particular values of the
     * specific type of Cheese, through the superclass constructor, instead
     * of making another unnecessary constructor here.
     *
     * @param none
     */
    public Mozzarella()
    {
        super("Mozzarella",new Money(2,10),220);
    }

}
