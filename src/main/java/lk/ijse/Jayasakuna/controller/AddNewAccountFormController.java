package lk.ijse.Jayasakuna.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Jayasakuna.bo.BoFactory;
import lk.ijse.Jayasakuna.bo.custom.AddnewAccountBO;
import lk.ijse.Jayasakuna.bo.custom.impl.AddnewAccountBOImpl;
import lk.ijse.Jayasakuna.dto.AddnewAccountDTO;

import java.sql.SQLException;

public class AddNewAccountFormController {

    @FXML
    private AnchorPane AddAccountPane;

    @FXML
    private JFXButton btnSave;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtRetypePassword;

    @FXML
    private TextField txtpassword;

    AddnewAccountBO addnewAccountBO = BoFactory.getBoFactory().getBo(BoFactory.BOTypes.AddnewAccount_BO);

    @FXML
    void SaveOnPress(ActionEvent event) throws SQLException {
        String name = txtName.getText();
        String password = txtpassword.getText();
        String retypPassword = txtRetypePassword.getText();

        // Check if the password and retype password fields match
        if (!password.equals(retypPassword)) {
            // Show an error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Password Mismatch");
            alert.setHeaderText("The passwords entered do not match.");
            alert.setContentText("Please enter matching passwords.");
            alert.showAndWait();
            return;
        }
        AddnewAccountDTO addnewAccountDTO = new AddnewAccountDTO(name,password);
        if (addnewAccountBO.addUser(addnewAccountDTO)) {
            // Show a success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("UserDTO Added");
            alert.setHeaderText("New user added successfully.");
            alert.setContentText("The new user has been added to the system.");
            alert.showAndWait();
        }
        else {
            // Show an error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("UserDTO Not Added");
            alert.setHeaderText("Error adding new user.");
            alert.setContentText("Please check the input data and try again.");
            alert.showAndWait();
        }
    }

    private String original = "-fx-background-color: #fefae0; -fx-border-radius: 10; -fx-background-radius: 10;";
    private String fake = "-fx-background-color: #0081a7; -fx-text-fill: white; -fx-background-radius: 10; -fx-border-radius: 10; -fx-cursor: hand;";
    @FXML
    void SaveOnMouseEntered(MouseEvent event) {
        btnSave.setStyle(fake);
    }

    @FXML
    void SaveOnMouseExi(MouseEvent event) {
        btnSave.setStyle(original);
    }

}
