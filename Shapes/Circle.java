package shapes;
import java.awt.*;

/*
 * The purpose of the class below was to represent a circle. It does so by
 * having the toString method, the draw method, the clone to return a clone
 * of the class, and then the constructors to set values for the radius and
 * the color.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/10/19
 */
public class Circle extends Shape implements Cloneable {
    // instance variables, one to keep track of the radius and the color for
    // the Color
    private double radius;
    private Color myColor;

    // returns the name of the shape, which is a circle
    @Override
    public String toString()
    {
        return "Circular";
    }

    // returns the clone of the Circle class
    @Override
    public Circle clone()
    {
        return new Circle(this);
    }

    // if no radius is specified, then the radius is set equal to a random
    // number from 0 to 10
    public Circle()
    {
        super();
        radius = (Math.random()*10);
        setRadius(radius);
    }

    // sets this radius equal to the parameter's radius

    // @param Circle other
    public Circle(Circle other)
    {
        this.radius = other.radius;
    }

    // this radius is set equal to the radius in the parameter

    // @param int rad
    public Circle(int rad)
    {
        this.radius = rad;
    }

    // returns the area of the circle
    @Override
    public double getArea()
    {
        return (Math.PI*radius*radius);
    }

    // draws the circle using Graphics

    // @param Graphics g
    @Override
    public void draw(Graphics g)
    {
        int rad = (int)(radius);
        g.drawOval(2,4,rad,rad);
    }

    // returns the radius of the circle
    public double getRadius()
    {
        return radius;
    }

    // sets the radius of this class to the parameter radius
    public void setRadius(double newRad)
    {
        this.radius = newRad;
    }

    // returns the color of the current class
    @Override
    public Color getMyColor() {
        return myColor;
    }

    // sets the color of this class to the color of the parameter class
    public void setMyColor(Color thatColor) {
        this.myColor = thatColor;
    }
}

