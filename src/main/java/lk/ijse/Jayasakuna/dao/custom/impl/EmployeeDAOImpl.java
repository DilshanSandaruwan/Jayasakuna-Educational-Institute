package lk.ijse.Jayasakuna.dao.custom.impl;

import lk.ijse.Jayasakuna.dao.custom.EmployeeDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.util.SQLUtil;
import lk.ijse.Jayasakuna.db.DBconnection;
import lk.ijse.Jayasakuna.entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<Employee> data = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute( "SELECT * FROM Employee");

        while (resultSet.next()) {
            data.add(new Employee(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
        }
        return data;
    }

    @Override
    public boolean save(Employee dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Employee( EmployeeID,  EmployeeName, Address, PhoneNumber)" + "VALUES(?, ?, ?, ?)",dto.getEmployeeID(),dto.getEmployeeName(),dto.getAddress(),dto.getPhoneNumber());
    }

    @Override
    public boolean update(Employee dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Employee SET EmployeeName = ?, Address = ?, PhoneNumber = ? WHERE EmployeeID = ?",dto.getEmployeeName(),dto.getAddress(),dto.getPhoneNumber(),dto.getEmployeeID());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Employee WHERE EmployeeID = ?",s);
    }

    @Override
    public Employee getID(String s) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM Employee WHERE EmployeeID = ?",s);
        if (rst.next()) {
            return new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4));
        }
        return null;
    }


    @Override
    public ArrayList<String> loadID(String id) throws SQLException {
        return null;
    }


}