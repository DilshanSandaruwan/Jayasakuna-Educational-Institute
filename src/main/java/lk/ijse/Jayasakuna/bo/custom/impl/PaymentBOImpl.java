package lk.ijse.Jayasakuna.bo.custom.impl;

import lk.ijse.Jayasakuna.bo.custom.PaymentBO;
import lk.ijse.Jayasakuna.dao.DAOFactory;
import lk.ijse.Jayasakuna.dao.custom.PaymentDAO;
import lk.ijse.Jayasakuna.dao.custom.StudentDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.Jayasakuna.dao.custom.impl.StudentDAOImpl;
import lk.ijse.Jayasakuna.dto.PaymentDTO;
import lk.ijse.Jayasakuna.dto.StudentDTO;
import lk.ijse.Jayasakuna.entity.Payment;
import lk.ijse.Jayasakuna.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {

    PaymentDAO paymentDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Payment);
    StudentDAO studentDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Student);

    @Override
    public ArrayList<PaymentDTO> getAllPayment() throws SQLException, ClassNotFoundException {
        ArrayList<Payment> all = paymentDAO.getAll();
        ArrayList<PaymentDTO> arrayList = new ArrayList<>();
        for (Payment payment : all) {
            arrayList.add(new PaymentDTO(payment.getStudentID(), payment.getPaymentID(), payment.getFees(), payment.getDate()));
        }
        return arrayList;
    }

    @Override
    public boolean savePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.save(new Payment(dto.getStudentid(), dto.getPaymentid(), dto.getFees(), dto.getDt()));
    }

    @Override
    public boolean updatePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.update(new Payment(dto.getStudentid(), dto.getPaymentid(), dto.getFees(), dto.getDt()));
    }

    @Override
    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException {
        return paymentDAO.delete(id);
    }

    @Override
    public String getIDbyPayment(String id) throws SQLException, ClassNotFoundException {
        Payment t = new Payment(id);
        return String.valueOf(new Payment(t.getStudentID(), t.getPaymentID(), t.getFees(), t.getDate()));
    }

    @Override
    public ArrayList<String> loadIDbyPayment(String id) throws SQLException, ClassNotFoundException {
        return  paymentDAO.loadID(id);
    }
}