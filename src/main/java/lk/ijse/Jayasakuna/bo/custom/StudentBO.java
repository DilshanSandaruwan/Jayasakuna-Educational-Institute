package lk.ijse.Jayasakuna.bo.custom;

import lk.ijse.Jayasakuna.bo.SuperBO;
import lk.ijse.Jayasakuna.dto.StudentDTO;
import lk.ijse.Jayasakuna.entity.Subject;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {
     ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException;

     boolean saveStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

     boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

     boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;

     String getIDStudent(String id) throws SQLException, ClassNotFoundException ;

     String findIdByNameStudent(String subject) throws SQLException, ClassNotFoundException;

     String getIDSubject(Subject subid) throws SQLException, ClassNotFoundException ;

}
