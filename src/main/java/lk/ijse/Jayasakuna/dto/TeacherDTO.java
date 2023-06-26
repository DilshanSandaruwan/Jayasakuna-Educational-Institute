package lk.ijse.Jayasakuna.dto;

public class TeacherDTO {
    public TeacherDTO(String sid) {
        this.sid = sid;
    }

    public TeacherDTO() {

    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public int getSphone() {
        return sphone;
    }

    public void setSphone(int sphone) {
        this.sphone = sphone;
    }

    private String sid;
    private String sname;
    private String saddress;
    private int sphone;

    public TeacherDTO(String id, String name, String address, int phone){
        this.sid = id;
        this.sname= name;
        this.saddress = address;
        this.sphone = phone;
    }

}
