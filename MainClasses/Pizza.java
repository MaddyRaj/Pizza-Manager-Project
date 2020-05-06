package mainClasses;
import java.text.DecimalFormat;

import shapes.Circle;
import shapes.Shape;
import timeStamp.Date;
import timeStamp.TimeStamp;
import ingredients.Ingredient;

import java.util.Calendar;
import java.util.Random;

/*
 * The purpose of this was to get all the different Ingredient, Shape and
 * Money classes we built and put them together and use them in this class.
 * we had them as instance variables and used them for multiple things like
 * saving the ArrayList of Ingredients or saving the remaining fraction of
 * the Pizza. We also used the Date class in order to save the Date that we
 * made the Pizza on. Then, we had a constructor which used a randomizer ssin
 * order to choose which Ingredient, shape and Vegetable to take. Then, in
 * the same class, we had the randomizer to choose the made Date for the
 * Pizza.We had getters and setters for the remaining fraction class, which
 * just returned the amount, in fraction, remaining and the setter just set
 * the new Fraction equal to the remainingFraction. Then we had getters and
 * setters for the cost, which allowed to user to get a leash of the cost
 * variable and set a leash to the cost variable. There were same above
 * methods for the Shape class and same thing as the cost for Shapes, and we
 * had an ingredient counter which kept track of the number of ingredients so
 * far. Then we had a toString which printed the appropriate description
 * through the method.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/10/19
 */
public class Pizza implements PizzaComparable {
    /*
     * ingredientArrayList = Arraylist of type Ingredient, keeping track of
     * all ingredients so far
     * calories = keeps track of the number of calories for this Pizza
     * cost = Uses the Money object to keep track of the cost of this Pizza
     * shape = the Shape object used to represent the Shape of this Pizza
     * remainingFraction = represents the Fraction remaining of this Pizza
     * madeDate = date this Pizza was made
     * ingredientCounter = keeps track of the ingredients on this Pizza
     */
    private ArrayList<Ingredient> ingredientArrayList = new ArrayList<Ingredient>();
    private int calories = 0;
    private Money cost = new Money(8,0);
    private Shape shape;
    private Fraction remainingFraction = new Fraction(1,1);
    private Date madeDate;
    private int ingredientCounter;

    /*
     * The purpose of this class was to make a random pizza using random
     * shape, base, meat, cheese for the Pizza, using a random number generator.
     */
    public Pizza() {
        // random number generator used to assign values to the different
        // instance vars created above
        Random randomNum = new Random();

        // if the value is 1, then the shape should be a circle, else a square
        if(randomNum.nextInt(2) == 1)
        {
            shape = new Circle();
        }
        else
        {
            shape = new Square();
        }

        // sets the shape in this class to be the shape we found above
        this.setShape(shape);

        // the if loop will decide the base sauce for the class
        Ingredient base;
        // if the number is 1, then choose the Marinara as the sauce, else
        // the Alfredo as the sauce
        if(randomNum.nextInt(2) == 1)
        {
            base = new Marinara();
        }
        else
        {
            base = new Alfredo();
        }
        // adds the Base to the list of ingredients
        this.addIngredient(base);

        // The meat will be decided by the if loop below
        Ingredient meat;
        // if the number is 1, then the Meat is sausage, else its Pepperoni
        if(randomNum.nextInt(2) == 1)
        {
            meat = new Sausage();
        }
        else
        {
            meat = new Pepperoni();
        }
        // adds the meat randomly chosen above to the list of Ingredients
        this.addIngredient(meat);


        // The cheese will be chosen by the if loop below
        Ingredient cheese;
        // if 1, then Mozzarella is the Cheese, else Goat cheese
        if(randomNum.nextInt(2) == 1)
        {
            cheese = new Mozzarella();
        }
        else
        {
            cheese = new GoatCheese();
        }
        // adds the cheese to the list of Ingredients
        this.addIngredient(cheese);

        // calender tracker made to keep track of when the Pizza was made
        Calendar trackCal = Calendar.getInstance();
        // random number generator will be used again to choose random date
        Random randomNumV2 = new Random();
        // chooses the random day between 0 and 32, and this will round down
        // so will be accurately only including 31
        int randDay = (int)(Math.random()*32);

        // repeats till we get the number between 0 and 31
        while(randDay == 0)
        {
            randDay = randomNumV2.nextInt(32);
        }

        // the pizza made Date, will use the TimeStamp class to assign the
        // month, day and year, which will gotten from the get methods for
        // the respective classes.
        madeDate = new TimeStamp(new Date(trackCal.getTime().getMonth(),
                randDay, trackCal.getTime().getYear() + 1700),
                MyPizzaManager.getCurrentTime());
    }

    /*
     * The purpose of the method was to return a leash of the original
     * remainingFraction variable in this class.
     *
     * @param none
     */
    public Fraction getRemainingFraction() {
        return new Fraction(remainingFraction);
    }

    /*
     * The purpose of the method was to set the current variable
     * remainingFraction to the new variable pizzaLeft in the parameter
     *
     * @param pizzaLeft
     */
    public void setRemainingFraction(Fraction pizzaLeft) {
        this.remainingFraction = new Fraction(pizzaLeft);
    }

    /*
     * The purpose of the method was to return the area of the current
     * Fraction, which in this case was the area of the Shape * the
     * remainingFraction, converted to decimal using the decimal method made
     * in the Fraction class.
     *
     * @param none
     */
    public double getRemainingArea()
    {
        return (this.shape.getArea()*getRemainingFraction().decimal());
    }

    /*
     * The method returned the number of calories in this class.
     *
     * @param none
     */
    public int getCalories() {
        return calories;
    }

