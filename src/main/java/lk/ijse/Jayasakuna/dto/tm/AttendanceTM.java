package lk.ijse.Jayasakuna.dto.tm;

import java.util.Date;

public class AttendanceTM {
    private String attandId;
    private String id;
    private String attend;
    private Date date;

    public AttendanceTM(String attandId, String id, Date date,String attend) {
        this.attandId = attandId;
        this.id = id;
        this.attend = attend;
        this.date = date;
    }

    public AttendanceTM(String attendID, String studentID, java.sql.Date date, int attend) {

    }

    public String getAttandId() {
        return attandId;
    }

    public void setAttandId(String attandId) {
        this.attandId = attandId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttend() {
        return attend;
    }

    public void setAttend(String attend) {
        this.attend = attend;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
