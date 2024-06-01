package com.hexgame.model;



public class HexNode {
    private NodeColor color;
    private int row;
    private int cal;
    private HexNode upLeft;
    private HexNode upRight;
    private HexNode downleft;
    private HexNode downRight;
    private HexNode left;
    private HexNode right;


    public HexNode(int row, int cal) {
        this.row = row;
        this.cal = cal;
        upLeft =null;
        upRight =null;
        downRight =null;
        downleft =null;
        left =null;
        right = null;
        color = NodeColor.NULL;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public HexNode getUpLeft() {
        return upLeft;
    }

    public void setUpLeft(HexNode upLeft) {
        this.upLeft = upLeft;
    }

    public HexNode getUpRight() {
        return upRight;
    }

    public void setUpRight(HexNode upRight) {
        this.upRight = upRight;
    }

    public HexNode getDownRight() {
        return downRight;
    }

    public void setDownRight(HexNode downRight) {
        this.downRight = downRight;
    }

    public HexNode getDownleft() {
        return downleft;
    }

    public void setDownleft(HexNode downleft) {
        this.downleft = downleft;
    }

    public HexNode getLeft() {
        return left;
    }

    public void setLeft(HexNode left) {
        this.left = left;
    }

    public HexNode getRight() {
        return right;
    }

    public void setRight(HexNode right) {
        this.right = right;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }
}
