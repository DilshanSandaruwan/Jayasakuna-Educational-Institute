package lk.ijse.Jayasakuna.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class HomepageFormController {

    @FXML
    private Pane Varpane;

    @FXML
    private Button btnAddAccount;

    @FXML
    private JFXButton btnPrivacy;

    @FXML
    private JFXButton btnAttendance;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXButton btnPayment;


    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnSalary;

    @FXML
    private JFXButton btnStudent;

    @FXML
    private JFXButton btnSubject;

    @FXML
    private JFXButton btnTeacher;

    @FXML
    private AnchorPane homepane;

    @FXML
    private AnchorPane mainPane;

    public HomepageFormController() throws IOException {
    }

    @FXML
    void Paymentpress(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Paymentpage-form.fxml"));
        Pane pane  = fxmlLoader.load();

        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(pane);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @FXML
    void Attendancepress(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/AttendancePage-form.fxml"));
        Pane pane  = fxmlLoader.load();

        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(pane);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void Emplolyeepress(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/EmployeePage-form.fxml"));
        Pane pane  = fxmlLoader.load();

        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(pane);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void Homepress(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Home-form.fxml"));
        Pane pane  = fxmlLoader.load();

        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(pane);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void Logoutpress(ActionEvent event) throws Exception {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Loging-form.fxml"));
        Pane pane = fxmlLoader.load();
        try {
            homepane.getChildren().clear();
            homepane.getChildren().setAll(pane);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    @FXML
    void Salarypress(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Studies-form.fxml"));
        Pane pane  = fxmlLoader.load();

        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(pane);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void Subjectpress(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Subjectpage-form.fxml"));
        Pane pane  = fxmlLoader.load();

        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(pane);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void Teacherpress(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Teacherpage-form.fxml"));
        Pane pane  = fxmlLoader.load();

        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(pane);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void Studentpress(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Studentpage-form.fxml"));
        Pane pane  = fxmlLoader.load();

        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(pane);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String original = "-fx-background-radius: 40 40 40 40; -fx-background-color: #8338ec;";
    private String fake = "-fx-background-color: #0000FF; -fx-text-fill: white; -fx-background-radius: 40; -fx-border-radius: 40; -fx-cursor: hand;";

    @FXML
    void btnStudentOnMouseEntered(MouseEvent event) {
      btnStudent.setStyle(fake);
    }

    @FXML
    void btnStudentOnMouseExited(MouseEvent event) {
      btnStudent.setStyle(original);
    }


    @FXML
    void btnAttendanceOnMouseExite(MouseEvent event) {
         btnAttendance.setStyle(original);
    }

    @FXML
    void btnaAttendanceOnMouseEntered(MouseEvent event) {
         btnAttendance.setStyle(fake);
    }

    @FXML
    void btnEmployeeOnMouseEntered(MouseEvent event) {
        btnEmployee.setStyle(fake);
    }

    @FXML
    void btnEmployeeOnMouseExited(MouseEvent event) {
      btnEmployee.setStyle(original);
    }

    @FXML
    void btnHomeOnMouseEntered(MouseEvent event) {
        btnHome.setStyle(fake);
    }

    @FXML
    void btnHomeOnMouseExite(MouseEvent event) {
        btnHome.setStyle(original);
    }

    @FXML
    void btnLogoutOnMouseEntered(MouseEvent event) {
        btnLogout.setStyle(fake);
    }

    @FXML
    void btnLogoutOnMouseExite(MouseEvent event) {
        btnLogout.setStyle(original);
    }

    @FXML
    void btnPaymentOnMouseEntered(MouseEvent event) {
        btnPayment.setStyle(fake);
    }

    @FXML
    void btnPaymentOnMouseExite(MouseEvent event) {
        btnPayment.setStyle(original);
    }

    @FXML
    void btnStudiesOnMouseEntered(MouseEvent event) {
        btnSalary.setStyle(fake);
    }

    @FXML
    void btnStudiesOnMouseExite(MouseEvent event) {
        btnSalary.setStyle(original);
    }

    @FXML
    void btnSubjectOnMouseEntered(MouseEvent event) {
        btnSubject.setStyle(fake);
    }

    @FXML
    void btnSubjectOnMouseExite(MouseEvent event) {
        btnSubject.setStyle(original);
    }

    @FXML
    void btnTeacherOnMouseEntered(MouseEvent event) {
        btnTeacher.setStyle(fake);
    }

    @FXML
    void btnTeacherOnMouseExited(MouseEvent event) {
        btnTeacher.setStyle(original);
    }

    @FXML
    void AddAccountOnPress(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/AddNewAccount-form.fxml"));
        Pane pane  = fxmlLoader.load();

        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(pane);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void PrivacyPress(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ChengPassword-form.fxml"));
        Pane pane  = fxmlLoader.load();

        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(pane);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
