package controller;

import bo.BoFactory;
import bo.custom.BooksBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.BooksDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.BooksTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ViewAllBooksDetailsFormController {
    public JFXButton btnBack;
    public AnchorPane root;
    public TableView <BooksTM>tblBooks;
    public TableColumn colBID;
    public TableColumn colBookName;
    public TableColumn colTitle;
    public TableColumn colISBN;
    public TableColumn colLanguage;
    public TableColumn colCatagory;
    public TableColumn colAuthor;
    public TableColumn colPrice;
    public TableColumn colAddedDate;
    public TableColumn colOperator;
    public JFXButton btnUpdate;
    public JFXTextField txtBID;
    public JFXTextField txtBookName;
    public JFXTextField txtTitle;
    public JFXTextField txtISBN;
    public JFXTextField txtLanguage;
    public JFXTextField txtCatagory;
    public JFXTextField txtAuthor;
    public JFXTextField txtPrice;
    public JFXTextField txtAddedDate;
    private BooksBO bo;


    public void initialize()throws Exception{
        bo= BoFactory.getInstance().getBo(BoFactory.BOType.BOOKS);
        colBID.setCellValueFactory(new PropertyValueFactory<>("BID"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        colLanguage.setCellValueFactory(new PropertyValueFactory<>("Language"));
        colCatagory.setCellValueFactory(new PropertyValueFactory<>("Catagory"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colAddedDate.setCellValueFactory(new PropertyValueFactory<>("AddedDate"));
        colOperator.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadAllBooks();

        tblBooks.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });

    }

    private void setData(BooksTM tm) {
        txtBID.setText(tm.getBID());
        txtBookName.setText(tm.getBookName());
        txtTitle.setText(tm.getTitle());
        txtISBN.setText(tm.getISBN());
        txtLanguage.setText(tm.getLanguage());
        txtCatagory.setText(tm.getCatagory());
        txtAuthor.setText(tm.getAuthor());
        txtPrice.setText(tm.getPrice());
        txtAddedDate.setText(tm.getAddedDate());
    }
    ObservableList<BooksTM> tmList = FXCollections.observableArrayList();
    private void loadAllBooks() throws Exception {
        tmList.clear();
        List<BooksDTO> allBooks = bo.getAllBooks();
        for (BooksDTO books : allBooks
        ) {
            Button btn = new Button("Delete");
            BooksTM tm = new BooksTM(
                    books.getBID(),books.getBookName(),books.getTitle(),books.getISBN(),books.getLanguage(),books.getCatagory(),books.getAuthor(),books.getPrice(),books.getAddedDate(),btn
            );
            tmList.add(tm);
            btn.setOnAction((e) -> {
                try {

                    ButtonType ok = new ButtonType("OK",
                            ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO",
                            ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        if (bo.deleteBooks(tm.getBID())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllBooks();
                            return;
                        }
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.OK).show();
                    } else {
                    }


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }
        System.out.println(tmList);
        tblBooks.setItems(tmList);


    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ManageBookForm.fxml"))));
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        try {
            boolean isUpdated = bo.updateBooks(
                    new BooksDTO(txtBID.getText(),txtBookName.getText(),txtTitle.getText(),txtISBN.getText(),txtLanguage.getText(),txtCatagory.getText(),txtAuthor.getText(),txtPrice.getText(),txtAddedDate.getText()));
            if (isUpdated) {
                loadAllBooks();
                new Alert(Alert.AlertType.CONFIRMATION, "Updated Successfully",ButtonType.OK).show();
              loadAllBooks();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION, "Updated Fail !",ButtonType.OK).show();
                System.out.println(isUpdated);
            }
        }catch ( NullPointerException ex){

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDataOnAction(ActionEvent actionEvent) throws Exception {
        BooksDTO books = bo.getBook(txtBID.getText());
        if (books != null) {
            txtBID.setText(books.getBID());
            txtBookName.setText(books.getBookName());
            txtTitle.setText(books.getTitle());
            txtISBN.setText(books.getISBN());
            txtLanguage.setText(books.getLanguage());
            txtCatagory.setText(books.getCatagory());
            txtAuthor.setText(books.getAuthor());
            txtPrice.setText(books.getPrice());
            txtAddedDate.setText(books.getAddedDate());
        }
    }
}
