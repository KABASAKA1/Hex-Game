package com.hexgame.model;


import java.util.HashSet;
import java.util.Set;

public class TableController {

    public boolean processIslem(HexNode[][] tableNode, int rows, int cols, NodeColor color) {
        if (tableNode[rows][cols].getColor()==NodeColor.NULL) {
            tableNode[rows][cols].setColor(color);
            return true;
        }else
            return false;
    }
    public boolean isWinner(HexNode[][] tableNode, NodeColor color) {
        int rows=tableNode.length;
        int cols=tableNode[0].length;
        if(color==NodeColor.WHITE){
            for(int i=0;i<cols;i++){
                if (tableNode[0][i].getColor()==NodeColor.WHITE) {
                    //aşşağıya doğru ağaç oluşturup en alttaki dizeye kadar mavi ise true yani winner dönecek
                    return traverseWhite(tableNode[0][i],rows,cols, new HashSet<>());
                }
            }
        }if(color==NodeColor.BLACK){
            for(int i=0;i<rows;i++){
                if (tableNode[i][0].getColor()==NodeColor.BLACK) {
                    //sağa kadar ağaç oluşturyp en sağdaki ağaca gelen yaprak varsa true yani winner dönecek
                    return traverseBlack(tableNode[i][0],rows,cols, new HashSet<>());
                }
            }
        }


        return false;
    }

    private boolean traverseWhite(HexNode node, int rows, int cols, Set<HexNode> visited ) {
        if (node.getRow()==rows -1)
            return true;
        visited.add(node);
        if (node.getLeft()!=null && node.getLeft().getColor()==NodeColor.WHITE && !visited.contains(node.getLeft())) {
            if (traverseWhite(node.getLeft(), rows, cols, visited ))
                return true;
        }
        if (node.getRight()!=null && node.getRight().getColor()==NodeColor.WHITE && !visited.contains(node.getRight())) {
            if (traverseWhite(node.getRight(), rows, cols, visited))
                return true;
        }
        if (node.getDownleft()!=null && node.getDownleft().getColor()==NodeColor.WHITE && !visited.contains(node.getDownleft())) {
            if (traverseWhite(node.getDownleft(), rows, cols, visited))
                return true;
        }
        if (node.getDownRight()!=null && node.getDownRight().getColor()==NodeColor.WHITE && !visited.contains(node.getDownRight())){
            if (traverseWhite(node.getDownRight(), rows, cols, visited))
                return true;
        }

        return false;
    }
    private boolean traverseBlack(HexNode node, int rows, int cols, Set<HexNode> visited ) {
        if (node.getCal()==cols -1)
            return true;
        visited.add(node);
        if (node.getUpLeft()!=null && node.getUpLeft().getColor()==NodeColor.BLACK && !visited.contains(node.getUpLeft())) {
            if (traverseBlack(node.getUpLeft(), rows, cols, visited))
                return true;

        }
        if (node.getUpRight()!=null && node.getUpRight().getColor()==NodeColor.BLACK && !visited.contains(node.getUpRight())) {
            if (traverseBlack(node.getUpRight(), rows, cols, visited))
                return true;

        }
        if (node.getRight()!=null && node.getRight().getColor()==NodeColor.BLACK && !visited.contains(node.getRight())) {
            if (traverseBlack(node.getRight(), rows, cols, visited))
                return true;
        }
        if (node.getDownRight()!=null && node.getDownRight().getColor()==NodeColor.BLACK && !visited.contains(node.getDownRight())) {
            if (traverseBlack(node.getDownRight(), rows, cols, visited))
                return true;
        }

        return false;
    }
}











