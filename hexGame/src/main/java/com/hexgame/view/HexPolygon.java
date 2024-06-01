package com.hexgame.view;

import javafx.scene.shape.Polygon;

public class HexPolygon extends Polygon {
    int rows;
    int cols;
    HexColor color;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public HexColor getColor() {
        return color;
    }

    public void setColor(HexColor color) {
        this.color = color;
    }

    public HexPolygon() {
        super();
        this.rows = rows;
        this.cols = cols;
        color=HexColor.NULL;
    }
}
