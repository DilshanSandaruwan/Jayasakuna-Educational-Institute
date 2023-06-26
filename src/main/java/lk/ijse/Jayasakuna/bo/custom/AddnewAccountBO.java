package lk.ijse.Jayasakuna.bo.custom;

import lk.ijse.Jayasakuna.bo.SuperBO;
import lk.ijse.Jayasakuna.dto.AddnewAccountDTO;

import java.sql.SQLException;

public interface AddnewAccountBO extends SuperBO {

    public boolean addUser(AddnewAccountDTO addnewAccountDTO) throws SQLException;
}
