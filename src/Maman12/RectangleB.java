package Maman12;

/**
 * Class RectangleB.
 *
 * @author Ethan Lerner
 * @version 20/11/2021
 */
public class RectangleB {
    // region ----- Properties -----
    private Point _pointSW;
    private Point _pointNE;
    // endregion

    // region ----- Constructors -----

    /**
     * First constructor for objects of class RectangleB Constructs a new rectangle with the specified width, height and it's south west corner is (0,0)
     *
     * @param w The rectangle width
     * @param h The rectangle height
     */
    public RectangleB(int w, int h) {
        // default values
        final int DEFAULT_WIDTH = 1;
        final int DEFAULT_HEIGHT = 1;

        this._pointSW = new Point(0, 0); // default value for pointSW
        // validate w,h
        if (w <= 0) {
            w = DEFAULT_WIDTH;
        }
        if (h <= 0) {
            h = DEFAULT_HEIGHT;
        }
        this._pointNE = new Point(w, h);
    }

    /**
     * Second constructor for objects of class RectangleB Constructs a new rectangle with the specified vertices
     *
     * @param p south western vertex
     * @param w rectangle width
     * @param h rectangle height
     */
    public RectangleB(Point p, int w, int h) {
        // default values
        final int DEFAULT_WIDTH = 1;
        final int DEFAULT_HEIGHT = 1;

        // validate w,h
        if (w <= 0) {
            w = DEFAULT_WIDTH;
        }
        if (h <= 0) {
            h = DEFAULT_HEIGHT;
        }

        this._pointSW = new Point(p);
        this._pointNE = new Point(_pointSW.getX() + w, _pointSW.getY() + h);
    }

    /**
     * Third constructor for objects of class RectangleB Constructs a new rectangle with the specified vertices
     *
     * @param sw south western vertex
     * @param ne north eastern vertex
     */
    public RectangleB(Point sw, Point ne) {
        this._pointSW = new Point(sw);
        this._pointNE = new Point(ne);
    }

    /**
     * Copy constructor for objects of class RectangleB Constructs a rectangle using another rectangle
     *
     * @param r The rectangle from which to construct the new object
     */
    public RectangleB(RectangleB r) {
        this._pointSW = new Point(r.getPointSW());
        this._pointNE = new Point(r.getPointNE());
    }

    // endregion

    // region ----- Methods -----

    /**
     * Returns the South-West point of the rectangle
     *
     * @return a copy of the s-w point of the rectangle
     */
    public Point getPointSW() {
        return new Point(_pointSW);
    }

    /**
     * Sets the South-West point of the rectangle. This change affects also the NE Point since the width and height of the rectangle should NOT change
     *
     * @param p the new S-W point of the rectangle
     */
    public void setPointSW(Point p) {
        int width = this._pointNE.getX() - this._pointSW.getX(); // calculate width
        int height = this._pointNE.getY() - this._pointSW.getY(); // calculate height

        this._pointSW = new Point(p);
        // change NE point
        this._pointNE.setX(this._pointSW.getX() + width);
        this._pointNE.setY(this._pointSW.getY() + height);
    }

    /**
     * Returns the North-East point of the rectangle
     *
     * @return a copy of the n-e point of the rectangle
     */
    public Point getPointNE() {
        return new Point(_pointNE);
    }

    /**
     * Sets the North-East point of the rectangle. This change affects also the SW Point since the width and height of the rectangle should NOT change
     *
     * @param p the new N-E point of the rectangle
     */
    public void setPointNE(Point p) {
        this._pointNE = new Point(p);
    }

    /**
     * Returns a string representation of the rectangle
     *
     * @return a string represent the rectangle For example: Width=4 Height=6 PointSW=(1,2)
     */
    public String toString() {
        int width = this._pointNE.getX() - this._pointSW.getX(); // calculate width
        int height = this._pointNE.getY() - this._pointSW.getY(); // calculate height
        return "Width=" + width + " Height=" + height + " PointSW=" + this._pointSW.toString();
    }

    /**
     * Calculates the perimeter of the rectangle
     *
     * @return The perimeter of the rectangle.
     */
    public int getPerimeter() {
        int width = this._pointNE.getX() - this._pointSW.getX(); // calculate width
        int height = this._pointNE.getY() - this._pointSW.getY(); // calculate height
        return width * 2 + height * 2;
    }

    /**
     * Calculates the area of the rectangle
     *
     * @return The area of the rectangle.
     */
    public int getArea() {
        int width = this._pointNE.getX() - this._pointSW.getX(); // calculate width
        int height = this._pointNE.getY() - this._pointSW.getY(); // calculate height
        return width * height;
    }

    /**
     * Move the rectangle by deltaX in x direction and deltaY in y direction
     *
     * @param deltaX translate the rectangle deltaX in the x direction.
     * @param deltaY translate the rectangle deltaY in the y direction.
     */
    public void move(int deltaX, int deltaY) {
        this._pointSW.move(deltaX, deltaY);
        this._pointNE.move(deltaX, deltaY);
    }

    /**
     * Returns the width of the rectangle
     *
     * @return the width of the rectangle
     */
    public int getWidth() {
        return this._pointNE.getX() - this._pointSW.getX(); // calculate width

    }

    /**
     * Returns the height of the rectangle
     *
     * @return the height of the rectangle
     */
    public int getHeight() {
        return this._pointNE.getY() - this._pointSW.getY(); // calculate height
    }

    /**
     * Sets the width of the rectangle
     *
     * @param w the width of the rectangle to set to
     */
    public void setWidth(int w) {
        if (w > 0) // validate input
            // declaring pointNE X coordinate
            this._pointNE.setX(this._pointSW.getX() + w);
    }

    /**
     * Sets the height of the rectangle
     *
     * @param h the width of the rectangle to set to
     */
    public void setHeight(int h) {
        if (h > 0) // validate input
            // declaring pointNE Y coordinate
            this._pointNE.setY(this._pointSW.getY() + h);
    }

    /**
     * Returns true iff the given rectangle is equal to this rectangle
     *
     * @param other the rectangle to check equality with
     * @return true iff other and this rectangle are equal
     */
    public boolean equals(RectangleB other) {
        // checking diff between both properties
        return this._pointNE.equals(other.getPointNE()) &&
                this._pointSW.equals(other.getPointSW());
    }

    /**
     * Returns the length of the rectangle diagonal
     *
     * @return the length of the diagonal of the Rectangle
     */
    public double getDiagonalLength() {
        // diagonal length = distance between pointSW and PointNE
        return this._pointSW.distance(this._pointNE);
    }

    /**
     * Changes the width to height and vice versa
     */
    public void changeSides() {
        int width = this._pointNE.getX() - this._pointSW.getX(); // calculate width
        int height = this._pointNE.getY() - this._pointSW.getY(); // calculate height

        // switch between width and height
        this._pointNE.setX(this._pointSW.getX() + height);
        this._pointNE.setY(this._pointSW.getY() + width);
    }

    /**
     * Returns true if the current rectangle is larger than the parameter rectangle
     *
     * @param other another Rectangle to compare with
     * @return true - if the current Rectangle's area is larger than the other Rectangle which received as parameter, false - otherwise
     */
    public boolean isLarger(RectangleB other) {
        // comparing rectangles areas
        return this.getArea() > other.getArea();
    }

    /**
     * Returns true if the current rectangle is in the parameter rectangle
     *
     * @param r another Rectangle to check with
     * @return if the current Rectangle's completly in the other Rectangle which recieved as parameter, false - otherwise
     */
    public boolean isIn(RectangleB r) {
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
    public boolean overlap(RectangleB r) {
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
