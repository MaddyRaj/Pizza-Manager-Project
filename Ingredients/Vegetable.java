package ingredients;

import mainClasses.Money;
import java.awt.Color;

/*
 * The purpose of the Vegetable class below was to use the description, the
 * cost and the calories given through the parameter to be set equal to the
 * current Vegetable class. Instead of creating another constructor that will
 * take basically the same parameters as the Ingredient class, we extend the
 * current class to the Ingredient class, and use the super class's
 * constructor to set the values of the particular Vegetable. if the
 * constructor without the color was used, then we set the default color to
 * green since we haven't been given a particular color, but we also have
 * another constructor that has a parameter for the color, so if that
 * constructor is used, then the color is also set through the parameter of
 * the constructor, but in this case, there is one instance variable made for
 * the color, since the Ingredient class doesn't assume that every
 * Ingredient wants to have a color. We use the java's Color class here to
 * allow colors to be set through the constructor.There is a toString()
 * method in this class, which prints the just redirects to the Ingredient
 * toString, which prints the description, the cost and the calories. This
 * toString also in addition to the above toString uses the Color.toString,
 * which would be the java's color class's toString method, which prints the
 * RGB composition. Finally, we also have an equals method, which first
 * checks to make sure the Object in the parameter is not null and is an
 * instance, and if so, then compares the description, the cost and the
 * calories and the color of the two objects, but here instances writing
 * multiple lines, uses the equals method of the Ingredient class to compare
 * the 3 variables apart from the color, and then separately uses the java's
 * equals method to compare the two colors, and if true is returned, then the
 * two Vegetables are equal.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/9/19
 */
public class Vegetable extends Ingredient{
    // Color variable made to keep track of the color of my Vegetable. Uses
    // the java's built-in java class instead of using our class, since we
    // need to set the Vegetable to actual colors instead of just temporary
    // variable assignment, if we use our Color class. The variable is made
    // final, since we won't be using setters for it in the class, and will
    // only be assigning it in the constructor(s).
    private final Color myColor;

    /*
     * Just made a main to test my equals, toString methods and making sure
     * that my class' constructor is saving the values properly.
     */
    public static void main(String[] args)
    {
        Vegetable v = new Vegetable("Cabbage",new Money(2,99),200, Color.green);
        Vegetable v2 = new Vegetable("Lettuce",new Money(2,99),200,Color.green);
        System.out.println(v2.equals(v));
        System.out.println(v2.toString());
    }

    /*
     * The purpose of the constructor below was to use the values given to us
     * through the parameter, which are the description, the cost and the
     * calories, which are used to represent the above as the properties of a
     * Vegetable. the constructor does not have 3 instance variables for the
     * parameter, since we can just use the superclass or the Ingredient's
     * constructor because the features are common for both. So, the 3
     * variables are passed through the super class constructor and since
     * the constructor doesn't have color in the parameter, then the
     * default color is set to green, assuming the vegetable will be some
     * color as green.
     *
     * @param String descrip, Money cost, int calories
     */
    public Vegetable(String descrip, Money cost, int calories)
    {
        super(descrip,cost,calories);
        this.myColor = Color.green;
    }

    /*
     * The difference between this constructor and the constructor above is
     * that this one has the option of the color for the vegetable, which is
     * set the color variable in the class, since both will be java's built
     * in Color variables, there is no privacy leak from our side. Again, the
     * super class's constructor is used to set the values of the first 3
     * parameters and then the color is set separately as the instance
     * variable in this class.
     *
     * @param String descrip, Money cost, int calories, Color otherColor
     */
    public Vegetable(String descrip, Money cost, int calories,
                     Color otherColor)
    {
        super(descrip,cost,calories);
        this.myColor = otherColor;
    }

    /*
     * The purpose of the getter was to return the Color in this class, which
      * was java's built-in Color class, instead of using our Color class
      * built. This is not a privacy leak since its the java's Color class,
      * not the one we built.
      *
      * @param none
     */
    public Color getMyColor() {
        return myColor;
    }

    /*
     * the purpose of the toString method here was to return the description,
     * the cost, the calories and the color of the current Vegetable object.
     * The description, cost and calories were returned in the toString in the
     * Ingredient object, the class that the Vegetable class inherits from,
     * so super.toString() is called, which essentially calls the toString
     * method in the Ingredient class, printed the above 3 things. For the
     * color, the toString method in the color class is called, which returns
     * the red, green and blue amount as set in either the setter method or
     * set through the constructor.
     *
     * @param none
     */
    @Override
    public String toString()
    {
        return (super.toString() + "\t" + getMyColor().toString());
    }

    /*
     * The purpose of the equals method below was to compare the current
     * Vegetable object with the Object given in the parameter and return
     * whether they are equal or not. First, a check is made to be sure that
     * the Object in the parameter is valid, else return false there itself.
     * Then, the Object is cast to be of type Vegetable. then, the Ingredient
     * equals method is invoked, by using the super.equals, since we want to
     * compare the description, cost and calories, which are all compared
     * in the equals method in the Ingredient class. Then, since we still
     * have the color left to compare, we call the equals method in the color
     * class, which compares the red, blue and green of both Objects and if
     * both of these equals method calls return true, then we know the two
     * Vegetables are equal.
     *
     * @param Object other
     */
    public boolean equals(Object other)
    {
        // check made to be sure the object is not empty and is an instance
        // of Vegetable
        if(other == null || !(other instanceof Vegetable))
        {
            return false;
        }
        // cast to type Vegetable
        Vegetable otherVeggie = (Vegetable)(other);

        // calls the Ingredient equals method, which is the superclass for
        // the Vegetable class, to check the description, the cost and the
        // calories, and also calls the color class equals method to check
        // and make sure the color are equal. If both the equals method
        // return true, then the two Vegetables are the same, and true will
        // be returned.
        return (super.equals(otherVeggie) &&
                getMyColor().equals(otherVeggie.getMyColor()));
    }
}