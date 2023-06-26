package lk.ijse.Jayasakuna.dao.custom.impl;

import lk.ijse.Jayasakuna.dao.custom.AddnewAccountDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.util.SQLUtil;
import lk.ijse.Jayasakuna.db.DBconnection;
import lk.ijse.Jayasakuna.dto.AddnewAccountDTO;
import lk.ijse.Jayasakuna.entity.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddnewAccountDAOImpl implements AddnewAccountDAO {

    @Override
    public boolean addUser(AddnewAccountDTO addnewAccountDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Login( Username,  password) VALUES(?, ?)",addnewAccountDTO.getName(),addnewAccountDTO.getPassword());
    }

    @Override
    public boolean addUser(String name, String password) {
        return false;
    }
}
