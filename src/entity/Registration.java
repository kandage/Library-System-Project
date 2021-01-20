package entity;

public class Registration implements SuperEntity {
    private String RegId;
    private String MID;
    private String RegDate;

    public Registration(String regId, String MID, String regDate) {
        RegId = regId;
        this.MID = MID;
        RegDate = regDate;
    }

    public Registration() {
    }

    public String getRegId() {
        return RegId;
    }

    public void setRegId(String regId) {
        RegId = regId;
    }

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "RegId='" + RegId + '\'' +
                ", MID='" + MID + '\'' +
                ", RegDate='" + RegDate + '\'' +
                '}';
    }
}
