package lk.ijse.Jayasakuna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
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
import lk.ijse.Jayasakuna.bo.custom.StudentBO;
import lk.ijse.Jayasakuna.bo.custom.impl.StudentBoImpl;
import lk.ijse.Jayasakuna.dao.custom.impl.StudiesDAOImpl;
import lk.ijse.Jayasakuna.db.DBconnection;
import lk.ijse.Jayasakuna.dto.StudentDTO;
import lk.ijse.Jayasakuna.dto.StudiesDTO;
import lk.ijse.Jayasakuna.dto.tm.StudentTM;
import lk.ijse.Jayasakuna.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class StudentpageFormController implements Initializable {

    @FXML
    private TableView<StudentTM> StudentTable;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXCheckBox chekEnglish;

    @FXML
    private JFXCheckBox chekICT;

    @FXML
    private JFXCheckBox chekMaths;


    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colmobile;

    @FXML
    private TableColumn<?, ?> colname;
    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMobileNo;

    @FXML
    private TextField txtName;

    StudentBO studentBo = BoFactory.getBoFactory().getBo(BoFactory.BOTypes.Student_BO);
    @FXML
    void PressClear(ActionEvent event) {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtMobileNo.setText("");

    }


    @FXML
    void pressDelete(ActionEvent event) throws SQLException, ClassNotFoundException {

        String id = txtId.getText();

        if (studentBo.deleteStudent(id)) {
            new Alert(Alert.AlertType.CONFIRMATION, "deletd!").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Somthig wrong!").show();
        }


    }


    public void pressUpdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        int mobileNo = Integer.parseInt(txtMobileNo.getText());

        Connection con = DBconnection.getInstance().getConnection();
        con.setAutoCommit(false);

        StudentDTO studentDTO = new StudentDTO(id, name, address, mobileNo);

        if (studentBo.updateStudent(studentDTO)) {
            ArrayList<StudiesDTO> list = new ArrayList<>();
            if (chekEnglish.isSelected()) {
                list.add(new StudiesDTO(
                        txtId.getText(),
                        studentBo.findIdByNameStudent("English"),
                        "English"
                ));
            }
            if (chekMaths.isSelected()) {
                list.add(new StudiesDTO(
                        txtId.getText(),
                        studentBo.findIdByNameStudent("Maths"),
                        "Maths"
                ));
            }
            if (chekICT.isSelected()) {
                list.add(new StudiesDTO(
                        txtId.getText(),
                        studentBo.findIdByNameStudent("ICT"),
                        "ICT"
                ));
            }
            boolean isdelete = StudiesDAOImpl.delete(list);
            Boolean isSaved = StudiesDAOImpl.save(list);

            txtId.clear();
            txtAddress.clear();
            txtMobileNo.clear();
            txtName.clear();
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "ok!! Student Updated :)").show();
                con.commit();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION, "sorry!! Student not Updated :)").show();
            }
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "sorry!! Student not Updated :)").show();
        }
        con.rollback();
        con.setAutoCommit(true);

    }

    @FXML
    void pressSave(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        int mobileNo = Integer.parseInt(txtMobileNo.getText());

        Connection con = DBconnection.getInstance().getConnection();
            con.setAutoCommit(false);

        StudentDTO studentDTO = new StudentDTO(id, name, address, mobileNo);
        if (studentBo.saveStudent(studentDTO)) {
                ArrayList<StudiesDTO> list = new ArrayList<>();
                if (chekEnglish.isSelected()) {
                    list.add(new StudiesDTO(
                            txtId.getText(),
                            studentBo.findIdByNameStudent("English"),
                            "English"
                    ));
                }
                if (chekMaths.isSelected()) {
                    list.add(new StudiesDTO(
                            txtId.getText(),
                            studentBo.findIdByNameStudent("Maths"),
                            "Maths"
                    ));
                }
                if (chekICT.isSelected()) {
                    list.add(new StudiesDTO(
                            txtId.getText(),
                            studentBo.findIdByNameStudent("ICT"),
                            "ICT"
                    ));
                }
                Boolean isSaved = StudiesDAOImpl.save(list);

                txtId.clear();
                txtAddress.clear();
                txtMobileNo.clear();
                txtName.clear();
                if (isSaved){
                    new Alert(Alert.AlertType.CONFIRMATION, "ok!! Student added :)").show();
                    con.commit();
                }else{
                    new Alert(Alert.AlertType.CONFIRMATION, "sorry!! Student not added :)").show();
                }
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "sorry!! Student not added :)").show();
            }
            con.rollback();
            con.setAutoCommit(true);
    }

    public void PressId(KeyEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (actionEvent.getCode().equals(KeyCode.ENTER)) {
            String id = txtId.getText();
            Student student = new Student();
            studentBo.getIDStudent(id);

                txtId.setText(student.getStudentID());
                txtName.setText(student.getStudentName());
                txtAddress.setText(student.getAddress());
                txtMobileNo.setText(String.valueOf(student.getPhoneNumber()));

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
    public void  getAll()  {
        try {
            ObservableList<StudentTM> obList = FXCollections.observableArrayList();
            ArrayList<StudentDTO> cusList = studentBo.getAllStudent();

            for (StudentDTO student : cusList) {
                obList.add(new StudentTM(
                        student.getSid(),
                        student.getSname(),
                        student.getSaddress(),
                        student.getSphone()
                ));
            }
            StudentTable.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }



    @FXML
    void mobilekey(KeyEvent event) {
        String mobileNumber = txtMobileNo.getText();
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
    void studentkey(KeyEvent event) {
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

    @FXML
    void englishPress(ActionEvent event) {

    }

    @FXML
    void ictPress(ActionEvent event) {

    }

    @FXML
    void mathsPress(ActionEvent event) {

    }

}
