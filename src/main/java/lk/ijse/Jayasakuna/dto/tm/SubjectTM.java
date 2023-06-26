package lk.ijse.Jayasakuna.dto.tm;

import java.sql.Time;
import java.time.LocalTime;

public class SubjectTM {
    public SubjectTM(String subjectID, String subjectName, String hallNumber, Time time) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHallNo() {
        return hallNo;
    }

    public void setHallNo(String hallNo) {
        this.hallNo = hallNo;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    private String id;
    private String name;
    private String hallNo;
    private Time time;

    public SubjectTM(String id, String name, String hallNo, LocalTime time){
        this.id = id;
        this.name= name;
        this.hallNo = hallNo;
        this.time = Time.valueOf(time);
    }

}
