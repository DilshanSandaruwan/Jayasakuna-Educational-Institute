package lk.ijse.Jayasakuna.entity;

public class Teaches {
    private String StudentID;
    private String TeacherID;

    public Teaches() {
    }

    public Teaches(String studentID, String teacherID) {
        StudentID = studentID;
        TeacherID = teacherID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String teacherID) {
        TeacherID = teacherID;
    }

    @Override
    public String toString() {
        return "Teaches{" +
                "StudentID='" + StudentID + '\'' +
                ", TeacherID='" + TeacherID + '\'' +
                '}';
    }
}
