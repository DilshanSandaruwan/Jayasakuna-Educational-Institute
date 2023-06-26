package lk.ijse.Jayasakuna.entity;

import java.time.LocalDate;
import java.util.Date;

public class Payment {
    private String PaymentID;
    private String StudentID;
    private double Fees;
    private java.util.Date Date;

    public Payment(String paymentID, String studentID, double fees, java.util.Date date) {
        PaymentID = paymentID;
        StudentID = studentID;
        Fees = fees;
        Date = date;
    }

    public Payment(String id) {

    }

    public String getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(String paymentID) {
        PaymentID = paymentID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public double getFees() {
        return Fees;
    }

    public void setFees(double fees) {
        Fees = fees;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "PaymentID='" + PaymentID + '\'' +
                ", StudentID='" + StudentID + '\'' +
                ", Fees='" + Fees + '\'' +
                ", Date=" + Date +
                '}';
    }
}
