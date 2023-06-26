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
import lk.ijse.Jayasakuna.bo.BoFactory;
import lk.ijse.Jayasakuna.bo.custom.SubjectBO;
import lk.ijse.Jayasakuna.dao.DAOFactory;
import lk.ijse.Jayasakuna.dao.custom.SubjectDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.SubjectDAOImpl;
import lk.ijse.Jayasakuna.dto.SubjectDTO;
import lk.ijse.Jayasakuna.dto.TeacherDTO;
import lk.ijse.Jayasakuna.dto.tm.SubjectTM;
import lk.ijse.Jayasakuna.dto.tm.TeacherTM;
import lk.ijse.Jayasakuna.entity.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SubjectPageFormController implements Initializable {
    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<SubjectTM> tblSubject;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colhallNo;

    @FXML
    private TableColumn<?, ?> coltime;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TextField txtHallnumber;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTime;

    SubjectBO subjectDAOImpl = BoFactory.getBoFactory().getBo(BoFactory.BOTypes.Subject_BO);

    @FXML
    void PressClear(ActionEvent event) {

        txtId.setText("");
        txtName.setText("");
        txtTime.setText("");
        txtHallnumber.setText("");

    }


    @FXML
    void PressId(KeyEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (actionEvent.getCode().equals(KeyCode.ENTER)) {
            String id = txtId.getText();
            SubjectDTO subject = new SubjectDTO(id);
            subjectDAOImpl.getSubjectID(String.valueOf(subject));

                txtId.setText(subject.getSubname());
                txtName.setText(subject.getSubname());
                txtHallnumber.setText(subject.getSubHallno());

            }
        }


    @FXML
    void PressUpdate(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String time = txtTime.getText();
        String hallNo = txtHallnumber.getText();

        SubjectDTO subjectDTO = new SubjectDTO(id,name,hallNo, Time.valueOf(time));

        if (subjectDAOImpl.updateSubject(subjectDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, "ok!! Subject updated :)").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "sorry!! Subject not updated :)").show();
        }
    }

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        txtId.setEditable(true);
        setCellValueFactory();
        getAll();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colhallNo.setCellValueFactory(new PropertyValueFactory<>("hallNo"));
        coltime.setCellValueFactory(new PropertyValueFactory<>("time"));
    }
    public void  getAll()  {
        try {

            ArrayList<SubjectDTO> cusList = subjectDAOImpl.getAllSubject();

            for (SubjectDTO subject : cusList) {
                tblSubject.getItems().add(new SubjectTM(subject.getSubid(),subject.getSubname(),subject.getSubHallno(),subject.getSubtime()));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }
}


