package lk.ijse.Jayasakuna.bo.custom;

import lk.ijse.Jayasakuna.bo.SuperBO;
import lk.ijse.Jayasakuna.dto.SubjectDTO;

import java.sql.*;
import java.util.ArrayList;

public interface SubjectBO extends SuperBO {
    public ArrayList<SubjectDTO> getAllSubject() throws SQLException, ClassNotFoundException;

    public boolean updateSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException;

    public String getSubjectID(String s) throws SQLException, ClassNotFoundException ;
}
