package lk.ijse.Jayasakuna.dao.custom.impl;

import lk.ijse.Jayasakuna.dao.custom.PaymentDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.util.SQLUtil;
import lk.ijse.Jayasakuna.db.DBconnection;
import lk.ijse.Jayasakuna.entity.Payment;
import lk.ijse.Jayasakuna.entity.Student;

import java.sql.*;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Payment> data = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM Payment");

        while (resultSet.next()) {
            data.add(new Payment(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getDate(4)));
        }
        return data;
    }

    @Override
    public boolean save(Payment dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Payment(PaymentID, StudentID, Fees, Date)"+ "VALUES(?, ?, ?, ?)",dto.getPaymentID(),dto.getStudentID(),dto.getFees(),dto.getDate());
    }

    @Override
    public boolean update(Payment dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE Payment SET StudentID=?,Fees =?,Date =? WHERE PaymentID = ?",dto.getStudentID(),dto.getFees(),dto.getDate(),dto.getPaymentID());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Payment WHERE PaymentID = ?",id);
    }

    @Override
    public Payment getID(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("select * from Payment where PaymentID = ?",id);
        if (rst.next()) {
            return new Payment(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getDate(4));
        }
        return null;
    }


    @Override
    public ArrayList<String> loadID(String id) throws SQLException, ClassNotFoundException {
            ResultSet resultSet = SQLUtil.execute("SELECT StudentID FROM Student");
            ArrayList<String> data = new ArrayList<>();
            while (resultSet.next()) {
                data.add(resultSet.getString(1));
            }
            return data;
    }
}
