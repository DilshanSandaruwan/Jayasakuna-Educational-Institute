package lk.ijse.Jayasakuna.dto;

public class StudiesDTO {
    private String studentId;
    private String subjectId;
    private String subjectName;

    public StudiesDTO(String studentId, String subjectId, String subjectName) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public StudiesDTO() {
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "StudiesDTO{" +
                "studentId='" + studentId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
