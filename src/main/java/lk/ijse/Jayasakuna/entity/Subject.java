package lk.ijse.Jayasakuna.entity;

import java.sql.Time;
import java.time.LocalTime;

public class Subject {
    private String SubjectID;
    private String SubjectName;
    private String HallNumber;
    private Time time;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Subject() {
    }

    public Subject(String subjectID, String subjectName, String hallNumber, Time time) {
        SubjectID = subjectID;
        SubjectName = subjectName;
        HallNumber = hallNumber;
        this.time = time;
    }

    public String getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(String subjectID) {
        SubjectID = subjectID;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public String getHallNumber() {
        return HallNumber;
    }

    public void setHallNumber(String hallNumber) {
        HallNumber = hallNumber;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "SubjectID='" + SubjectID + '\'' +
                ", SubjectName='" + SubjectName + '\'' +
                ", HallNumber='" + HallNumber + '\'' +
                '}';
    }
}
