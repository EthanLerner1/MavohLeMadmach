package Maman15;

/**
 * Class RectNode.
 *
 * @author Ethan Lerner
 * @version 22/01/2022
 */
public class RectList {
    // properties
    private RectNode _head;

    /**
     * default constructor. sets head to null
     */
    public RectList() {
        this._head = null;
    }

    /**
     * add rectNode to the list from a given rectangle
     * complexity: time: o(n) (n is the number of nodes in the list), space: O(1)
     *
     * @param r rectangle to copy inside to next node
     */
    public void addRect(RectangleA r) {
        // check if null
        if (this._head == null) {
            this._head = new RectNode(r);
            return;
        }
        // holding pointers
        RectNode previousNode = this._head;
        RectNode currentNode = this._head;
        // going over the list
        while (currentNode != null) {
            if (!currentNode.getRect().equals(r)) { // checking that the current rectangle doesn't exist already in the list
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            } else {
                return;
            }
        }
        // set next
        previousNode.setNext(new RectNode(r));
    }

    /**
     * counties how many rectangle have this sw point
     * complexity: time: o(n) (n is the number of nodes in the list), space: O(1)
     *
     * @param p point to check
     * @return found amount
     */
    public int howManyWithPoint(Point p) {
        // init counter
        int cnt = 0; // holding pointer
        RectNode currentNode = this._head;
        // going over the list
        while (currentNode != null) {
            if (currentNode.getRect().getPointSW().equals(p)) {
                cnt++;// point found
            }
            currentNode = currentNode.getNext();
        }
        return cnt;
    }

    /**
     * this function finds the longest diagonal in the list
     * complexity: time: o(n) , space: O(n), (n is the number of nodes in the list)
     *
     * @return length of longest diagonal
     */
    public double longestDiagonal() {
        // default return value is 0 (if this list is empty)
        double longestDiagonal = 0;
        // start go over the list and check what is the longest diagonal
        RectNode currentNode = this._head;
        while (currentNode != null) {
            // get current rectangle diagonal length
            double currentRectDiagonal = currentNode.getRect().getDiagonalLength();
            // check if current rectangle diagonal length is bigger then the biggest one yet.
            if (currentRectDiagonal > longestDiagonal) {
                // if so, set it the current rectangle diagonal length
                longestDiagonal = currentRectDiagonal;
            }
            // continue go over the list
            currentNode = currentNode.getNext();
        }
        return longestDiagonal;
    }

    /**
     * checks who have the left most point
     * complexity: time: o(n) , space: O(n), (n is the number of nodes in the list)
     *
     * @return left most sw point
     */
    public Point mostLeftRect() {
        // check that the list is not empty
        if (this._head == null)
            return null;
        // find the leftmost Point
        Point leftmostSWPoint = this._head.getRect().getPointSW();
        RectNode currentNode = this._head;
        while (currentNode != null) {
            // get current node rectangles SW point
            Point currentNodePoint = currentNode.getRect().getPointSW();
            // checking if the current point is left to the previews leftmost point
            if (currentNodePoint.isLeft(leftmostSWPoint)) {
                // if so set the new leftmost point
                leftmostSWPoint = currentNodePoint;
            }
            // continue to go over the list
            currentNode = currentNode.getNext();
        }
        // return a copy of the leftmost copy
        return new Point(leftmostSWPoint);
    }

    /**
     * retrieves the NE point of the highest rect
     * complexity: time: o(n) , space: O(n), (n is the number of nodes in the list)
     *
     * @return highest NE Point
     */
    public Point highestRect() {
        // check that the list is not empty
        if (this._head == null)
            return null;
        // find the leftmost Point
        Point highestNEPoint = this._head.getRect().getPointNE();
        RectNode currentNode = this._head;
        while (currentNode != null) {
            // get current node rectangles SW point
            Point currentNodePoint = currentNode.getRect().getPointNE();
            // checking if the current point is left to the previews leftmost point
            if (currentNodePoint.isAbove(highestNEPoint)) {
                // if so set the new leftmost point
                highestNEPoint = currentNodePoint;
            }
            // continue to go over the list
            currentNode = currentNode.getNext();
        }
        // return a copy of the leftmost copy
        return new Point(highestNEPoint);
    }

    /**
     * retrieves the SW point of the lowest rect
     * complexity: time: o(n) , space: O(n), (n is the number of nodes in the list)
     *
     * @return lowest SW Point
     */
    private Point lowestPoint() {
        // check that the list is not empty
        if (this._head == null)
            return null;
        // find the leftmost Point
        Point lowestPoint = this._head.getRect().getPointSW();
        RectNode currentNode = this._head;
        while (currentNode != null) {
            // get current node rectangles SW point
            Point currentNodePoint = currentNode.getRect().getPointSW();
            // checking if the current point is left to the previews leftmost point
            if (currentNodePoint.isUnder(lowestPoint)) {
                // if so set the new leftmost point
                lowestPoint = currentNodePoint;
            }
            // continue to go over the list
            currentNode = currentNode.getNext();
        }
        // return a copy of the leftmost copy
        return new Point(lowestPoint);
    }

    /**
     * checks who have the right most point
     * complexity: time: o(n) , space: O(n), (n is the number of nodes in the list)
     *
     * @return left most NE point
     */
    private Point mostRightPoint() {
        // check that the list is not empty
        if (this._head == null)
            return null;
        // find the leftmost Point
        Point rightmostPoint = this._head.getRect().getPointNE();
        RectNode currentNode = this._head;
        while (currentNode != null) {
            // get current node rectangles SW point
            Point currentNodePoint = currentNode.getRect().getPointNE();
            // checking if the current point is left to the previews leftmost point
            if (currentNodePoint.isRight(rightmostPoint)) {
                // if so set the new leftmost point
                rightmostPoint = currentNodePoint;
            }
            // continue to go over the list
            currentNode = currentNode.getNext();
        }
        // return a copy of the leftmost copy
        return new Point(rightmostPoint);
    }

    /**
     * retrieves the minimal rectangle that contains all of the rectangles in the list
     * complexity: time: o(n) , space: O(n), (n is the number of nodes in the list)
     *
     * @return minimal rectangle that contains all of the rectangles in the list
     */
    public RectangleA minimalContainer() {
        // check if list is empty
        if (this._head == null)
            return null;

        // get borders for calculations
        Point leftmostPoint = this.mostLeftRect();
        Point rightmostPoint = this.mostRightPoint();
        Point highestPoint = this.highestRect();
        Point lowestPoint = this.lowestPoint();


        // calculations:
        int width = rightmostPoint.getX() - leftmostPoint.getX();
        int height = highestPoint.getY() - lowestPoint.getY();
        Point SW = new Point(leftmostPoint.getX(), lowestPoint.getY());

        // create rectangle and return it
        return new RectangleA(SW, width, height);
    }

    /**
     * to string funciton for the rectLIst
     * complexity: time: o(n) , space: O(n),(n is the number of nodes in the list)
     *
     * @return string representations
     */
    public String toString() {
        int nodeCnt = 0;
        String rectanglesDetails = "";
        RectNode currentNode = this._head;

        while (currentNode != null) {
            // create current node description
            String line = (nodeCnt + 1) + ". " + currentNode.getRect().toString() + "\n";
            rectanglesDetails += line;
            // continue counting
            nodeCnt++;
            // continue iterating over the list
            currentNode = currentNode.getNext();
        }
        return "The list has " + nodeCnt + " rectangles.\n" + rectanglesDetails;
    }
}
