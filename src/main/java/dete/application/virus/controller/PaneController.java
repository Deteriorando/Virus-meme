package dete.application.virus.controller;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

import java.util.Random;

public class PaneController {
    protected static final Random random = new Random();

    public Scene randomScaleScreen(StackPane layout){
        Rectangle2D screen = Screen.getPrimary().getVisualBounds();

        double ScreenX = random.nextDouble() * Math.max(0, screen.getMaxX());
        double ScreenY = random.nextDouble() * Math.max(0, screen.getMaxY());

        Scene scene = new Scene(layout, ScreenX, ScreenY);
        return scene;
    }

    public void randomColor(StackPane pane){
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        pane.setStyle("-fx-background-color: rgb(" + r + "," + g + "," + b + ");");
    }
}
