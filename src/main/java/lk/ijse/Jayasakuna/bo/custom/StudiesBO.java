package lk.ijse.Jayasakuna.bo.custom;

import lk.ijse.Jayasakuna.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudiesBO extends SuperBO {

    public  ArrayList<String> findAllBYStudentIdFromstudies(String id) throws SQLException ;

    public ArrayList<String> loadstudentIdFromstudies(String id) throws SQLException;

}
