package timeStamp;

import mainClasses.PizzaManager;

/*
 * The purpose of the class below was to use the other classes Time and Date,
 * to assign the date and times for the particular objects.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/10/19
 */
public class TimeStamp extends Date{
    // instance variables for the Time and the Date
    private Time currentTime;

    // constructor to set the current time and date equal to each other

    // @param Date cDate, Time cTime
    public TimeStamp(Date cDate, Time cTime)
    {
        super(cDate);
        this.currentTime = new Time(cTime);
    }

    // method returns the current time
    public Time getCurrentTime() {
        return new Time(currentTime);
    }

    // returns the current date
    public Date getCurrentDate() {
        return new Date(this);
    }

    // prints the date and the time
    @Override
    public String toString()
    {
        return (currentTime.toString() + "on " + super.toString());
    }
}
