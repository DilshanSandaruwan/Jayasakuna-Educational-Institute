package lk.ijse.Jayasakuna.entity;

public class Employee {
    private String EmployeeID;
    private String EmployeeName;
    private String Address;
    private int PhoneNumber;

    public Employee() {
    }

    public Employee(String employeeID, String employeeName, String address, int phoneNumber) {
        EmployeeID = employeeID;
        EmployeeName = employeeName;
        Address = address;
        PhoneNumber = phoneNumber;
    }

    public Employee(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
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
        return "Employee{" +
                "EmployeeID='" + EmployeeID + '\'' +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                '}';
    }
}
