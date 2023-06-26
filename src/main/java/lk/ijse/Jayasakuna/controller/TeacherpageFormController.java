package lk.ijse.Jayasakuna.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.ijse.Jayasakuna.bo.custom.TeacherBO;
import lk.ijse.Jayasakuna.bo.custom.impl.TeacherBOImpl;
import lk.ijse.Jayasakuna.dao.DAOFactory;
import lk.ijse.Jayasakuna.dao.custom.TeacherDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.TeacherDAOImpl;
import lk.ijse.Jayasakuna.dto.TeacherDTO;
import lk.ijse.Jayasakuna.dto.tm.TeacherTM;
import lk.ijse.Jayasakuna.entity.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeacherpageFormController  implements Initializable{
    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtphone;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colmobile;

    @FXML
    private TableView<TeacherTM> tblTeacher;

    @FXML
    private TextField txtTeacherAddress;

    @FXML
    private TextField txtTeacherID;

    @FXML
    private TextField txtTeacherName;

    TeacherBO teacherBO = new TeacherBOImpl();

    public void PressId(KeyEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (actionEvent.getCode().equals(KeyCode.ENTER)) {
            String id = txtId.getText();
            TeacherDTO teacher = new TeacherDTO();
            teacherBO.getIDTeacher(id);
                txtId.setText(teacher.getSid());
                txtName.setText(teacher.getSname());
                txtAddress.setText(teacher.getSaddress());
                txtphone.setText(String.valueOf(teacher.getSphone()));
        }

    }
    @FXML
    void PressClear(ActionEvent event) {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtphone.setText("");

    }

    @FXML
    void PressDelete(ActionEvent event) throws SQLException, ClassNotFoundException {

        String id = txtId.getText();
        TeacherDTO teacherDTO = new TeacherDTO(id);

        if (teacherBO.deleteTeacher(String.valueOf(teacherDTO))) {
            new Alert(Alert.AlertType.CONFIRMATION, "deletd!").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Somthig wrong!").show();
        }


    }

    @FXML
    void PressSave(ActionEvent event) throws SQLException, ClassNotFoundException {

        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        int mobileNo = Integer.parseInt(txtphone.getText());

        TeacherDTO teacherDTO = new TeacherDTO(id, name, address, mobileNo);

        if (teacherBO.saveTeacher(teacherDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, "ok!! Teacher added :)").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "sorry!! Teacher not added :)").show();
        }

    }

    @FXML
    void PressUpdate(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        int mobileNo = Integer.parseInt(txtphone.getText());

        TeacherDTO teacherDTO = new TeacherDTO(id, name, address, mobileNo);

        if (teacherBO.updateTeacher(teacherDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, "ok!! Teacher updated :)").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "sorry!! Teacher not updated :)").show();
        }

    }

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colmobile.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

    public void  getAll() {
        try {

            ArrayList<TeacherDTO> cusList = teacherBO.getAllTeacher();

            for (TeacherDTO teacher : cusList) {
                tblTeacher.getItems().add(new TeacherTM(teacher.getSid(),teacher.getSname(),teacher.getSaddress(),teacher.getSphone()));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }



    @FXML
    void mobilekey(KeyEvent event) {

        String mobileNumber = txtphone.getText();
        if (mobileNumber.matches("[0-9]+")) {

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Mobile number should contain only numbers.");
            alert.showAndWait();
        }
    }

    @FXML
    void Teacherkey(KeyEvent event) {

        String id = txtId.getText();
        if (id.length()<5) {

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("ID must be 4 characters long.");
            alert.showAndWait();
        }
    }

}
