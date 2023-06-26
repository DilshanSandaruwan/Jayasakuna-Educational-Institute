package lk.ijse.Jayasakuna.dao.custom.impl;

import lk.ijse.Jayasakuna.dao.custom.LogingDAO;
import lk.ijse.Jayasakuna.db.DBconnection;
import lk.ijse.Jayasakuna.dto.UserDTO;
import lk.ijse.Jayasakuna.entity.Loging;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAOImpl implements LogingDAO {
    public static UserDTO log(String name) throws SQLException {

        Connection con = DBconnection.getInstance().getConnection();
        String sql = "SELECT * FROM Login WHERE Username =?";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, name);
        ResultSet resultSet = pstm.executeQuery();

        if(resultSet.next()) {
            return  new UserDTO(resultSet.getString(1), resultSet.getString(2));
        }
        return null;
    }

    @Override
    public ArrayList<Loging> getAll() throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean save(Loging dto) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean update(Loging dto) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean delete(String id) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public Loging getID(String id) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public ArrayList<String> loadID(String id) throws SQLException {
        return null;
    }
}
