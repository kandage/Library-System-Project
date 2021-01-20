package dto;

public class RegistrationDTO {
    private String RegId;
    private String MID;
    private String RegDate;

    public RegistrationDTO(String regId, String MID, String regDate) {
        RegId = regId;
        this.MID = MID;
        RegDate = regDate;
    }

    public RegistrationDTO() {
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
        return "RegistrationDTO{" +
                "RegId='" + RegId + '\'' +
                ", MID='" + MID + '\'' +
                ", RegDate='" + RegDate + '\'' +
                '}';
    }
}
