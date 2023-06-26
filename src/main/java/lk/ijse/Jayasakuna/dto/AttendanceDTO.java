package lk.ijse.Jayasakuna.dto;

import java.util.Date;

public class AttendanceDTO {
    private String AttandId;
    private String Id;
    private String Attend;
    private Date date;

    public AttendanceDTO(String attandId) {
        AttandId = attandId;
    }

    public AttendanceDTO(String attendID, String studentID, java.sql.Date date, int attend) {

    }

    public String getAttandId() {
        return AttandId;
    }

    public void setAttandId(String attandId) {
        AttandId = attandId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAttend() {
        return Attend;
    }

    public void setAttend(String attend) {
        Attend = attend;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = (java.sql.Date)date;
    }

    public AttendanceDTO(String attandId, String id, Date date, String attend) {
        AttandId = attandId;
        Id = id;
        this.date = date;
        Attend = attend;
    }
}
