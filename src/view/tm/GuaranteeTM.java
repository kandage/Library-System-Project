package view.tm;

import javafx.scene.control.Button;

public class GuaranteeTM {
    private String GID;
    private String RegId;
    private String GName;
    private String  GType;
    private String Mobile;
    private String Address;
    private String Email;
    private Button btn;

    public GuaranteeTM() {
    }

    public GuaranteeTM(String GID, String regId, String GName, String GType, String mobile, String address, String email, Button btn) {
        this.GID = GID;
        RegId = regId;
        this.GName = GName;
        this.GType = GType;
        Mobile = mobile;
        Address = address;
        Email = email;
        this.btn = btn;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getRegId() {
        return RegId;
    }

    public void setRegId(String regId) {
        RegId = regId;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "GuaranteeTM{" +
                "GID='" + GID + '\'' +
                ", RegId='" + RegId + '\'' +
                ", GName='" + GName + '\'' +
                ", GType='" + GType + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Address='" + Address + '\'' +
                ", Email='" + Email + '\'' +
                ", btn=" + btn +
                '}';
    }
}
