package lk.ijse.Jayasakuna.dto;

import java.time.LocalDate;
import java.util.Date;

public class PaymentDTO {
    private String paymentid;
    private String studentid;
    private Date dt;
    private double fees;

    public PaymentDTO(String paymentid) {
        this.paymentid = paymentid;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = (Date) dt;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public PaymentDTO(String paymentid, String studentid, double fees, Date dt) {
        this.paymentid = paymentid;
        this.studentid = studentid;
        this.fees = fees;
        this.dt = dt;
    }
}
