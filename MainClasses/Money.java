package mainClasses;
/*
 * The purpose of this class was to save the values for dollars and cents
 * through different types of constructors, overloading constructors and
 * usage of setters and getters in order to save cents and dollars for the
 * Money object and compare two objects also if desired using the Overridden
 * equals method.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/10/19
 */
public class Money implements Comparable {
    //instance variables declared
    private int dollars;
    private int cents;

    //empty constructor
    public Money() {
    }

    /*
     * The purpose of the constructor was to be able to take an input dollar
     * value and save as the dollar in the class, but inside the constructor,
     * I send the dollar value to the setDollars method, which then checks
     * the validity of the value, making sure its not less than 0. if this is
     * the case, then the cents will be assumed to be the current value,
     * since we don't know when the user will be using the constructor in
     * his Driver class.
     *
     * @param int dol
     */
    public Money(int dol) {
        this.setDollars(dol);
    }

    /*
     * The purpose of the constructor below was to be able to take a double
     * as a parameter and set the dollars and cents to values given the
     * parameter accordingly.
     *
     * @param double dol
     */
    public Money(double dol)
    {
        this.setDollars((int)(dol));
        this.setCents((int)(dol-dollars) * 100);
    }

    /*
     * The purpose of the overloaded constructor was to be able to take an
     * input dollar and a cent, and save as the dollar and cents in the class,
     * but inside the constructor, I send both the dollar and the cent values
     * to the setDollars and setCents method, which then checks the validity of
     * the value, making sure its not less than 0 and for cents, not greater
     * than 99. if this is the case, then the setters will print the
     * appropriate message regarding the validity of each, the class invariants.
     *
     * @param int dol, int cent
     */
    public Money(int dol, int cent)
    {
        this.setDollars(dol);
        this.setCents(cent);
    }

    /*
     * The purpose of the overloaded constructor was to be able to take a Money
     * object and set its values into the constructor above, which takes the
     * cents and dollars. So, the objects, cents and dollars will be saved
     * using another constructor above and using that constructor inside a
     * constructor we just made, so saving extra unnecessary lines of code.
     *
     * @param Money other
     */
    public Money(Money other)
    {
        this(other.getDollars(),other.getCents());
    }

    /*
     * purpose of the Main in the Money class was to test and see whether the
     * money class is correctly saving the new values for the money object
     * and whether the overridden methods return the desired, accurate output.
     *
     * @param String[] args
     */
    public static void main(String[] args)
    {
        Money m = new Money();
        m.setMoney(5,99);
        m.add(10);
        Money m2 = new Money(15);
        System.out.println(m.toString());
        System.out.println(m2.equals(m));
    }

    //
    /*
     * a.compareTo(b) // a > b ? +1
     * a.compareTo(b) // a == b ? 0
     * a.compareTo(b) // b > a ? -1
     */
    @Override
    public int compareTo(Object other)
    {
        if(other == null || !(other instanceof Money))
        {
            throw new RuntimeException("Bad num!");
        }
        Money that = (Money)(other);
        int thisDelta = this.dollars * 100 + this.cents;
        int thatDelta = that.dollars * 100 + that.cents;
        return (thisDelta-thatDelta);
    }


    //returns the dollars in this class
    public int getDollars() {
        return this.dollars;
    }

    /*
     * The purpose of this method was to check to make sure that the value
     * given by the user is valid, meaning should be a positive value, else
     * an error message comes and the System.exit() is used to stop running
     * code altogether. This is the class invariant.
     *
     * @param int newDollars
     */
    public void setDollars(int newDollars) {
        if(newDollars < 0)
        {
            throw new RuntimeException("Not a valid dollar value!");
        }
        else
        {
            this.dollars = newDollars;
        }
    }

    //getter returning the cents in this class
    public int getCents() {
        return this.cents;
    }

