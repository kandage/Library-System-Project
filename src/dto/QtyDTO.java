package dto;

public class QtyDTO {
    private String qtyID;
    private String qty;
    private String BoDeId;
    private String BID;
    private String BookName;
    private String FineAmount;

    public QtyDTO() {
    }

    public QtyDTO(String qtyID, String qty, String boDeId, String BID, String bookName, String fineAmount) {
        this.qtyID = qtyID;
        this.qty = qty;
        BoDeId = boDeId;
        this.BID = BID;
        BookName = bookName;
        FineAmount = fineAmount;
    }

    public String getQtyID() {
        return qtyID;
    }

    public void setQtyID(String qtyID) {
        this.qtyID = qtyID;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getBoDeId() {
        return BoDeId;
    }

    public void setBoDeId(String boDeId) {
        BoDeId = boDeId;
    }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getFineAmount() {
        return FineAmount;
    }

    public void setFineAmount(String fineAmount) {
        FineAmount = fineAmount;
    }

    @Override
    public String toString() {
        return "QtyDTO{" +
                "qtyID='" + qtyID + '\'' +
                ", qty='" + qty + '\'' +
                ", BoDeId='" + BoDeId + '\'' +
                ", BID='" + BID + '\'' +
                ", BookName='" + BookName + '\'' +
                ", FineAmount='" + FineAmount + '\'' +
                '}';
    }
}
