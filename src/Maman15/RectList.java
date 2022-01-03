package Maman15;

public class RectList {
    private RectNode _head;

    public RectList() {
        this._head = null;
    }

    public void addRect(RectangleA r) {
        if (this._head == null) {
            this._head = new RectNode(r);
            return;
        }
        RectNode previousNode = this._head;
        RectNode currentNode = this._head;
        while (currentNode != null) {
            if (!currentNode.getRect().equals(r)) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            } else {
                return;
            }
        }
        previousNode.setNext(new RectNode(r));
    }

    public int howManyWithPoint(Point p) {
        int cnt = 0;
        RectNode currentNode = this._head;
        while (currentNode != null) {
            if (currentNode.getRect().getPointSW().equals(p)) {
                cnt++;
            }
            currentNode = currentNode.getNext();
        }
        return cnt;
    }

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
