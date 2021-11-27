package Maman12;

/**
 * Class RectangleA. The RectangleA class represents a 2D axis aligned integral rectangles.
 *
 * @author Ethan Lerner
 * @version 20/11/2021
 */
public class RectangleA {
    // region -------- Properties --------
    private int _width;
    private int _height;
    private Point _pointSW;

    // consts
    private final int DEFAULT_VALUE = 1;
    //endregion

    // region ------- Constructors -------

    /**
     * First constructor for objects of class RectangleA Constructs a new rectangle with the specified width, height and it's south west corner is (0,0)
     *
     * @param width  The rectangle width
     * @param height The rectangle height
     */
    public RectangleA(int width, int height) {
        if (width > 0) { // validate that w is bigger then 0
            this._width = width;
        } else {
            this._width = DEFAULT_VALUE;
        }
        if (height > 0) { // validate that h is bigger then 0
            this._height = height;
        } else {
            this._height = DEFAULT_VALUE;
        }
        this._pointSW = new Point(0, 0);// default
    }

    /**
     * Second constructor for objects of class RectangleA Construct a new rectangle with the specified width, height and south west vertex
     *
     * @param p south-western vertex
     * @param w rectangle width
     * @param h rectangle height
     */
    public RectangleA(Point p, int w, int h) {
        if (w > 0) { // validate that w is bigger then 0
            this._width = w;
        } else {
            this._width = DEFAULT_VALUE;
        }
        if (h > 0) { // validate that h is bigger then 0
            this._height = h;
        } else {
            this._height = DEFAULT_VALUE;
        }
        this._pointSW = new Point(p); // under the circumstance that p != null
    }

    /**
     * Third constructor for objects of class RectangleA Construct a new rectangle with the specified south west vertex and north east vertex
     *
     * @param sw south western vertex
     * @param ne north eastern vertex
     */
    public RectangleA(Point sw, Point ne) {
        this._pointSW = new Point(sw);
        this._width = ne.getX() - sw.getX(); // calculating width
        this._height = ne.getY() - sw.getY(); // calculating height
    }

    /**
     * Copy constructor for objects of class RectangleA Constructs a rectangle using another rectangle
     *
     * @param r The rectangle from which to construct the new object
     */
    public RectangleA(RectangleA r) {
        this._height = r.getHeight();
        this._width = r.getWidth();
        this._pointSW = new Point(r.getPointSW());
    }
    // endregion

    // region ------- Methods --------

    /**
     * Returns the width of the rectangle
     *
     * @return the width of the rectangle
     */
    public int getWidth() {
        return this._width;
    }

    /**
     * Returns the height of the rectangle
     *
     * @return the height of the rectangle
     */
    public int getHeight() {
        return this._height;
    }

    /**
     * Returns the South-West point of the rectangle
     *
     * @return a copy of the s-w point of the rectangle
     */
    public Point getPointSW() {
        return new Point(this._pointSW);
    }

    /**
     * Sets the width of the rectangle
     *
     * @param w the width of the rectangle to set to
     */
    public void setWidth(int w) {
        if (w > 0) { // validate input
            this._width = w;
        }
    }


    /**
     * Sets the height of the rectangle
     *
     * @param h the height of the rectangle to set to
     */
    public void setHeight(int h) {
        if (h > 0) {// validate input
            this._height = h;
        }
    }

    /**
     * Sets the South-West point of the rectangle
     *
     * @param p the S-W point of the rectangle to set to
     */
    public void setPointSW(Point p) {
        this._pointSW = new Point(p);
    }

    /**
     * Returns a string representation of the rectangle
     *
     * @return a string represent the rectangle For example: Width=4 Height=6 PointSW=(1,2)
     */
    public String toString() {
        return "Width=" + this._width + " Height=" + this._height + " PointSW=" + this._pointSW.toString();
    }


    /**
     * Calculates the perimeter of the rectangle
     *
     * @return The perimeter of the rectangle.
     */
    public int getPerimeter() {
        return (2 * this._width) + (2 * this._height); // perimeter = 2*width + 2*height
    }

