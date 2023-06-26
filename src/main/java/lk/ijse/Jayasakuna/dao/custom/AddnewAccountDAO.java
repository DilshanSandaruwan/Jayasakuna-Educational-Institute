package lk.ijse.Jayasakuna.dao.custom;

import lk.ijse.Jayasakuna.dao.SuperDAO;
import lk.ijse.Jayasakuna.dto.AddnewAccountDTO;

import java.sql.SQLException;

public interface AddnewAccountDAO extends SuperDAO {
    public boolean addUser(AddnewAccountDTO addnewAccountDTO) throws SQLException, ClassNotFoundException;

    boolean addUser(String name, String password);
}
