package lk.ijse.Jayasakuna.entity;

public class Studies {
    private String StudentID;
    private String SubjectID;
    private String SubjectName;

    public Studies() {
    }

    public Studies(String studentID, String subjectID, String subjectName) {
        StudentID = studentID;
        SubjectID = subjectID;
        SubjectName = subjectName;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
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

    @Override
    public String toString() {
        return "Studies{" +
                "StudentID='" + StudentID + '\'' +
                ", SubjectID='" + SubjectID + '\'' +
                ", SubjectName='" + SubjectName + '\'' +
                '}';
    }
}