package controller;

import bo.BoFactory;
import bo.custom.BooksBO;
import bo.custom.BorrowDetailBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.BooksDTO;
import dto.BorrowDetailDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class IssueBookFormController {
    public AnchorPane root;
    public JFXButton btnBack;
    public JFXComboBox cmbBookId;
    public JFXTextField txtIssueDate;
    public JFXTextField txtDueToReturn;
    public JFXTextField txtReturnDate;
    public JFXTextField txtExpiaringDates;
    public JFXTextField txtFine;
    public JFXButton btnBorrow;
    public JFXTextField txtBookName;
    public JFXTextField txtIsbn;
    public JFXTextField txtLanguage;
    public JFXTextField txtBoDeId;
    public JFXTextField txtRegId;

    BooksBO Bbo = BoFactory.getInstance().getBo(BoFactory.BOType.BOOKS);
    BorrowDetailBO brbo=BoFactory.getInstance().getBo(BoFactory.BOType.ISSUEBOOKS);
    public void initialize(){
        getBookId();
        txtFine.setText("120");
        String oldDate = String.valueOf(LocalDate.now());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();

        generateDate();

        //Number of Days to add
        //c.add(date, 7);
    }

    public void generateDate(){
        //Given Date in String format
       // String oldDate = "2017-01-29";
        String oldDate = String.valueOf(LocalDate.now());
        System.out.println("Date before Addition: "+oldDate);
        //Specifying date format that matches the given date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try{
            //Setting the date to the given date
            c.setTime(sdf.parse(oldDate));
        }catch(ParseException e){
            e.printStackTrace();
        }

        //Number of Days to add
        c.add(Calendar.DAY_OF_MONTH, 7);
        //Date after adding the days to the given date
        String newDate = sdf.format(c.getTime());
        //Displaying the new Date after addition of Days
        txtDueToReturn.setText(newDate);
        txtIssueDate.setText(oldDate);
        System.out.println("Date after Addition: "+newDate);
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ManageBookForm.fxml"))));
    }

    public void getBookId(){
        try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            ArrayList<String> idList = Bbo.getBookId();

            for(String s : idList){
                obList.add(s);
            }

            cmbBookId.setItems(obList);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cmbGetBookOnAction(ActionEvent actionEvent) {
        String s = String.valueOf(cmbBookId.getValue());

        try {
            BooksDTO dto = Bbo.getBook(s);
            txtBookName.setText(dto.getBookName());
            txtLanguage.setText(dto.getLanguage());
            txtIsbn.setText(dto.getISBN());
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e);
        }
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        boolean isSaved= false;
        try {
            isSaved = brbo.saveIssueBook(new BorrowDetailDTO(
                    txtBoDeId.getText(),
                    txtRegId.getText(),
                    String.valueOf(cmbBookId.getValue()),
                    txtIsbn.getText(),
                    txtLanguage.getText(),
                    txtIssueDate.getText(),
                    txtDueToReturn.getText(),
                    txtReturnDate.getText(),
                    txtExpiaringDates.getText(),
                    Double.parseDouble(txtFine.getText())));

            System.out.println(isSaved);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Book Is Issued").show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"Try Again").show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
