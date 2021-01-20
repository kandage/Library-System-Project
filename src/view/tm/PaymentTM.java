package view.tm;

import javafx.scene.control.Button;

public class PaymentTM {
    private String PayID;
    private String RegId;
    private String Amount;
    private String PDate;
    private String Type;
    private Button btn;

    public PaymentTM() {
    }

    public PaymentTM(String payID, String regId, String amount, String PDate, String type, Button btn) {
        PayID = payID;
        RegId = regId;
        Amount = amount;
        this.PDate = PDate;
        Type = type;
        this.btn = btn;
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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "PaymentTM{" +
                "PayID='" + PayID + '\'' +
                ", RegId='" + RegId + '\'' +
                ", Amount='" + Amount + '\'' +
                ", PDate='" + PDate + '\'' +
                ", Type='" + Type + '\'' +
                ", btn=" + btn +
                '}';
    }
}
