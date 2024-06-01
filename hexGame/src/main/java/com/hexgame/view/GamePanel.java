package com.hexgame.view;

import com.hexgame.model.HexTable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GamePanel {
    private boolean isWhite = true;
    public Label winnerLabel = new Label("");
    public Label turnLbl = new Label("");
    private Image image = new Image("https://pngimg.com/uploads/game_over/game_over_PNG34.png");
    public ImageView imageView = new ImageView(image);

    BorderPane root = new BorderPane();
    Animation animation = new Animation();
    HexTable hexTable;


    public BorderPane getRoot() {
        return root;
    }


    public void operationHex(int sizeGame, double rimLength) {
        hexTable = new HexTable(sizeGame, sizeGame); //  model tarafını initialize etme

        root.getChildren().removeIf(node -> node instanceof HexPolygon);
        double START_X = 100.0;
        double START_Y = 100.0;
        for (int i = 0; i < sizeGame; i++) {
            for (int j = 0; j < sizeGame; j++) {
                HexPolygon hex = buildHex(START_X + j * rimLength * 1.90, START_Y, rimLength);
                hex.setRows(i);
                hex.setCols(j);
                hex.setRotate(90);
                processMouse(hex);
                root.getChildren().add(hex);
            }
            START_Y = START_Y + rimLength + (rimLength / 2) + 2;
            START_X = START_X + (rimLength / 2) * 1.90;
        }

    }

    private HexPolygon buildHex(double x, double y, double rimLength) {
        HexPolygon hexPolygon = new HexPolygon();
        for (int i = 0; i <= 5; i++) {
            double angle = Math.toRadians(60 * i);
            double corX = x + (rimLength * Math.cos(angle));
            double corY = y + (rimLength * Math.sin(angle));
            hexPolygon.getPoints().addAll(corX, corY);
        }
        hexPolygon.setFill(Color.GREY);
        hexPolygon.setStroke(Color.BLACK);
        hexPolygon.setStrokeWidth(2);
        return hexPolygon;
    }

    int i = 0;
    int j = 0;

    private void processMouse(HexPolygon hexPolygon) {
        hexPolygon.setOnMouseClicked(mouseEvent -> {
            animation.ColorTransfer(hexPolygon, isWhite);
            if (isWhite) {
                i++;
                hexPolygon.setColor(HexColor.WHITE);
                if (hexTable.work(hexPolygon.getRows(), hexPolygon.getCols(), "WHITE")) {
                    setWinnerLabel("White");
                    turnMethod(i);
                    createImageView(imageView);
                    i = 0;
                    j = 0;
                }
            } else {
                j++;
                hexPolygon.setColor(HexColor.BLACK);
                if (hexTable.work(hexPolygon.getRows(), hexPolygon.getCols(), "BLACK")) {
                    setWinnerLabel("Black");
                    turnMethod(j);
                    createImageView(imageView);
                    i = 0;
                    j = 0;
                }
            }
            animation.rotatePolygon(hexPolygon);
            isWhite = !isWhite;
        });
    }

    private void setWinnerLabel(String color) {
        winnerLabel.setText("Game Over: " + color + " Wins");
        winnerLabel.setFont(Font.font(18));
    }

    private void turnMethod(int i) {
        turnLbl.setText("Turn : " + i);
        turnLbl.setFont(Font.font(18));
    }

    private void createImageView(ImageView imageView) {
        imageView.setVisible(true);
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);
        imageView.setPreserveRatio(true);
    }
}


