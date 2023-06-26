package lk.ijse.Jayasakuna.dao.custom.impl;

import lk.ijse.Jayasakuna.dao.custom.StudentDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.util.SQLUtil;
import lk.ijse.Jayasakuna.db.DBconnection;
import lk.ijse.Jayasakuna.entity.Student;
import lk.ijse.Jayasakuna.entity.Subject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Student> data = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM Student");

        while (resultSet.next()) {
            data.add(new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
        }
        return data;
    }


    @Override
    public boolean save(Student dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Student( StudentID,  StudentName, Address, PhoneNumber)" + "VALUES(?, ?, ?, ?)",dto.getStudentID(),dto.getStudentName(),dto.getAddress(),dto.getPhoneNumber());
    }

    @Override
    public boolean update(Student dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE Student SET StudentName = ?, Address = ?, PhoneNumber = ? WHERE StudentID = ?",dto.getStudentID(),dto.getStudentName(),dto.getAddress(),dto.getPhoneNumber());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Student WHERE StudentID = ?",s);
    }

    @Override
    public Student getID(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst =SQLUtil.execute("SELECT * FROM Student WHERE StudentID = ?",s);
        if (rst.next()) {
            return new Student(rst.getString(1), rst.getString(2), rst.getString(3),rst.getInt(4));
        }
        return null;
    }

    @Override
    public ArrayList<String> loadID(String id) throws SQLException {
        return null;
    }


    @Override
    public String findIdByName(String subject) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT SubjectID FROM SubjectDTO WHERE SubjectName=?", subject);
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return "NoSubject";
    }

    @Override
    public Subject getID(Subject id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("select * from Subject where SubjectID = ?",id);
        if (rst.next()) {
            return new Subject(rst.getString(1), rst.getString(2), rst.getString(3), rst.getTime(4));
        }
        return null;
       }
    }


