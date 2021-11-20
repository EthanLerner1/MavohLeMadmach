package Maman12;

/**
 * represents a two dimensional Point and its basic properties and methods
 *
 * @author Ethan Lerner
 * @version 20/11/2021
 */
public class Point {
    // region ------ Properties ------
    private int _x;
    private int _y;
    // endregion

    // region ------ constructors ------

    /**
     * Constructor for objects of class Point Constructs a new point with the specified x y coordinates
     *
     * @param x value on the horizontal axis
     * @param y value on the vertical axis
     */
    public Point(int x, int y) {
        this._x = x;
        this._y = y;
    }

    /**
     * Copy constructor, constructs and initializes a point using another point
     *
     * @param p Point to copy
     */
    public Point(Point p) {
        this._x = p.getX();
        this._y = p.getY();
    }

    // endregion
    // region ------ methods ------

    /**
     * Returns the x coordinate of the point.
     *
     * @return the x coordinate of the point
     */
    public int getX() {
        return this._x;
    }

    /**
     * Returns the y coordinate of the point.
     *
     * @return the y coordinate of the point
     */
    public int getY() {
        return this._y;
    }

    /**
     * Sets the x coordinate of the point
     *
     * @param num a new value for the X coordinate
     */
    public void setX(int num) {
        this._x = num;
    }

    /**
     * Sets the y coordinate of the point
     *
     * @param num a new value for the Y coordinate
     */
    public void setY(int num) {
        this._y = num;
    }

    /**
     * Representation of the object in String
     *
     * @return the coordinates of a point as a string; for example : (1,2)
     */
    public String toString() {
        return "(" + this._x + "," + this._y + ")";
    }

    /**
     * Checks if two points are equal.
     *
     * @param other The point to be compared with the current point.
     * @return true if the point to be compared is equal to the current point.
     */
    public boolean equals(Point other) {
        return (other.getX() == this._x) && (other.getY() == this._y); // check Point properties
    }

    /**
     * Checks if the current point is above the point it is to be compared with.
     *
     * @param other the point to be compared with the current point.
     * @return true if the current point is above the pointit is to be compared with..
     */
    public boolean isAbove(Point other) {
        return other.getY() < this._y;
    }

    /**
     * Checks if the current point is beneath the point it is to be compared with.
     *
     * @param other the point to be compared with the current point
     * @return true if the current point is beneath the point it is to be compared with
     */
    public boolean isUnder(Point other) {
        if (this._y == other.getY())
            return false;
        return !this.isAbove(other); // the opposite of isAbove()
    }

    /**
     * Checks if the current point is left of the point it is to be compared with.
     *
     * @param other the point to be compared with the current point
     * @return true if the current point is left of the point it is to be compared with.
     */
    public boolean isLeft(Point other) {
        return other.getX() > this._x;
    }

    /**
     * Checks if the current point is right of the point it is to be compared with.
     *
     * @param other the point to be compared with the current point
     * @return true if the current point is right of the point it is to be compared with.
     */
    public boolean isRight(Point other) {
        if (this._x == other.getX())
            return false;
        return !this.isLeft(other);
    }

    /**
     * Moves the current point , at location (x,y) to a new location. This new location is determined by deltaX which changes X's position along the X axis and deltaY which changes Y's position along the Y axis.
     *
     * @param deltaX the distance to move the current point along the X axis
     * @param deltaY the distance to move the current point along the Y axis
     */
    public void move(int deltaX, int deltaY) {
        // adding deltas to each property
        this._x += deltaX;
        this._y += deltaY;
    }

    /**
     * Calculates the distance between two points.
     *
     * @param p the second point whose distance from the current point is to be calculated
     * @return the distance between the current point and the point passed as a parameter.
     */
    public double distance(Point p) {
        // using Pythagoras rule
        double xDelta = this._x - p.getX();
        double yDelta = this._y - p.getY();
        return Math.sqrt(Math.pow(xDelta, 2) + Math.pow(yDelta, 2));
    }
}