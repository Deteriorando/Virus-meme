package dete.application.virus.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class MovimentStage {
    public void randomPosition(Stage stage) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Random random = new Random();

        double maxX = screenBounds.getWidth() - stage.getWidth();
        double maxY = screenBounds.getHeight() - stage.getHeight();

        double targetX = screenBounds.getMinX() + (random.nextDouble() * maxX);
        double targetY = screenBounds.getMinY() + (random.nextDouble() * maxY);

        // Criamos propriedades temporárias para animar
        Timeline timeline = getTimeline(stage, targetX, targetY);

        timeline.play();
    }

    private static Timeline getTimeline(Stage stage, double targetX, double targetY) {
        DoubleProperty xAnim = new SimpleDoubleProperty(stage.getX());
        DoubleProperty yAnim = new SimpleDoubleProperty(stage.getY());

        // Ouvintes que atualizam a posição real do Stage conforme a animação acontece
        xAnim.addListener((obs, oldVal, newVal) -> stage.setX(newVal.doubleValue()));
        yAnim.addListener((obs, oldVal, newVal) -> stage.setY(newVal.doubleValue()));

        return new Timeline(
                new KeyFrame(Duration.millis(500),
                        new KeyValue(xAnim, targetX),
                        new KeyValue(yAnim, targetY)
                )
        );
    }
}
