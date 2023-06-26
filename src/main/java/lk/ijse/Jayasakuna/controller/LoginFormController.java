package lk.ijse.Jayasakuna.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;

public class LoginFormController {

 @FXML
 private Button btnLogin;

 @FXML
 private AnchorPane root;

 @FXML
 private Label lblError1;

 @FXML
 private Label lblError2;

 @FXML
 private TextField txtPassword;

 @FXML
 private TextField txtUsername;

 private int loginAttempts = 5;
 private boolean isLockedOut = false;

 @FXML
 void txtPasswordOnKeyPressed(KeyEvent event) {
  validate(event);
 }

 @FXML
 void txtUsernameOnKeyPressed(KeyEvent event) {
  validate(event);
 }


 @FXML
 void btnLoginOnAction(ActionEvent event) throws IOException {
  String userName = txtUsername.getText();
  String password = txtPassword.getText();

  if (txtPassword.getText().isBlank() && txtUsername.getText().isBlank()) {
   lblError1.setText("Please provide UserDTO Name and Password .          ");
   Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
    lblError1.setText("");
   }));
   timeline.play();
   return;
  }

  if (txtUsername.getText().isBlank()) {
   lblError2.setText("Please provide UserDTO name on UserDTO name Field .    ");
   Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
    lblError2.setText("");
   }));
   timeline.play();
   return;
  }

  if (txtPassword.getText().isBlank()) {
   lblError1.setText("Please provide Password on Password Field .      ");
   Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
    lblError1.setText("");
   }));
   timeline.play();
   return;
  }

  if (isCredentialsValid(userName, password)) {
   AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/OTP-form.fxml"));

   Scene scene = new Scene(anchorPane);

   Stage stage = (Stage)root.getScene().getWindow();
   stage.setScene(scene);
   stage.setTitle("OTP Confirmation");
   stage.centerOnScreen();

  } else {
   lblError1.setText("Incorrect username or password! ");

   Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
    lblError1.setText("");
   }));
   timeline.play();
   txtPassword.clear();
   txtUsername.clear();
  }
 }

 private boolean isCredentialsValid(String userName, String password) {
  if (userName.equals("user") && password.equals("pass")) {
   return true;
  } else {
   return false;
  }
 }

 private void validate(KeyEvent event){
  if (event.getCode() == KeyCode.ENTER) {
   if (txtPassword.getText().isBlank() && txtUsername.getText().isBlank()) {
    lblError1.setText("Please provide UserDTO Name and Password .          ");
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
     lblError1.setText("");
    }));
    timeline.play();
    return;
   }

   if (txtUsername.getText().isBlank()) {
    lblError2.setText("Please provide UserDTO name on UserDTO name Field .    ");
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
     lblError2.setText("");
    }));
    timeline.play();
    return;
   }

   if (txtPassword.getText().isBlank()) {
    lblError1.setText("Please provide Password on Password Field .      ");
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
     lblError1.setText("");
    }));
    timeline.play();
    return;
   }
   btnLogin.fire();
  }
 }
}