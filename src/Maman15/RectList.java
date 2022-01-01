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
        RectNode currentNode = this._head;
        while (currentNode.getNext() != null) {
            if (!currentNode.getRect().equals(r)) {
                currentNode = currentNode.getNext();
            } else {
                return;
            }
        }
        currentNode.setNext(new RectNode(r));
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
}