    /*
     * Returned a leash of the cost of this class, also avoiding privacy
     * leaks here.
     *
     * @param none
     */
    public Money getCost() {
        double remainFracDec =
                (double)(getRemainingFraction().getNumerator()/getRemainingFraction().getDenominator());
        return new Money((this.cost.getMoney()*remainFracDec));
    }

    /*
     * Again returning a leash of the original Shape object, to avoid any
     * privacy leaks.
     *
     * @param none
     */
    public Shape getShape() {
        return (Shape)(shape.clone());
    }

    /*
     * Returns a leash of the Date class, and since an Object, have to be
     * careful to not allow any privacy leaks, hence the leash returned.
     *
     * @param none
     */
    public Date getMadeDate() {
        return new Date(madeDate);
    }

    /*
     * The purpose of the method was to save the new Shape given to us as the
     * clone to our current Shape, which is done so in the method.
     *
     * @param Shape newShape
     */
    public void setShape(Shape newShape)
    {
        shape = (Shape)(newShape.clone());
    }

    /*
     * The purpose of the method was add a new Ingredient object to our
     * arrayList created above that is of type Ingredient. After making sure
     * the object is not null, we add the calories of that Ingredient to our
     * current calorie counter, do the same for the cost, ingredientCounter
     * and add the Object to our ArrayList of ingredients.
     *
     * @param Ingredient newIngred
     */
    public void addIngredient(Ingredient newIngred)
    {
        // if the parameter object is null, then throw an exception that it
        // is null
        if(newIngred == null)
        {
            throw new PizzaException("Ingredient is empty!");
        }

        // add the calories of the parameter object to our calorie counter
        calories += newIngred.getCalories();
        // add the cost of the new Ingredient
        cost.add(new Money(newIngred.getCost()));
        // add the new Object to our arrayList at the counter index
        ingredientArrayList.insert(newIngred,ingredientCounter);
        // increment the counter to account for the new Object
        ingredientCounter++;
    }

    /*
     * The purpose of the method was, when given a fraction through the
     * parameter, set the amount remaining in this class to the original
     * amount - the new amount. After calling the Fraction class's remove
     * method, we set the remainingFraction in this class to be equal to the
     * amount remaining, again avoiding privacy leaks.
     *
     * @param Fraction amt
     */
    public void eatSomePizza(Fraction amt)
    {
        Fraction amtRemain = new Fraction(remainingFraction.remove(amt));
        remainingFraction = new Fraction(amtRemain);
    }

    /*
     * The purpose of the toString was to return the Price, calories,
     * Fraction remaining, area and the shape of the pizza.
     *
     * @param none
     */
    @Override
    public String toString()
    {
        String print =
                "Ingredients are: " + this.ingredientArrayList.toString() +
                        "\nPizza has a price:" + this.cost.toString() + " and calories:" + this.calories+
                        ", Fraction remaining:" + this.remainingFraction.toString() +
                        " and area left:" + this.getRemainingArea() + " and shape:" + this.shape.toString() + "\n";
        return print;
    }

    /*
     * The purpose of the method below was to compare two objects, their
     * costs to be specific, and return if their costs are the same, and for
     * this, we use the compareTo method of the Money class to compare. First
     * we make sure the Object is not null and is an instance of the Pizza
     * object. If the above is satistified, then we cast the Object to be of
     * type Pizza, and then return the value of the compareTo of the two costs.
     *
     * @param Object other
     */
    @Override
    public int compareTo(Object other) {
        // make sure the Object is not null and is an instace
        if(other == null || !(other instanceof Pizza))
        {
            throw new PizzaException("Bad object!");
        }

        // cast the Object to be of type Pizza
        Pizza that = (Pizza)(other);

        // return the comparing of the cost of both Objects
        return (this.getCost().compareTo(that.getCost()));
    }

    /*
     * This method, just like the previous method, had the task of comparing
     * the parameter object and the current object's remainingFraction. This
     * is done so by first checking and throwing exception if the Object is
     * not valid. Then, if valid, then we cast the Object to be of type Pizza
     * and then return the compare value of the current remaining fraction
     * with the parameter remaining fraction.
     */
    @Override
    public int compareToBySize(Object other) {
        // makes sure the parameter is valid
        if(other == null || !(other instanceof Pizza))
        {
            throw new PizzaException("Bad object!");
        }

        // cast to be of type Pizza
        Pizza that = (Pizza)(other);

        // returns the comparison of the two Fractions, using the compareTo
        // method in the Fraction class
        return (this.getRemainingFraction().compareTo(that.getRemainingFraction()));
    }

    /*
     * The purpose of this method was to return the comparison of the
     * calories for both the parameter and the current class's calorie amount.
     * This is done so by first validating the Object. Then we compare the
     * values of the calorie variable for both, since they are primitives
     * and return the appropriate value for the output.
     *
     * @param Object other
     */
    @Override
    public int compareToByCalories(Object other) {
        // making sure the object is not null and is an instance, hence
        // checking if valid
        if(other == null || !(other instanceof Pizza))
        {
            throw new PizzaException("Bad object!");
        }

        // cast the Object to be of type Pizza
        Pizza that = (Pizza)(other);

        // if the calories are equal then return 0
        if(this.getCalories() == that.getCalories())
        {
            return 0;
        }
        // if the calorie of this class is bigger than the parameter class,
        // then return 1
        else if(this.getCalories() > that.getCalories())
        {
            return 1;
        }
        // if this class's calorie is less than the parameter, then return -1
        else
        {
            return -1;
        }
    }
}