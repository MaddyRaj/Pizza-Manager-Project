package timeStamp;
/*
 * The purpose of this class was to save the values for month, day and year
 * and have the setters for the 3 variables which make sure that the 3
 * variable values given as inputs in parameters are valid. Then, we have
 * .equals() and toString() values which were overridden methods in this class.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/10/19
 */

public class Date implements Comparable {
    //instance variables for month, day and year
    private int month;
    private int day;
    private int year;

    @Override
    public int compareTo(Object other) {
        if(other == null || !(other instanceof Date))
        {
            throw new RuntimeException("Bad Date!");
        }

        Date that = (Date)(other);

        return (this.getDay()-that.getDay());
    }

    /*
     * purpose of the Main in the Date class was to make sure that the
     * objects of the Date class are saving all the values correctly and that
     * the equals and toString() overridden methods are returning accurate
     * values.
     *
     * @param String[] args
     */
    public static void main(String[] args)
    {
        Date a = new Date(0,0,0);
        Date b = new Date(2,1,2030);
        Date c = new Date(2,1,2030);
        System.out.println(b);
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
    }

    //empty constructor
    public Date()
    {}

    /*
     * The purpose of this constructor was to be able to save the month, day
     * and year given through the parameters. The setters are used inside to
     * check the validity of each of the input parameters.
     *
     * @param int m, int d, int y
     */
    public Date(int m, int d, int y)
    {
        //we should use setMonth() since we want to check if the given values
        // are valid, and that method does the check.
        this.month = m;
        this.day = d;
        this.year = y;
    }

    /*
     * The purpose of this overloaded constructor was to be able to take an
     * object in the parameter, and use the values of that object to set the
     * month, day and year for this class. Again, setters are used to check
     * for validity of each.
     *
     * @param Date other
     */
    public Date(Date other)
    {
        this.month = other.getMonth();
        this.day = other.getDay();
        this.year = other.getYear();
    }

    /*
     * The purpose of the toString() was to print the Date, which would be
     * the month, followed by the date and the year, all separated using a
     * backslash in between each of the first and the third.
     *
     * @param none
     */
    @Override
    public String toString()
    {
        return (this.month + "/" + this.day + "/" + this.year);
    }

    /*
     * The purpose of the equals function was to take an object as a
     * parameter and first check to make sure its not null and is an instance
     * of the current Date class. If the above is fulfilled then, the object
     * is cast to a the Date type and then the month, day and year of that
     * class and this class is compared and if all are equal, then the
     * method returns true else returns false.
     *
     * @param Object other
     */
    @Override
    public boolean equals(Object other)
    {
        if(other == null || !(other instanceof Date))
        {
            return false;
        }
        Date that = (Date)(other);
        return (this.month == that.month && this.day == that.day &&
                this.year == that.year);
    }

    //This method just returns the month in this class
    public int getMonth() {
        return this.month;
    }

    /*
     * The purpose of this method was to set the value of the month in the
     * parameter, on the condition that it has to be between 0 and 12, else
     * the loop prints Invalid and quits the System using System.exit(), not
     * running any more code. If the condition is met, then the current
     * class's month is set to the parameter month value. This also is the
     * class invariant.
     *
     * @param int newMonth
     */
    public void setMonth(int newMonth) {
        if(newMonth < 0 || newMonth > 12)
        {
            throw new RuntimeException("Invalid month value!");
        }
        else
        {
            this.month = newMonth;
        }
    }

    //returns the day value in this class
    public int getDay() {
        return this.day;
    }

    /*
     * The purpose of this method was to set the day, on the condition that
     * the value of the day has to be between 0 and 31, else a message is
     * printed that the day value is invalid and the System.exit() is used to
     * quit the running of the code immediately. Else, the day value in this
     * class is set to the day value in the parameter. This also is the
     * class invariant.
     *
     * @param int newDay
     */
    public void setDay(int newDay) {
        if(newDay < 0 || newDay > 31)
        {
            throw new RuntimeException("Invalid day value!");
        }
        else
        {
            this.day = newDay;
        }
    }

    //returns the year value in this class
    public int getYear() {
        return this.year;
    }

    /*
     * The purpose of this method was to set the year using the value in the
     * parameter. First, a check is made to make sure that the year has to be
     * a four digit value, greater than 1000, and if the year does not match
     * the above requirements then the appropriate message is printed and
     * System.exit() is used, not allowing any more code to run. This also is the
     * class invariant.
     *
     * @param int newYear
     */
    public void setYear(int newYear) {
        if(newYear < 1000)
        {
            throw new RuntimeException("Invalid year value!");
        }
        else
        {
            this.year = newYear;
        }
    }
}