package lk.ijse.Jayasakuna.dto.tm;

import java.time.LocalDate;
import java.util.Date;


public class PaymentTM {
    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt =  dt;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public PaymentTM(String paymentid, String id, double fees, Date dt) {
        this.paymentid = paymentid;
        this.id = id;
        this.fees = fees;
        this.dt = dt;
    }

    private String paymentid ;
    private String id;
    private double fees;
    private Date dt;

}
