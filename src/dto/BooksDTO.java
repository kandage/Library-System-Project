package dto;

public class BooksDTO {
    private String BID;
    private String BookName;
    private String Title;
    private String ISBN;
    private String Language;
    private String Catagory;
    private String Author;
    private String Price;

    public BooksDTO() {
    }

    public BooksDTO(String BID, String bookName, String title, String ISBN, String language, String catagory, String author, String price, String addedDate) {
        this.BID = BID;
        BookName = bookName;
        Title = title;
        this.ISBN = ISBN;
        Language = language;
        Catagory = catagory;
        Author = author;
        Price = price;
        AddedDate = addedDate;
    }

    private String AddedDate;

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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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

    public String getCatagory() {
        return Catagory;
    }

    public void setCatagory(String catagory) {
        Catagory = catagory;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getAddedDate() {
        return AddedDate;
    }

    public void setAddedDate(String addedDate) {
        AddedDate = addedDate;
    }

    @Override
    public String toString() {
        return "BooksDTO{" +
                "BID='" + BID + '\'' +
                ", BookName='" + BookName + '\'' +
                ", Title='" + Title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", Language='" + Language + '\'' +
                ", Catagory='" + Catagory + '\'' +
                ", Author='" + Author + '\'' +
                ", Price='" + Price + '\'' +
                ", AddedDate='" + AddedDate + '\'' +
                '}';
    }
}
