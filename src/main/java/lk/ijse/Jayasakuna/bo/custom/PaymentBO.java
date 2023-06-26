package lk.ijse.Jayasakuna.bo.custom;

import lk.ijse.Jayasakuna.bo.SuperBO;
import lk.ijse.Jayasakuna.dto.PaymentDTO;
import lk.ijse.Jayasakuna.entity.Payment;
import lk.ijse.Jayasakuna.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO {
    public ArrayList<PaymentDTO> getAllPayment() throws SQLException, ClassNotFoundException;

    public boolean savePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean updatePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException;

    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException ;

    public String getIDbyPayment(String id) throws SQLException, ClassNotFoundException ;

    public ArrayList<String> loadIDbyPayment(String id) throws SQLException, ClassNotFoundException ;
}
