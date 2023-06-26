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
import lk.ijse.Jayasakuna.bo.custom.EmployeeBO;
import lk.ijse.Jayasakuna.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.Jayasakuna.dao.DAOFactory;
import lk.ijse.Jayasakuna.dao.custom.EmployeeDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.Jayasakuna.dto.EmployeeDTO;
import lk.ijse.Jayasakuna.dto.tm.EmployeeTM;
import lk.ijse.Jayasakuna.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmployeePageFormController implements Initializable {

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<EmployeeTM> tblEmployee;

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
    private TextField txtID;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

   EmployeeBO employeeBO = BoFactory.getBoFactory().getBo(BoFactory.BOTypes.Employee_BO);

    @FXML
    void Pressclear(ActionEvent event) {

        txtID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtMobile.setText("");
    }

    @FXML
    void Pressdelete(ActionEvent event) throws SQLException, ClassNotFoundException {

        String id = txtID.getText();
        EmployeeDTO employeeDTO = new EmployeeDTO(id);

        if (employeeBO.deleteEmployee(String.valueOf(employeeDTO))) {
            new Alert(Alert.AlertType.CONFIRMATION, "deletd!").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Somthig wrong!").show();
        }


    }

    @FXML
    void Presssave(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        int mobileNo = Integer.parseInt(txtMobile.getText());

        EmployeeDTO employeeDTO = new EmployeeDTO(id,name,address,mobileNo);

        if (employeeBO.saveEmployee(employeeDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, "ok!! Employee added :)").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "sorry!! Employee not added :)").show();
        }

    }

    @FXML
    void PressUpdate(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        int mobileNo = Integer.parseInt(txtMobile.getText());

       EmployeeDTO employeeDTO =  new EmployeeDTO(id,name,address,mobileNo);

        if (employeeBO.updateEmployee(employeeDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, "ok!! Employee added :)").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "sorry!! Employee not added :)").show();
        }
    }

    @FXML
    void PressId(KeyEvent event) throws SQLException, ClassNotFoundException {
        if (event.getCode().equals(KeyCode.ENTER)) {
            String id = txtID.getText();
            EmployeeDTO employee = new EmployeeDTO(id);

                employeeBO.getIDEmployee(String.valueOf(employee));
                txtID.setText(employee.getSid());
                txtName.setText(employee.getSname());
                txtAddress.setText(employee.getSaddress());
                txtMobile.setText(String.valueOf(employee.getSphone()));

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
            ObservableList<EmployeeTM> obList = FXCollections.observableArrayList();
            ArrayList<EmployeeDTO> cusList = employeeBO.getAllEmployee();

            for (EmployeeDTO employee : cusList) {
                obList.add(new EmployeeTM(
                        employee.getSid(),
                        employee.getSname(),
                        employee.getSaddress(),
                        employee.getSphone()
                ));
            }
            tblEmployee.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }


    @FXML
    void mobilekey(KeyEvent event) {

        String mobileNumber = txtMobile.getText();
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
    void Employeekey(KeyEvent event) {

        String id = txtID.getText();
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
