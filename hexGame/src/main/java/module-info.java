module com.hexgame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.hexgame.view to javafx.graphics;
}