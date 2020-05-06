package mainClasses;
/*
 * The purpose of this class was to be a class that will be used to throw
 * exceptions. This class extends the RuntimeException class, whose methods
 * will be used here. There are 2 constructors, one that takes no parameters
 * and one that takes a message as a parameter. The one with no parameter
 * will redirect to the super class's method will parameter and will report
 * the exception with the user's desired error message.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 5/17/19
 */
public class PizzaException extends RuntimeException {
    // no parameter exception will not have a error specific message, so will
    // just print error found, telling that there is an error but don't know
    // which type.
    public PizzaException()
    {
        super("Error found!");
    }

    // string message will print an error, but with a message desired by the
    // user like index out of bounds or empty list error. Inside this method,
    // it is redirected to the RuntimeException class's method with a
    // parameter, which will throw the error with the desired message below.
    public PizzaException(String message)
    {
        super(message);
    }
}