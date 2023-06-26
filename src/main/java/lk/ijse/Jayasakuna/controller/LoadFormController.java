package lk.ijse.Jayasakuna.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class LoadFormController {
    private static final Notifications notification = Notifications.create();

    @FXML
    private Label lblTxt1;

    @FXML
    private Label lblTxt2;

    public void initialize() {
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            lblTxt1.setText("System Running");
        }));

        Timeline time1 = new Timeline(new KeyFrame(Duration.seconds(4), e -> {
            lblTxt2.setText("Almost there .....");
        }));

        time.play();
        time1.play();

        notification.title("Jayasakuna")
                .text("OTP confirmation success ! . Wait for run the system !")
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);
        notification.show();

    }

}
