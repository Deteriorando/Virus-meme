package dete.application.virus.controller;

import dete.application.virus.User.UserIP;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class StagesManager {
    private static StagesManager instance;
    private static final List<Stage> onStages = new ArrayList<>();

    private StagesManager(){

    }

    public static StagesManager getInstance() {
        if (instance == null) instance = new StagesManager();
        return instance;
    }

    public void newStage(){
        Stage stage = new Stage();
        UserIP userIP = new UserIP();
        MovimentStage move = new MovimentStage();
        StackPane layout = new StackPane();
        PaneController paneController = new PaneController();


        layout.getChildren().add(new Label("Vírus..."));
        layout.getChildren().add(new Label(userIP.getIp()));
        layout.setOnMouseEntered(mouseEvent -> move.randomPosition(stage));
        paneController.randomColor(layout);

        stage.setTitle("Vírus!");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(paneController.randomScaleScreen(layout));
        addStage(stage);
        stage.show();
    }

    public void addStage(Stage stage){
        onStages.add(stage);
    }

    public void removeStage(Stage stage){
        onStages.remove(stage);
    }

    public void closeAllStagesDelay(double delay){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(delay), event -> {
            if (!onStages.isEmpty()) {
                // Pega a primeira janela da lista
                Stage onStagesFirst = onStages.getFirst();
                onStagesFirst.close();
                onStages.removeFirst();
                System.out.println("Uma janela foi fechada. Restam: " + onStages.size());
            }
        }));

        // Define para rodar o número de vezes igual à quantidade de janelas
        timeline.setCycleCount(onStages.size());
        timeline.play();
    }

    public List<Stage> getAllStages(){
        return onStages;
    }
}
