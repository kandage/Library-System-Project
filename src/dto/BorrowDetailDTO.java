package dto;

public class BorrowDetailDTO {
    private String BODeId;
    private String RegId;
    private String BookID;
    private String ISBN;
    private String Language;
    private String IssueDate;
    private String DueToReturn;
    private String ReturnDate;
    private String ExpiringDate;
    private double Fine;

    public BorrowDetailDTO() {
    }

    public BorrowDetailDTO(String BODeId, String regId, String bookID, String ISBN, String language, String issueDate, String dueToReturn, String returnDate, String expiringDate, double fine) {
        this.setBODeId(BODeId);
        setRegId(regId);
        setBookID(bookID);
        this.setISBN(ISBN);
        setLanguage(language);
        setIssueDate(issueDate);
        setDueToReturn(dueToReturn);
        setReturnDate(returnDate);
        setExpiringDate(expiringDate);
        setFine(fine);
    }

    public String getBODeId() {
        return BODeId;
    }

    public void setBODeId(String BODeId) {
        this.BODeId = BODeId;
    }

    public String getRegId() {
        return RegId;
    }

    public void setRegId(String regId) {
        RegId = regId;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(String issueDate) {
        IssueDate = issueDate;
    }

    public String getDueToReturn() {
        return DueToReturn;
    }

    public void setDueToReturn(String dueToReturn) {
        DueToReturn = dueToReturn;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }

    public String getExpiringDate() {
        return ExpiringDate;
    }

    public void setExpiringDate(String expiringDate) {
        ExpiringDate = expiringDate;
    }

    public double getFine() {
        return Fine;
    }

    public void setFine(double fine) {
        Fine = fine;
    }
}