    /**
     * Calculates the area of the rectangle
     *
     * @return The area of the rectangle.
     */
    public int getArea() {
        return this._width * this._height; // area = width * height
    }

    /**
     * Move the rectangle by deltaX in x direction and deltaY in y direction
     *
     * @param deltaX translate the rectangle deltaX in the x direction.
     * @param deltaY translate the rectangle deltaY in the y direction.
     */
    public void move(int deltaX, int deltaY) {
        // moving the rectangle by moving its origin Point (point sw)
        this._pointSW.move(deltaX, deltaY);
    }

    /**
     * Returns true iff the given rectangle is equal to this rectangle
     *
     * @param other the rectangle to check equality with
     * @return true iff other and this rectangle are equal
     */
    public boolean equals(RectangleA other) {
        // comparing all properties
        return ((this._width == other.getWidth()) && (this._height == other.getHeight()) && (this._pointSW.equals(other.getPointSW())));
    }

    /**
     * Returns the length of the rectangle diagonal
     *
     * @return the length of the diagonal of the Rectangle
     */
    public double getDiagonalLength() {
        // calculating the distance between south-west , north-east corners
        Point ne = new Point(this._pointSW.getX() + this._width, this._pointSW.getY() + this._height);
        return this._pointSW.distance(ne);
    }

    /**
     * Returns true if the current rectangle is larger than the parameter rectangle
     *
     * @param other another Rectangle to compare with
     * @return true - if the current Rectangle's area is larger than the other Rectangle which recieved as parameter, false - otherwise
     */
    public boolean isLarger(RectangleA other) {
        // check if this rectangle area is bigger then a given one
        return this.getArea() > other.getArea();
    }

    /**
     * the North-East point of the rectangle
     *
     * @return a copy of the North-East point of the Rectangle
     */
    public Point getPointNE() {
        return new Point(this._pointSW.getX() + this._width, this._pointSW.getY() + this._height);
    }

    /**
     * Changes the width to height and vice versa
     */
    public void changeSides() {
        // flipping width and height
        int height = this._height;
        this._height = this._width;
        this._width = height;
    }

    /**
     * Returns true if the current rectangle is in the parameter rectangle
     *
     * @param r another Rectangle to check with
     * @return if the current Rectangle's completly in the other Rectangle which recieved as parameter, false - otherwise
     */
    public boolean isIn(RectangleA r) {
        if (this._pointSW.isLeft(r.getPointSW()) || this._pointSW.isUnder(r.getPointSW())) {
            return false;
        }
        return !this.getPointNE().isRight(r.getPointNE()) && !this.getPointNE().isAbove(r.getPointNE());
    }

    /**
     * Returns true if the current rectangle overlaps with the parameter rectangle
     *
     * @param r another Rectangle to check with
     * @return true - if the current Rectangle's overlaps with the other Rectangle which recieved as parameter even by a single point, false - otherwise
     */
    public boolean overlap(RectangleA r) {
        // checking if r.getX() is between this PointSW and this Point NE or the other way
        boolean rInThisXAxios = valueInRange(r.getPointSW().getX(), this._pointSW.getX(), this.getPointNE().getX());
        boolean thisInRXAxios = valueInRange(this._pointSW.getX(), r.getPointSW().getX(), r.getPointNE().getX());
        boolean overlapXAxios = rInThisXAxios || thisInRXAxios;

        // checking if r.getY() is between this PointSW and this Point NE or the other way
        boolean rInThisYAxios = valueInRange(r.getPointSW().getY(), this._pointSW.getY(), this.getPointNE().getY());
        boolean thisInRYAxios = valueInRange(this._pointSW.getY(), r.getPointSW().getY(), r.getPointNE().getY());
        boolean overlapYAxios = rInThisYAxios || thisInRYAxios;

        // overlap should exist in both x & y-axis
        return overlapXAxios && overlapYAxios;
    }

    private boolean valueInRange(int value, int min, int max) {
        return (value >= min) && (value <= max);
    }

    // endregion
}
