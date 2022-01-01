package Maman15;


public class RectNode {
    private RectangleA _rect;
    private RectNode _next;

    public RectNode(RectangleA r) {
        this._rect = new RectangleA(r);
        this._next = null;
    }

    public RectNode(RectangleA r, RectNode n) {
        this._rect = new RectangleA(r);
        this._next = n;
    }

    public RectNode(RectNode r) {
        this._rect = new RectangleA(r._rect);
        this._next = r._next;
    }

    public RectangleA getRect(){
        return new RectangleA(this._rect);
    }

    public RectNode getNext(){
        return this._next;
    }

    public void setRect(RectangleA r){
        this._rect = new RectangleA(r);
    }

    public void setNext(RectNode next){
        this._next = next;
    }
}
