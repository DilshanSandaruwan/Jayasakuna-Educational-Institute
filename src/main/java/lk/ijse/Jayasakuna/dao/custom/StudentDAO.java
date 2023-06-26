package lk.ijse.Jayasakuna.dao.custom;

import lk.ijse.Jayasakuna.dao.CrudDAO;
import lk.ijse.Jayasakuna.dao.SuperDAO;
import lk.ijse.Jayasakuna.entity.Student;
import lk.ijse.Jayasakuna.entity.Subject;
import lk.ijse.Jayasakuna.util.CrudUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface StudentDAO extends  CrudDAO<Student,String> {

    public String findIdByName(String subject) throws SQLException, ClassNotFoundException;
    public Subject getID(Subject id) throws SQLException, ClassNotFoundException;
}
