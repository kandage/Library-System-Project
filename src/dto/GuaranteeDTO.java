package dto;

public class GuaranteeDTO {
    private String GID;
    private String RegID;
    private String GName;
    private String GType;
    private String Mobile;
    private String Address;
    private String Email;

    public GuaranteeDTO(String GID, String regID, String GName, String GType, String mobile, String address, String email) {
        this.GID = GID;
        RegID = regID;
        this.GName = GName;
        this.GType = GType;
        Mobile = mobile;
        Address = address;
        Email = email;
    }

    public GuaranteeDTO() {
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getRegID() {
        return RegID;
    }

    public void setRegID(String regID) {
        RegID = regID;
    }

    public String getGName() {
        return GName;
    }

    public void setGName(String GName) {
        this.GName = GName;
    }

    public String getGType() {
        return GType;
    }

    public void setGType(String GType) {
        this.GType = GType;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Guarantee{" +
                "GID='" + GID + '\'' +
                ", RegID='" + RegID + '\'' +
                ", GName='" + GName + '\'' +
                ", GType='" + GType + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Address='" + Address + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
