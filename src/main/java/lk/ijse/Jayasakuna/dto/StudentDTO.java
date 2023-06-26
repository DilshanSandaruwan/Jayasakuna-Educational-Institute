package lk.ijse.Jayasakuna.dto;
public class StudentDTO {
    public StudentDTO(String sid) {
        this.sid = sid;
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

    public StudentDTO(String sid, String sname, String saddress, int sphone) {
        this.sid = sid;
        this.sname = sname;
        this.saddress = saddress;
        this.sphone = sphone;
    }

    private String sid;
    private String sname;
    private String saddress;
    private int sphone;

}
