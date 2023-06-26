package lk.ijse.Jayasakuna.controller;


import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.Jayasakuna.email.Email;

import java.io.IOException;
import java.util.regex.Pattern;


public class OTPFormController {

    private static int otp ;
    static {
        otp = email();
    }
    @FXML
    private JFXButton btnConform;

    @FXML
    private Label lblError;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtOtp;

    @FXML
    void btnOnAction(ActionEvent event) throws IOException {
        if (!validateInput(otp)) {
            return;
        }
    }

    private boolean validateInput(int otp) throws IOException {
        String otp1 = String.valueOf(otp);

        String otp2 = "";
        if (!Pattern.matches("^\\d{6}$", txtOtp.getText())) {
            Platform.runLater(() -> printLabel("Please enter a 6 digit OTP"));
            return false;
        }else if(!otp1.equals(txtOtp.getText())){
            Platform.runLater(() -> printLabel("Please enter correct OTP"));
            return false;
        }else if(otp1.equals("")){
            Platform.runLater(() -> printLabel("Please enter a 6 digit OTP"));
            return false;
        }else{
            show();
            return true;
        }
    }

    private void show() throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Load-form.fxml"));

        Scene scene = new Scene(anchorPane);

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Wait");
        stage.centerOnScreen();


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(6), e -> {
            try {
                AnchorPane loginAnchorPane = FXMLLoader.load(getClass().getResource("/view/Homepage-form.fxml"));
                Scene loginScene = new Scene(loginAnchorPane);
                stage.setScene(loginScene);
                stage.setTitle("Dash Board");
                stage.centerOnScreen();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }));
        timeline.play();
    }

    private void printLabel(String text) {
        lblError.setText(text);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(() -> lblError.setText(""));
                    }
                },
                2000
        );
    }

    public static int email(){
        int random = Email.firstOtp();
        return random;
    }
}
