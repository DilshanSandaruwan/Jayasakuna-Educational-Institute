package lk.ijse.Jayasakuna.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.ijse.Jayasakuna.bo.BoFactory;
import lk.ijse.Jayasakuna.bo.custom.PaymentBO;
import lk.ijse.Jayasakuna.dto.PaymentDTO;
import lk.ijse.Jayasakuna.dto.TeacherDTO;
import lk.ijse.Jayasakuna.dto.tm.PaymentTM;
import lk.ijse.Jayasakuna.dto.tm.TeacherTM;
import lk.ijse.Jayasakuna.entity.Payment;
import lk.ijse.Jayasakuna.entity.Student;

import java.net.URL;
import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PaymentFormController implements Initializable {
    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<PaymentTM> tblPayment;

    @FXML
    private ComboBox<String> comStudentId;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> colfees;

    @FXML
    private TableColumn<?, ?> colpId;

    @FXML
    private TableColumn<?, ?> colsId;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtFees;

    @FXML
    private TextField txtPaymentID;

    PaymentBO paymentBO= BoFactory.getBoFactory().getBo(BoFactory.BOTypes.Payment_BO);

    @FXML
    void PressClear(ActionEvent event) {

        txtPaymentID.setText("");
        comStudentId.getSelectionModel().clearSelection();
        comStudentId.setValue(null);
        txtFees.setText("");
        txtDate.setValue(null);
    }

    @FXML
    void PressDelete(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtPaymentID.getText();
        PaymentDTO payment = new PaymentDTO(id);

        if (paymentBO.deletePayment(String.valueOf(payment))) {
            new Alert(Alert.AlertType.CONFIRMATION, "deletd!").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Somthig wrong!").show();
        }
    }

    @FXML
    void PressSave(ActionEvent event) throws SQLException, ClassNotFoundException {

        String id = comStudentId.getSelectionModel().getSelectedItem();
        String paymentid = txtPaymentID.getText();
        double fees = Double.parseDouble(txtFees.getText());
        java.util.Date date =
                java.util.Date.from(txtDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.util.Date dt = new java.util.Date(date.getTime());

        PaymentDTO payment = new PaymentDTO(paymentid, id, fees, date);

        if (paymentBO.savePayment(payment)) {
            new Alert(Alert.AlertType.CONFIRMATION, "ok!! payment Success :)").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "sorry!! payement not Success :)").show();
        }

    }

    @FXML
    void PressUpdate(ActionEvent event) throws SQLException, ClassNotFoundException {

        String id = comStudentId.getSelectionModel().getSelectedItem();
        String paymentid = txtPaymentID.getText();
        double fees = Double.parseDouble(txtFees.getText());
        java.util.Date date =
                java.util.Date.from(txtDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.util.Date dt = new java.util.Date(date.getTime());

        PaymentDTO payment = new PaymentDTO(paymentid, id, fees, dt);
        if (paymentBO.updatePayment(payment)) {
            new Alert(Alert.AlertType.CONFIRMATION, "ok!! payment updated :)").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "sorry!! payement not updated :)").show();
        }

    }

    public void PressId(KeyEvent actionEvent ) throws SQLException {

        if (actionEvent.getCode().equals(KeyCode.ENTER)) {
            String id = txtPaymentID.getText();
            PaymentDTO payment = new PaymentDTO(id);

               txtPaymentID.setText(payment.getPaymentid());
                comStudentId.setValue(payment.getStudentid());
                txtFees.setText(String.valueOf(payment.getFees()));

            }
        }

private void load ()  {
        String id = comStudentId.getId();
    ObservableList<String> namesList = FXCollections.observableArrayList();
    try {
        ArrayList<String> data = paymentBO.loadIDbyPayment(id);

        for (String studentid : data){
            namesList.add(String.valueOf(studentid));
        }
        comStudentId.setItems(namesList);
    } catch (SQLException | ClassNotFoundException throwables) {
        throwables.printStackTrace();
    }

}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
        setCellValueFactory();
        getAll();
    }
    private void setCellValueFactory() {
        colpId.setCellValueFactory(new PropertyValueFactory<>("paymentid"));
        colsId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colfees.setCellValueFactory(new PropertyValueFactory<>("fees"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("dt"));
    }
    public void  getAll()  {
        try {
            ArrayList<PaymentDTO> cusList = paymentBO.getAllPayment();

            for (PaymentDTO payment : cusList) {
                tblPayment.getItems().add(new PaymentTM(payment.getPaymentid(),payment.getStudentid(),payment.getFees(),payment.getDt()));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }
}
