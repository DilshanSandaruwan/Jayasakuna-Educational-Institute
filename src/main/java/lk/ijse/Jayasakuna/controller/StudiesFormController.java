package lk.ijse.Jayasakuna.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import lk.ijse.Jayasakuna.bo.BoFactory;
import lk.ijse.Jayasakuna.bo.custom.StudentBO;
import lk.ijse.Jayasakuna.bo.custom.StudiesBO;
import lk.ijse.Jayasakuna.dao.DAOFactory;
import lk.ijse.Jayasakuna.dao.custom.StudiesDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.StudiesDAOImpl;
import lk.ijse.Jayasakuna.db.DBconnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StudiesFormController implements Initializable {

    @FXML
    private ComboBox<String> comboId;

    @FXML
    private TextArea txtSubject;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnReports;

    StudiesBO studiesDAO= BoFactory.getBoFactory().getBo(BoFactory.BOTypes.Studies_BO);

    private void load ()  {
        String id = comboId.getId();
        ObservableList<String> namesList = FXCollections.observableArrayList();
        Connection con = null;
        try {

            ArrayList<String>data = studiesDAO.loadstudentIdFromstudies(id);
            for (String studentid : data){
                namesList.add(studentid);
            }
            comboId.setItems(namesList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
            comboId.setOnAction(actionEvent -> {
                txtSubject.clear();
                try {
                List<String> list = StudiesDAOImpl.findAllBYStudentId(comboId.getValue());
                    for (String sub:list) {
                        txtSubject.appendText(sub+"\n");
                    }
                }catch (SQLException e){

                }
            });
    }


    @FXML
    void clearPress(ActionEvent event) {
        txtSubject.setText("");
        comboId.getSelectionModel().clearSelection();
    }

    @FXML
    void reportsPress(ActionEvent event) throws JRException, SQLException {

        InputStream rpt = StudiesFormController.class.getResourceAsStream("/Report/StudentReport.jrxml.jrxml");
        JasperReport compile =  JasperCompileManager.compileReport(rpt);
        JasperPrint report = JasperFillManager.fillReport(compile,null,DBconnection.getInstance().getConnection());
        JasperViewer.viewReport(report,false);
        }
     }



