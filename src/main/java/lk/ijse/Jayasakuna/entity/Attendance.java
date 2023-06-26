package lk.ijse.Jayasakuna.entity;

import java.sql.Date;

public class Attendance {
    private String StudentID;
    private String AttendID;
    private int Attend;
    private java.sql.Date Date;

    public Attendance() {
    }

    public Attendance(String studentID, String attendID, int attend, Date date) {
        StudentID = studentID;
        AttendID = attendID;
        Attend = attend;
        Date = date;
    }

    public Attendance(String string, String string1, String string2, java.sql.Date date) {
    }

    public Attendance(String id, String attandId, String attend, java.util.Date date) {

    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getAttendID() {
        return AttendID;
    }

    public void setAttendID(String attendID) {
        AttendID = attendID;
    }

    public int getAttend() {
        return Attend;
    }

    public void setAttend(int attend) {
        Attend = attend;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "StudentID='" + StudentID + '\'' +
                ", AttendID='" + AttendID + '\'' +
                ", Attend=" + Attend +
                ", Date=" + Date +
                '}';
    }
}
