package com.hexgame.model;


public class HexTable {
    private final int row;
    private final int col;
    private HexNode[][] tableNode;
    private TableController controller;

    public HexTable(int row, int col) {
        this.row = row;
        this.col = col;
        tableNode = createTable(this.row, this.col);
        connectTable(this.row, this.col);
        controller = new TableController();
    }

    private HexNode[][] createTable(int row, int col) {
        tableNode = new HexNode[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                HexNode node = new HexNode(i, j);
                node.setColor(NodeColor.NULL);
                tableNode[i][j] = node;
            }
        }
        return tableNode;
    }

    private void connectTable(int row, int col) {
        // Komşuları bağlama
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (x > 0) {
                    tableNode[x][y].setUpLeft(tableNode[x - 1][y]);
                    if (y < col - 1) {
                        tableNode[x][y].setUpRight(tableNode[x - 1][y + 1]);
                    }
                }
                if (x < row - 1) {
                    if (y > 0) {
                        tableNode[x][y].setDownleft(tableNode[x + 1][y - 1]);
                    }
                    tableNode[x][y].setDownRight(tableNode[x + 1][y]);
                }
                if (y > 0) {
                    tableNode[x][y].setLeft(tableNode[x][y - 1]);
                }
                if (y < col - 1) {
                    tableNode[x][y].setRight(tableNode[x][y + 1]);
                }
            }
        }
    }

    public boolean work(int row, int col, String color) {
        if (color.equals("WHITE")) {
            if (controller.processIslem(tableNode, row, col, NodeColor.WHITE))
                return controller.isWinner(tableNode, NodeColor.WHITE);
        } else if (color.equals("BLACK")) {
            if (controller.processIslem(tableNode, row, col, NodeColor.BLACK))
                return controller.isWinner(tableNode, NodeColor.BLACK);
        }
        return false;
    }


}
