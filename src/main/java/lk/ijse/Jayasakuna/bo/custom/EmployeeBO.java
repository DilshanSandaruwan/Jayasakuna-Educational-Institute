package lk.ijse.Jayasakuna.bo.custom;

import lk.ijse.Jayasakuna.bo.SuperBO;
import lk.ijse.Jayasakuna.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {

    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException ;

    public boolean saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;

    public boolean deleteEmployee(String s) throws SQLException, ClassNotFoundException;

    public String getIDEmployee(String s) throws SQLException, ClassNotFoundException ;
}
