package com.hexgame.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GameModel extends Application {
    private static final int SIZE_GAME_FIVE = 5;
    private static final int SIZE_GAME_ELEVEN = 11;
    private static final int SIZE_GAME_SEVENTEEN = 17;
    private static final double RIM_SIZE_FIVE = 40.0;
    private static final double RIM_SIZE_ELEVEN = 35.0;
    private static final double RIM_SIZE_SEVENTEEN = 28.0;
    GamePanel panel = new GamePanel();
    private Label winLabel = panel.winnerLabel;
    private Label turnLabel = panel.turnLbl;
    private ImageView imV = panel.imageView;

    private int size;
    private double rim;


    @Override
    public void start(Stage stage) throws Exception {
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioButton1 = buildRadioButton("5 x 5", toggleGroup);
        RadioButton radioButton2 = buildRadioButton("11 x 11", toggleGroup);
        RadioButton radioButton3 = buildRadioButton("17 x 17", toggleGroup);

        Button btn = buildStartButton();
        imV.setVisible(false);

        StackPane stackPane = new StackPane(turnLabel);
        stackPane.setAlignment(Pos.CENTER);

        Region spacer = new Region();
        HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);


        VBox vBox = new VBox(1, winLabel, stackPane);
        HBox hBox = new HBox(20, radioButton1, radioButton2, radioButton3, btn, spacer, vBox, imV);
        hBox.setPadding(new Insets(0, 10, 10, 20));
        hBox.setAlignment(Pos.BOTTOM_LEFT);


        radioButton1.setOnAction(event_r -> {
            size = SIZE_GAME_FIVE;
            rim = RIM_SIZE_FIVE;
        });
        radioButton2.setOnAction(event_r -> {
            size = SIZE_GAME_ELEVEN;
            rim = RIM_SIZE_ELEVEN;

        });
        radioButton3.setOnAction(event_r -> {
            size = SIZE_GAME_SEVENTEEN;
            rim = RIM_SIZE_SEVENTEEN;
        });


        btn.setOnMouseClicked(event -> {
            if (size > 0) {
                panel.operationHex(size, rim);
                winLabel.setText("");
                turnLabel.setText("");
                imV.setVisible(false);
            }
        });


        BorderPane root = new BorderPane();
        root.setBottom(hBox);
        root.setCenter(panel.getRoot());


        stage.setScene(new Scene(root, 1500, 900));
        stage.setTitle("JavaFX Hex Game");
        stage.show();
    }

    private RadioButton buildRadioButton(String txt, ToggleGroup tg) {
        RadioButton radioButton = new RadioButton(txt);
        radioButton.setToggleGroup(tg);
        radioButton.setStyle("-fx-font-size : 18px; -fx-pref-width: 90;");
        return radioButton;
    }

    private Button buildStartButton() {
        Button btn = new Button("Start Game");
        btn.setStyle("-fx-background-color: #0000FF; -fx-text-fill: white;");
        btn.setPrefWidth(150); // Set the preferred width of the button
        btn.setPrefHeight(30);
        return btn;
    }
}

