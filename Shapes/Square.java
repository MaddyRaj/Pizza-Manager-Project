package shapes;

import java.awt.*;
import java.awt.Color;

/*
 * The purpose of this class was to represent a Square and it does so by
 * having a side length and using it in the getArea or the parameter to set
 * values. The x and y methods have setters and getters for the values in the
 * Shape class, so not making them again here, but there are getters and
 * setters for the sideLength and toString to return the Shape name.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/10/19
 */
public class Square extends Shape {
    // side length of the square, which will be the same for all 4 sides
    private int sideLength = 10;

    // the clone will return a copy of the current Object of type Square
    @Override
    public Square clone()
    {
        return new Square(this);
    }

    // sets the x and y to the values in the super class, the x value is a
    // random number and the y will be the same, so for that, we just get the
    // x value.
    public Square()
    {
        super();
        super.setX((int)(Math.random()*100+20));
        super.setY(getX());
    }

    // this side length is set to the side length in the parameter class

    // Square other
    public Square(Square other)
    {
        this.sideLength = other.sideLength;
    }

    // the x and y values are assigned for this class, but we just use the
    // super constructor to assign the values.
    public Square(int nx, int ny)
    {
        super(nx,ny);
    }

    // returns the Shape name
    @Override
    public String toString()
    {
        return "Square";
    }

    // draws the shape
    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)(g);
        g2d.setColor(new Color(0,15,0));
        g2d.draw3DRect(getX(),getY(),sideLength,sideLength,false);
    }

    // returns the area of the Shape
    @Override
    public double getArea() {
        return (sideLength*sideLength);
    }
}
