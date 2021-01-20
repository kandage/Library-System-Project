package dto;

public class MembersDTO {
    private String MID;
    private String Name;
    private String Email;
    private String DOB;
    private String Mobile;
    private String Address;

    public MembersDTO() {
    }

    public MembersDTO(String MID, String name, String email, String DOB, String mobile, String address) {
        this.MID = MID;
        Name = name;
        Email = email;
        this.DOB = DOB;
        Mobile = mobile;
        Address = address;
    }



    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "MembersDTO{" +
                "MID='" + MID + '\'' +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", DOB='" + DOB + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
