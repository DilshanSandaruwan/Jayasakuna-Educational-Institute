package lk.ijse.Jayasakuna.dao;

import lk.ijse.Jayasakuna.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDAOFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        Student, Subject, Attendance, Loging, Employee,Payment,Teacher,Studies,AddnewAccount
    }

    public <T extends SuperDAO> T getDAO(DAOTypes res) {
        switch (res) {
            case Student:
                return (T) new StudentDAOImpl();
            case Employee:
                return (T) new EmployeeDAOImpl();
            case Teacher:
                return (T) new TeacherDAOImpl();
            case Subject:
                return (T) new SubjectDAOImpl();
            case Payment:
                return (T) new PaymentDAOImpl();
            case Attendance:
                return (T) new AttendanceDAOImpl();
            case Studies:
                return (T) new StudiesDAOImpl();
            case Loging:
                return (T) new LoginDAOImpl();
            case AddnewAccount:
                return (T) new AddnewAccountDAOImpl();
            default:
                return null;
        }
    }
}
