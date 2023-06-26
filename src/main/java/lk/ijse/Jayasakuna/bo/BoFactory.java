package lk.ijse.Jayasakuna.bo;

import lk.ijse.Jayasakuna.bo.custom.impl.*;
import lk.ijse.Jayasakuna.dao.SuperDAO;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {

    }

    public static BoFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BoFactory() : boFactory;
    }

    public enum BOTypes {
        Student_BO, Employee_BO, Teacher_BO,Subject_BO,Payment_BO,Attendance_BO,Studies_BO,Loging_BO,AddnewAccount_BO
    }

    public <T extends SuperBO> T getBo(BoFactory.BOTypes res) {
        switch (res) {
            case Student_BO:
                return (T) new StudentBoImpl();
            case Employee_BO:
                return (T) new EmployeeBOImpl();
            case Teacher_BO:
                return (T) new TeacherBOImpl();
            case Subject_BO:
                return (T) new SubjectBOImpl();
            case Payment_BO:
                return (T) new PaymentBOImpl();
            case Attendance_BO:
                return (T) new AttendanceBOImpl();
            case Studies_BO:
                return (T) new StudiesBOImpl();
            case Loging_BO:
                return (T) new LogingBOImpl();
            case AddnewAccount_BO:
                return (T) new AddnewAccountBOImpl();
            default:
                return null;
        }
    }

}
