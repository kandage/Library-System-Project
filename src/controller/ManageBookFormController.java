package controller;

import bo.BoFactory;
import bo.custom.BooksBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.BooksDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class ManageBookFormController {
    public AnchorPane root;
    public JFXButton btnHome;
    public JFXButton btnReturnBook;
    public JFXButton btnIssueBook;
    public JFXButton btnSave;
    public JFXTextField txtBID;
    public JFXTextField txtBookName;
    public JFXTextField txtTitle;
    public JFXTextField txtISBN;
    public JFXTextField txtLanguage;
    public JFXTextField txtCatagory;
    public JFXTextField txtAuthor;
    public JFXTextField txtPrice;
    public JFXTextField txtAddedDate;
    public JFXButton btnViewAllBooksDetails;
    public JFXButton btnClear;
    private BooksBO bo;

    public void initialize()throws Exception{
        bo=BoFactory.getInstance().getBo(BoFactory.BOType.BOOKS);
    }
    public void HomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml"))));
    }

    public void ReturnBookOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ReturnBookForm.fxml"))));
    }

    public void IssueBookOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/IssueBookForm.fxml"))));
    }

    public void SaveOnActiion(ActionEvent actionEvent) throws Exception {
        if(Pattern.compile("^(BK)\\d{1,3}$").matcher(txtBID.getText()).matches()){
            if (Pattern.compile("^[A-z, /]*\\b$").matcher(txtBookName.getText()).matches()) {
                if (Pattern.compile("^[A-z, /]*\\b$").matcher(txtTitle.getText()).matches()) {
                    if(Pattern.compile("^\\d{10}$").matcher(txtISBN.getText()).matches()){
                        if (Pattern.compile("^[A-z, /]*\\b$").matcher(txtLanguage.getText()).matches()) {
                            if (Pattern.compile("^[A-z, /]*\\b$").matcher(txtCatagory.getText()).matches()) {
                                if (Pattern.compile("^[A-z, /]*\\b$").matcher(txtAuthor.getText()).matches()) {
                                    if (Pattern.compile("^[0-9](.)$").matcher(txtPrice.getText()).matches()) {
                                        if(Pattern.compile("^\\d{1,4}-\\d{1,2}-\\d{1,2}$").matcher(txtAddedDate.getText()).matches()){
                                            boolean isSaved=bo.saveBooks(new BooksDTO(txtBID.getText(),txtBookName.getText(),txtTitle.getText(),txtISBN.getText(),txtLanguage.getText(),txtCatagory.getText(),txtAuthor.getText(),txtPrice.getText(),txtAddedDate.getText()));
                                            System.out.println(isSaved);
                                            clear();
                                            if (isSaved){
                                                new Alert(Alert.AlertType.CONFIRMATION,"New Book Is Added").show();
                                            }else {
                                                new Alert(Alert.AlertType.CONFIRMATION,"Added Success Faill").show();
                                            }
                                        }else {
                                            txtAddedDate.setFocusColor(Paint.valueOf("red"));
                                            txtAddedDate.requestFocus();
                                        }
                                    }else {
                                        txtPrice.setFocusColor(Paint.valueOf("red"));
                                        txtPrice.requestFocus();
                                    }
                                }else {
                                    txtAuthor.setFocusColor(Paint.valueOf("red"));
                                    txtAuthor.requestFocus();
                                }
                            }else {
                                txtCatagory.setFocusColor(Paint.valueOf("red"));
                                txtCatagory.requestFocus();
                            }
                        }else {
                            txtLanguage.setFocusColor(Paint.valueOf("red"));
                            txtLanguage.requestFocus();
                        }
                    }else {
                        txtISBN.setFocusColor(Paint.valueOf("red"));
                        txtISBN.requestFocus();
                    }

                }else {
                    txtTitle.setFocusColor(Paint.valueOf("red"));
                    txtTitle.requestFocus();
                }
            }else {
                txtBookName.setFocusColor(Paint.valueOf("red"));
                txtBookName.requestFocus();
            }
        }else {
            txtBID.setFocusColor(Paint.valueOf("red"));
            txtBID.requestFocus();
        }

    }

    public void ViewAllBooksDetailsOnAction(ActionEvent actionEvent) throws IOException {
            Stage stage= (Stage) root.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ViewAllBooksDetailsForm.fxml"))));
        }
        public void clear(){
            txtBID.clear();
            txtBookName.clear();
            txtTitle.clear();
            txtISBN.clear();
            txtLanguage.clear();
            txtCatagory.clear();
            txtAuthor.clear();
            txtPrice.clear();
            txtAddedDate.clear();

        }
    public void ClearOnAction(ActionEvent actionEvent) {
        txtBID.clear();
        txtBookName.clear();
        txtTitle.clear();
        txtISBN.clear();
        txtLanguage.clear();
        txtCatagory.clear();
        txtAuthor.clear();
        txtPrice.clear();
        txtAddedDate.clear();
    }

    public void saveOnAction(ActionEvent actionEvent) {
        boolean isSaved= false;
        try {
            isSaved = bo.saveBooks(new BooksDTO(txtBID.getText(),txtBookName.getText(),txtTitle.getText(),txtISBN.getText(),txtLanguage.getText(),txtCatagory.getText(),txtAuthor.getText(),txtPrice.getText(),txtAddedDate.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(isSaved);
        clear();
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"New Book Is Added").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Added Success Faill").show();
        }
    }
}
