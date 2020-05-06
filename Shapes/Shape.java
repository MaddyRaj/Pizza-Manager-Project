package shapes;
import java.awt.*;

/*
 * The purpose of the class was to represent a shape and how a Shape would
 * behave and what variables it needs in order to draw something. The method
 * had x, y values and had a color and had getters and setters for the same.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/10/19
 */
public abstract class Shape implements Cloneable{
    // instance variables for the x and y value, and then color to represent
    // the color of the Shape
    private int x;
    private int y;
    private Color myColor;

    // the method is abstract so all the classes that implement the class
    // will need to return a clone of their class
    @Override
    public abstract Object clone();

    // empty constructor
    public Shape()
    {}

    // constructor with given x and y values in the parameter
    public Shape(int a, int b)
    {
        // x,y so x is set to a and y is set to b
        this.x = a;
        this.y = b;
    }

    // returns the x value

    // @param none
    public int getX() {
        return x;
    }

    // sets the color of the current shape to the one in the parameter

    // @param Color next
    public void setColor(Color next) {
        myColor = next;
    }

    public Color getMyColor() {
        return myColor;
    }

    // sets the x value to the one in the parameter

    // @param int nx
    public void setX(int nx) {
        this.x = nx;
    }

    // sets the y value to the given one from the parameter

    // @param int ny
    public void setY(int ny) {
        this.y = ny;
    }

    // returns the y value
    public int getY() {
        return y;
    }

    public abstract void draw(Graphics g);
    public abstract double getArea();
}
