package lk.ijse.Jayasakuna.dto;

import java.sql.Time;
import java.time.LocalTime;

public class SubjectDTO {

    private String subid;
    private String subname;
    private String subHallno;
    private Time subtime;

    public Time getSubtime() {
        return subtime;
    }

    public SubjectDTO(String string, String string1, String string2, Time time) {
    }

    public SubjectDTO(String id) {

    }

    public String getSubid() {
        return subid;
    }

    public void setSubid(String subid) {
        this.subid = subid;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getSubHallno() {
        return subHallno;
    }

    public void setSubHallno(String subHallno) {
        this.subHallno = subHallno;
    }


    public void setSubtime(Time subtime) {
        this.subtime = subtime;
    }

    public SubjectDTO(String subid, String subname, String subHallno, LocalTime subtime) {
        this.subid = subid;
        this.subname = subname;
        this.subHallno = subHallno;
        this.subtime = Time.valueOf(subtime);
    }
}
