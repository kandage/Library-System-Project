package entity;

public class Payment implements SuperEntity{
    private String PayID;
    private String RegId;
    private String Amount;
    private String PDate;
    private String PayType;

    public Payment(String payID, String regId, String amount, String PDate, String payType) {
        PayID = payID;
        RegId = regId;
        Amount = amount;
        this.PDate = PDate;
        PayType = payType;
    }

    public Payment() {
    }

    public String getPayID() {
        return PayID;
    }

    public void setPayID(String payID) {
        PayID = payID;
    }

    public String getRegId() {
        return RegId;
    }

    public void setRegId(String regId) {
        RegId = regId;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getPDate() {
        return PDate;
    }

    public void setPDate(String PDate) {
        this.PDate = PDate;
    }

    public String getPayType() {
        return PayType;
    }

    public void setPayType(String payType) {
        PayType = payType;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "PayID='" + PayID + '\'' +
                ", RegId='" + RegId + '\'' +
                ", Amount='" + Amount + '\'' +
                ", PDate='" + PDate + '\'' +
                ", PayType='" + PayType + '\'' +
                '}';
    }
}
