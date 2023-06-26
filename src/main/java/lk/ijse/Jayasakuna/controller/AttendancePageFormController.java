package lk.ijse.Jayasakuna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import lk.ijse.Jayasakuna.bo.custom.AttendanceBO;
import lk.ijse.Jayasakuna.dao.DAOFactory;
import lk.ijse.Jayasakuna.dao.custom.AttendanceDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.AttendanceDAOImpl;
import lk.ijse.Jayasakuna.db.DBconnection;
import lk.ijse.Jayasakuna.dto.AttendanceDTO;
import lk.ijse.Jayasakuna.dto.tm.AttendanceTM;
import lk.ijse.Jayasakuna.entity.Attendance;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

//Inheritance Usage
public class AttendancePageFormController implements Initializable {
    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colAttendanceid;

    @FXML
    private TableColumn<?, ?> colAttends;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colStudentid;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtAttendId;

    @FXML
    private ComboBox<String> comboStudent;

    @FXML
    private TableView<AttendanceTM> tblAttendance;


    @FXML
    private JFXComboBox<String> comboAttend;

   AttendanceBO attendanceBO = BoFactory.getBoFactory().getBo(BoFactory.BOTypes.Attendance_BO);

    @FXML
    void Pressclear(ActionEvent event) {

        txtAttendId.setText("");
        comboStudent.getSelectionModel().clearSelection();
        comboStudent.setValue(null);
        txtDate.setText("");
        comboAttend.getSelectionModel().clearSelection();
        comboAttend.setValue(null);
    }

    @FXML
    void Pressdelete(ActionEvent event) throws SQLException, ClassNotFoundException {

        String id = txtAttendId.getText();
        Connection con = null;
        try {
            con = DBconnection.getInstance().getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        AttendanceDTO attendanceDTO= new AttendanceDTO(id);
        if (attendanceBO.deleteAttendance(String.valueOf(attendanceDTO))) {
            new Alert(Alert.AlertType.CONFIRMATION, "deletd!").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Somthig wrong!").show();
        }
    }

    @FXML
    void Presssave(ActionEvent event) throws SQLException, ClassNotFoundException {

        String id = comboStudent.getSelectionModel().getSelectedItem();
        String attends = comboAttend.getSelectionModel().getSelectedItem();
        String attendId =txtAttendId .getText();
        Date date = Date.valueOf(LocalDate.now());

        AttendanceDTO attendanceDTO = new AttendanceDTO(id,attendId,date,attends);

        if (attendanceBO.saveAttendance(attendanceDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, "ok!! attend  added :)").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "sorry!! attend not added :)").show();
        }
    }

    @FXML
    void Pressupdate(ActionEvent event) throws SQLException, ClassNotFoundException {

        String id = comboStudent.getSelectionModel().getSelectedItem();
        String attends = comboAttend.getSelectionModel().getSelectedItem();
        String attendId =txtAttendId .getText();
        Date date = Date.valueOf(LocalDate.now());

        AttendanceDTO attendanceDTO = new AttendanceDTO(id, attends, date, attendId);

        if (attendanceBO.updateAttendance(attendanceDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, "ok!! attend  updated :)").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "sorry!! attend not updated :)").show();
        }
    }

    private void load ()  {

        ObservableList<String> namesList = FXCollections.observableArrayList();
        Connection con = null;
        try {
            con = DBconnection.getInstance().getConnection();
            ResultSet resultSet = con.createStatement().executeQuery("SELECT StudentID FROM Student");

            List<String> data = new ArrayList<>();

            while (resultSet.next()){
                data.add(resultSet.getString(1));
            }

            for (String studentid : data){
                namesList.add(studentid);
            }

            comboStudent.setItems(namesList);

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    private void loadId(){
        ObservableList<String> namesList = FXCollections.observableArrayList();

            List<String> data = new ArrayList<>();

                data.add("Present");
                data.add("Absent");

            for (String studentid : data){
                namesList.add(studentid);
            }

            comboAttend.setItems(namesList);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
        loadId();
        txtDate.setText(LocalDate.now()+"");
        setCellValueFactory();
        getAll();
    }

    private void setCellValueFactory() {
        colAttendanceid.setCellValueFactory(new PropertyValueFactory<>("attandId"));
        colStudentid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colAttends.setCellValueFactory(new PropertyValueFactory<>("attend"));

    }
    public void  getAll()  {
        try {
            ObservableList<AttendanceTM> obList = FXCollections.observableArrayList();
            ArrayList<AttendanceDTO> cusList = attendanceBO.getAllAttendance();

            for (AttendanceDTO attendance : cusList) {
                obList.add(new AttendanceTM(
                        attendance.getAttandId(),
                        attendance.getId(),
                        attendance.getDate(),
                        attendance.getAttend()
                ));
            }
            tblAttendance.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

    public void PressId(KeyEvent event) throws SQLException, ClassNotFoundException {
        if (event.getCode().equals(KeyCode.ENTER)) {
            String id = txtAttendId.getText();
            AttendanceDTO attendance = new AttendanceDTO(id);
            attendanceBO.getIDAttendance(String.valueOf(attendance));

                comboStudent.setValue(attendance.getId());
                txtAttendId.setText(attendance.getAttandId());
                comboAttend .setValue(String.valueOf(attendance.getAttend()));
                txtDate.setText(String.valueOf(attendance.getDate()));
        }
       }

    }
