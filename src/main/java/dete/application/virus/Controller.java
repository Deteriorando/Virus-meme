package dete.application.virus;

import dete.application.virus.User.UserIP;
import dete.application.virus.controller.StagesManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class Controller {
    @FXML private Label ipText;
    @FXML private Label yourIpText;
    private final UserIP userIP = new UserIP();

    private static final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.2), _ -> onVirus()));

    @FXML
    protected void getIpOnClick(){
        yourIpText.setVisible(true);
        ipText.setVisible(true);
        ipText.setText(userIP.getIp());
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    protected static void onVirus(){
        StagesManager.getInstance().newStage();
    }

    public static Timeline getTimeline() {
        return timeline;
    }
}
