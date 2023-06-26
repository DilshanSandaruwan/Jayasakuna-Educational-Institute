package lk.ijse.Jayasakuna.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ForgotPasswordFormController {
    @FXML
    private AnchorPane forgotpane;

    @FXML
    private Hyperlink link;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label lblLink;

    public void linkonAction(ActionEvent actionEvent) throws URISyntaxException,IOException {

    }

    @FXML
    void CancelOnPress(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Loging-form.fxml"));
        Pane pane = fxmlLoader.load();
        try {
            forgotpane.getChildren().clear();
            forgotpane.getChildren().setAll(pane);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}



