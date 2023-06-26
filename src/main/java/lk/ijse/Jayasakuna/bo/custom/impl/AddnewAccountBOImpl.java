package lk.ijse.Jayasakuna.bo.custom.impl;

import lk.ijse.Jayasakuna.bo.custom.AddnewAccountBO;
import lk.ijse.Jayasakuna.dao.DAOFactory;
import lk.ijse.Jayasakuna.dao.custom.AddnewAccountDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.AddnewAccountDAOImpl;
import lk.ijse.Jayasakuna.dto.AddnewAccountDTO;

import java.sql.SQLException;

public class AddnewAccountBOImpl implements AddnewAccountBO {

    AddnewAccountDAO accountDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.AddnewAccount);

    @Override
    public boolean addUser(AddnewAccountDTO addnewAccountDTO) throws SQLException {
        return accountDAO.addUser(addnewAccountDTO.getName(),addnewAccountDTO.getPassword());
    }
}
