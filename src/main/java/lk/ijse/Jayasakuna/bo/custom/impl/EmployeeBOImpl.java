package lk.ijse.Jayasakuna.bo.custom.impl;

import lk.ijse.Jayasakuna.bo.custom.EmployeeBO;
import lk.ijse.Jayasakuna.dao.DAOFactory;
import lk.ijse.Jayasakuna.dao.custom.EmployeeDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.Jayasakuna.dto.EmployeeDTO;
import lk.ijse.Jayasakuna.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {

   EmployeeDAO employee = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Employee);

    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> all = employee.getAll();
        ArrayList<EmployeeDTO> arrayList= new ArrayList<>();
        for (Employee employee1 : all) {
            arrayList.add(new EmployeeDTO(employee1.getEmployeeID(),employee1.getEmployeeName(),employee1.getAddress(),employee1.getPhoneNumber()));
        }
        return arrayList;
    }

    @Override
    public boolean saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employee.save(new Employee(dto.getSid(),dto.getSname(),dto.getSaddress(),dto.getSphone()));
    }

    @Override
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employee.update(new Employee(dto.getSid(),dto.getSname(),dto.getSaddress(),dto.getSphone()));
    }

    @Override
    public boolean deleteEmployee(String s) throws SQLException, ClassNotFoundException {
        return employee.delete(s);
    }

    @Override
    public String getIDEmployee(String s) throws SQLException, ClassNotFoundException {
        Employee e = employee.getID(s);
        return String.valueOf(new EmployeeDTO(e.getEmployeeID(),e.getEmployeeName(),e.getAddress(),e.getPhoneNumber()));
    }
}
