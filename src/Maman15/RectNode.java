package Maman15;

/**
 * Class RectNode.
 *
 * @author Ethan Lerner
 * @version 22/01/2022
 */
public class RectNode {
    // properties
    private RectangleA _rect;
    private RectNode _next;

    /**
     * constructor. inits a new rect node with a given rectangle
     * complexity: time:O(1), space: O(1)
     * @param r rectangle for this node property
     */
    public RectNode(RectangleA r) {
        this._rect = new RectangleA(r);
        this._next = null;
    }

    /**
     * constructor. inits current rect and next node.
     * complexity: time: o(1), space: O(1)
     * @param r rectangle to init
     * @param n next node to init
     */
    public RectNode(RectangleA r, RectNode n) {
        this._rect = new RectangleA(r);
        this._next = n;
    }

    /**
     * copy constructor
     * complexity: time: o(1), space: O(1)
     * @param r node to copy from
     */
    public RectNode(RectNode r) {
        this._rect = new RectangleA(r._rect);
        this._next = r._next;
    }

    /**
     * getter for current node rect
     * complexity: time: o(1), space: O(1)
     * @return new rectangle
     */
    public RectangleA getRect(){
        return new RectangleA(this._rect);
    }

    /**
     * get next rectNode
     * complexity: time: o(1), space: O(1)
     * @return Rectangle node
     */
    public RectNode getNext(){
        return this._next;
    }

    /**
     * set current node rectangle
     * complexity: time: o(1), space: O(1)
     * @param r rectangle to copy from
     */
    public void setRect(RectangleA r){
        this._rect = new RectangleA(r);
    }

    /**
     * set next rectNode pointer
     * complexity: time: o(1), space: O(1)
     * @param next rectNode pointer
     */
    public void setNext(RectNode next){
        this._next = next;
    }
}
