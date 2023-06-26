package lk.ijse.Jayasakuna.dao.custom.impl;

import lk.ijse.Jayasakuna.dao.custom.SubjectDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.util.SQLUtil;
import lk.ijse.Jayasakuna.db.DBconnection;
import lk.ijse.Jayasakuna.entity.Subject;
import lk.ijse.Jayasakuna.entity.Teacher;
import lk.ijse.Jayasakuna.util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;

public class SubjectDAOImpl implements SubjectDAO {


    @Override
    public ArrayList<Subject> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Subject> data = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM Subject");

        while (resultSet.next()) {
            data.add(new Subject(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getTime(4)));
        }
        return data;
    }

    @Override
    public boolean save(Subject dto) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean update(Subject dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Subject SET SubjectName = ?, HallNumber = ?, Time = ? WHERE SubjectID = ?",dto.getSubjectName(),dto.getHallNumber(),dto.getTime(),dto.getSubjectID());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public Subject getID(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Subject WHERE SubjectID = ?",s);
        if (rst.next()) {
            return new Subject(rst.getString(1), rst.getString(2), rst.getString(3),rst.getTime(4));
        }
        return null;
    }


    @Override
    public ArrayList<String> loadID(String id) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

}