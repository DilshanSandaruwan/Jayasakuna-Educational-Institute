package lk.ijse.Jayasakuna.entity;

public class Teacher {
    private String TeacherID;
    private String TeacherName;
    private String Address;
    private int PhoneNumber;

    public Teacher() {
    }

    public Teacher(String teacherID, String teacherName, String address, int phoneNumber) {
        TeacherID = teacherID;
        TeacherName = teacherName;
        Address = address;
        PhoneNumber = phoneNumber;
    }

    public Teacher(String teacherID) {
        TeacherID = teacherID;
    }

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String teacherID) {
        TeacherID = teacherID;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "TeacherID='" + TeacherID + '\'' +
                ", TeacherName='" + TeacherName + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                '}';
    }
}
