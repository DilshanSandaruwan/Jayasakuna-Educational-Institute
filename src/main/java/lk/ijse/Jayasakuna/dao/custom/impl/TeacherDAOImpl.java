package lk.ijse.Jayasakuna.dao.custom.impl;

import lk.ijse.Jayasakuna.dao.custom.TeacherDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.util.SQLUtil;
import lk.ijse.Jayasakuna.db.DBconnection;
import lk.ijse.Jayasakuna.entity.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDAOImpl implements TeacherDAO {

    @Override
    public ArrayList<Teacher> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Teacher> data = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM Teacher");

        while (resultSet.next()) {
            data.add(new Teacher(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
        }
        return data;
    }

    @Override
    public boolean save(Teacher dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Teacher( TeacherID,  TeacherName, Address, PhoneNumber)" + "VALUES(?, ?, ?, ?)",dto.getTeacherID(),dto.getTeacherName(),dto.getAddress(),dto.getPhoneNumber());
    }

    @Override
    public boolean update(Teacher dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE Teacher SET TeacherName = ?, Address = ?, PhoneNumber = ? WHERE TeacherID = ?",dto.getTeacherID(),dto.getTeacherName(),dto.getAddress(),dto.getPhoneNumber());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("DELETE FROM Teacher WHERE TeacherID = ?",s);
    }


    @Override
    public Teacher getID(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Teacher WHERE TeacherID = ?",s);
        if (rst.next()) {
            return new Teacher(rst.getString(1), rst.getString(2), rst.getString(3),rst.getInt(4));
        }
        return null;
    }


    @Override
    public ArrayList<String> loadID(String id) throws SQLException {
        return null;
    }

}