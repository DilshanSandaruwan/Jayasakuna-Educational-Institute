package lk.ijse.Jayasakuna.entity;

public class Student {
    private String StudentID;
    private String StudentName;
    private String Address;
    private int PhoneNumber;

    public Student() {

    }

    public Student(String studentID, String studentName, String address, int phoneNumber) {
        StudentID = studentID;
        StudentName = studentName;
        Address = address;
        PhoneNumber = phoneNumber;
    }


    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
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
        return "Student{" +
                "StudentID='" + StudentID + '\'' +
                ", StudentName='" + StudentName + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                '}';
    }
}