    /*
     * The purpose of this method was to check to make sure that the value
     * given by the user is valid, meaning should be a positive value and
     * less than 99, since above would make it a dollar value. If the
     * condition is not satisfied, then an error message comes and the
     * System.exit() is used to stop running code altogether. This is the
     * class invariant.
     *
     * @param int newCents
     */
    public void setCents(int newCents) {
        if(newCents < 0 || newCents > 99)
        {
            throw new RuntimeException("Not valid cent value!");
        }
        else
        {
            this.cents = newCents;
        }
    }

    /*
     * Purpose of this method was to return the amount of dollars and the
     * cents. For the cents, since we are giving the dollars + the cents, the
     * cents will be made a double and divided by hundred so to be able to
     * return correctly, since both are saved as ints in their separate
     * methods.
     *
     * @param none
     */
    public double getMoney()
    {
        return (this.getDollars() + this.getCents()/100.0);
    }

    /*
     * purpose of the method was to set the dollars and cents to the new
     * values from the parameter. I used the setters for setting the values
     * because through those setters, I'm checking for the validity of the
     * values, making sure both values are valid. This also is a class
     * invariant.
     *
     * @param int dol, int cent
     */
    public void setMoney(int dol, int cent)
    {
        if (dol < 0)
        {
            throw new RuntimeException("Invalid dollar amount!");
        }
        else if(cent < 0 || cent > 99)
        {
            throw new RuntimeException("Invalid cent amount!");
        }
        else
        {
            this.dollars = dol;
            this.cents = cent;
        }
    }

    /*
     * The purpose of this method was to add just the dollars when the user
     * desired, but make sure to check that the value they want to set is
     * greater than 0 and a valid value. If so, then the current dollar value
     * is incremented with the desired dollar value in the parameter.
     *
     * @param int dol
     */
    public void add(int dol)
    {
        if(dol < 0)
        {
            throw new RuntimeException("Invalid dollar amount!");
        }
        else
        {
            this.dollars += dol;
        }
    }

    /*
     * The purpose of this method was to add dollars and cents when the user
     * desired. In order to add the values, a check is first made to be sure
     * that the parameter values each are valid, dollars positive and cents
     * between 0 and 99. If the condition is fulfilled, then the values are
     * added to the current value of the dollars and cents. This also is the
     * class invariant.
     *
     * @param int dol, int cent
     */
    public void add(int dol, int cent)
    {
        if (dol < 0)
        {
            throw new RuntimeException("Invalid dollar amount!");
        }
        else if(cent < 0 || cent > 99)
        {
            throw new RuntimeException("Invalid cent amount!");
        }
        else
        {
            this.dollars += dol;
            this.cents += cent;
            this.dollars += this.cents / 100;
            this.cents = this.cents % 100;
        }
    }

    /*
     * The purpose of this another overloaded add method was to be able to
     * add dollar and money values from a given object as a parameter. Inside
     * the method, first, a check is made to make sure that the dollar and
     * cent values are valid and if so, only then are they added to the
     * cents and dollars in this class.
     *
     * @param Money other
     */
    public void add(Money other)
    {
        if (other.getDollars() < 0)
        {
            throw new RuntimeException("Invalid dollar amount!");
        }
        else if(other.getCents() < 0 || other.getCents() > 99)
        {
            throw new RuntimeException("Invalid cent amount!");
        }
        else
        {
            this.dollars += other.getDollars();
            this.cents += other.getCents();
        }
    }

    /*
     * The purpose of this equals method was to check if the Object given as
     * the parameter is equal to this class, meaning whether the dollar and
     * cent values are equal. First, a check is made to be sure that the
     * object is not null and to be sure that it is an instance of money.
     * Then, if so, then the object is cast as a Money object and then the
     * dollars and cents of both classes are compared and if equal, then
     * returns true, else false.
     *
     * @param Object o
     */
    @Override
    public boolean equals(Object o)
    {
        if(o == null || !(o instanceof Money))
        {
            return false;
        }
        Money that = (Money)(o);
        return (this.dollars == that.dollars &&
                this.cents == that.cents);
    }

    /*
     * The overridden toString() prints the dollars and cents along with the
     * dollar sign in front of the dollar.cent amount.
     *
     * @param none
     */
    @Override
    public String toString()
    {
        return ("$" + this.getDollars() + "." + this.getCents());
    }
}