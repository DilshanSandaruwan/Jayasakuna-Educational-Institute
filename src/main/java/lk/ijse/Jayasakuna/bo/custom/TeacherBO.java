package lk.ijse.Jayasakuna.bo.custom;

import lk.ijse.Jayasakuna.bo.SuperBO;
import lk.ijse.Jayasakuna.dto.TeacherDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TeacherBO extends SuperBO {
    ArrayList<TeacherDTO> getAllTeacher() throws SQLException, ClassNotFoundException;

    boolean saveTeacher(TeacherDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateTeacher(TeacherDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteTeacher(String id) throws SQLException, ClassNotFoundException;

    String getIDTeacher(String id) throws SQLException, ClassNotFoundException;

}
