package ingredients;

import mainClasses.Money;
import mainClasses.PizzaException;

/*
 * The purpose of the Ingredient class was to allow the user to set the
 * description of the Ingredient, then the cost, and then finally the
 * calories, all of this done through the constructor. The description
 * variable in the method was made final, since it is only assigned in the
 * constructor and does not have a setter in the class. There were setters
 * for the cost and the calories method since the user may want to set new
 * values to those. Then, there was a compareTo method to compare the object
 * given in the parameter to the current class and the objective was to
 * compare the prices of the two classes and if they are the same or one
 * bigger than the other, then return the appropriate value. There was
 * a toString to report the description, then the cost and the calories of
 * the current Ingredient. This is done so by using the getter methods in the
 * current Ingredient class. Finally, there was an equals method to check if
 * the Object, if an Ingredient, is equal to the current class, by checking the
 * values of the variables of both classes by using the getter methods of both
 * classes. The class is abstract so that each class that implements the
 * constructor in order for that class to compile.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/9/19
 */
public abstract class Ingredient implements Comparable {
    /*
     * The instance variables are the ones mentioned below. The first is the
     * description, which as the word says, is the name of the Ingredient.
     * Then comes the cost, which is of type Money, which is basically the
     * price of the Ingredient and the Money class we built in this quarter
     * will be used to store the dollars and cents values. Then comes the
     * calories, which are ints, so they will be storing whole numbers, and
     * represent the calories of the particular Ingredient. All 3 of the
     * below variables will be assigned in the constructor that will be
     * taking all 3 parameters as the variables below and will be saving them
     * to the parameters. The description is final since there is no setter
     * used to set the value of the description, and the value is set through
     * the constructor.
     */
    private final String description;
    private Money cost;
    private int calories;

    /*
     * The purpose of the constructor was to take the description of the
     * Ingredient, the price of the Ingredient, in dollars and cents, and the
     * calories for the particular Ingredient. This done by taking all 3
     * variables through the constructor, and the instance variables are
     * assigned through the constructor. The cost is set as a new Money to
     * avoid privacy leaks.
     *
     * @param String descrip, Money cst, int cal
     */
    public Ingredient(String descrip, Money cst, int cal)
    {
        this.description = descrip;
        this.cost = new Money(cst);
        this.calories = cal;
    }

    /*
     * The purpose of the method below was to return the description of the
     * current class.
     *
     * @param none
     */
    public String getDescription() {
        return this.description;
    }

    /*
     * The getter below returns a leash of the cost instance variable, and
     * avoids privacy leaks by doing so and not returning the original variable.
     *
     * @param none
     */
    public Money getCost()
    {
        return new Money(cost);
    }

    /*
     * The setter below allows the person using the object of the class to
     * set the value of the cost to a new Money value, and while doing so,
     * the variable is set through as a new leash, instead of setting the new
     * value to the original variable in this method and allowing privacy
     * leaks.
     *
     * @param Money otherM
     */
    public void setCost(Money otherM)
    {
        this.cost = new Money(otherM);
    }

    /*
     * The method returns the number of calories for the current Ingredient
     * class.
     *
     * @param none
     */
    public int getCalories()
    {
        return this.calories;
    }

    /*
     * The setter's purpose was to allow the user of the Object Ingredient to
     * set the calories through the setter and uses the parameter to be set
     * equal to the original variable in this method, since the variable
     * type is a primitive.
     *
     * @param int otherCalories
     */
    public void setCalories(int otherCalories)
    {
        this.calories = otherCalories;
    }

    /*
     * The purpose of this method was to compare the price of the current
     * Ingredient class and the object in the parameter, and return 0 if the
     * prices for both are equal, return 1 if the parameter's cost is bigger,
     * else return -1, if the current Object's price is bigger than the
     * parameter price. This is done so by first checking to make sure the
     * parameter object is not null or that it is an instance of the
     * Ingredient class. If the above are fulfilled, then the object in the
     * parameter is cast to be of type Ingredient. Then, the cost of both
     * the current class and the parameter Object are compared and
     * appropriate is returned according to whether the prices are equal, one
     * bigger than the other.
     *
     * @param Object other
     */
    public int compareTo(Object other)
    {
        // checks to make sure the parameter object is not null and that it
        // is an instance of the Ingredient class.
        if(other == null || !(other instanceof Ingredient))
        {
            throw new PizzaException("Invalid object!");
        }

        // casts the object to be of type Ingredient, so that the getter
        // method for the cost can be gotten from that class to be compared
        // to the current class's cost method and appropriate number returned
        // according to which one is bigger or if they are equal.
        Ingredient that = (Ingredient)(other);

        // if both the parameter and current object's cost are the same,
        // then return 0
        if(this.getCost().equals(that.getCost()))
        {
            return 0;
        }
        // if the parameter object's cost is bigger than the current
        // object's cost, then return 1
        else if(this.getCost().compareTo(that.getCost()) == 1)
        {
            return 1;
        }
        // if the current object's cost is bigger than the parameter's
        // object's cost, then return -1
        else
        {
            return -1;
        }
    }

    /*
     * The purpose of this toString method was to return the description, cost
     * and the calories for the current Ingredient object. Uses the getter
     * methods of the 3 instance variables to report the values.
     *
     * @param none
     */
    @Override
    public String toString()
    {
        // prints the description of the Ingredient, followed by the cost of
        // the Ingredient and the calories of the Ingredient.
        return (this.getDescription() + ", cost: "+ this.getCost() + ", " +
                "calories: " + this.getCalories());
    }

    /*
     * The purpose of the .equals(Object other) method was to check if the
     * current class's methods are equal to the methods in the parameter
     * class. This is done so by first making sure the parameter object is
     * not null and that the class is an instance of the Ingredient class. If
     * the conditions are fulfilled, then the Object is cast to be of type
     * Ingredient. Then, since the only variables to be compared are the
     * description, the cost, and the calories for the Ingredient objects to
     * be equal, so the .get methods for the 3 variables are compared and if
     * all 3 are equal, then true is returned.
     *
     * @param Object other
     */
    @Override
    public boolean equals(Object other)
    {
        // makes sure the object is not null and that it is an actual instance
        // of the Ingredient class
        if(other == null || !(other instanceof Ingredient))
        {
            return false;
        }

        // object is cast to be of type Ingredient, so that all the get
        // methods can be compared to check if the two Ingredients are equal.
        Ingredient that = (Ingredient)(other);

        // if the description, the cost and the calories for the current
        // object and the parameter object are equal, then we know that the
        // two Ingredients are equal. If they indeed are equal, the 3
        // variables gotten through the getter methods, then true is returned
        // else false is returned.
        return (this.getDescription().equals(that.getDescription()) &&
                this.getCost().equals(that.getCost())
                && this.getCalories() == that.getCalories());
    }
}