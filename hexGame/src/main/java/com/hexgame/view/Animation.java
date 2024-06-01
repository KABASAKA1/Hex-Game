package com.hexgame.view;

import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class Animation {

    public void ColorTransfer(Polygon polygon, boolean isWhite) {
        if (polygon.isDisabled()) {
            return;
        }

        FillTransition fillTransition = new FillTransition(Duration.seconds(1), polygon);
        fillTransition.setFromValue(Color.GREY);
        if (isWhite) {
            fillTransition.setToValue(Color.WHITE);
        } else {
            fillTransition.setToValue(Color.BLACK);
        }
        polygon.setDisable(true);
        fillTransition.play();
    }

    public void rotatePolygon (Polygon polygon){
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.5), polygon);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(1);
        rotateTransition.play();
    }
}