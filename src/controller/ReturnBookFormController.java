package controller;

import bo.BoFactory;
import bo.custom.BorrowDetailBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.BorrowDetailDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

public class ReturnBookFormController {
    public AnchorPane root;
    public JFXButton btnBack;
    public JFXTextField txtbodeid;
    public JFXTextField txtrid;
    public JFXButton btnprint;
    @FXML
    private JFXTextField txtBID;
    @FXML
    private JFXTextField txtISBN;
    @FXML
    private JFXTextField txtLanguage;
    @FXML
    private JFXTextField txtIssueDate;
    @FXML
    private JFXTextField txtDueToReturn;
    @FXML
    private JFXTextField txtReturnDate;

    @FXML
    private JFXTextField txtExpireDates;

    @FXML
    private JFXTextField txtMID;

    @FXML
    private JFXTextField txtMName;

    @FXML
    private JFXButton btnReturn;

    @FXML
    private JFXTextField txtFine;
    private BorrowDetailBO bo;


    public void initialize()throws Exception {
        bo = BoFactory.getInstance().getBo(BoFactory.BOType.ISSUEBOOKS);
        txtReturnDate.setText(LocalDate.now().toString());
    }

    @FXML
    void ReturnOnAction(ActionEvent event) {
        try {
            boolean isUpdated = bo.updateIssueBook(
                    new BorrowDetailDTO(txtbodeid.getText(),txtrid.getText(),txtBID.getText(),txtISBN.getText(),txtLanguage.getText(),txtIssueDate.getText(),txtDueToReturn.getText(),txtReturnDate.getText(),txtExpireDates.getText(),Double.parseDouble(txtFine.getText())));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Thank you for with us", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION, "plese enter correct details !",ButtonType.OK).show();
                System.out.println(isUpdated);
            }
        }catch ( NullPointerException ex){

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void fine(){

    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ManageBookForm.fxml"))));
    }

    public void getDataOnAction(ActionEvent actionEvent) {
        try {
            BorrowDetailDTO borrow=bo.gettIssueBook(txtbodeid.getText());
            if (borrow != null){
                txtbodeid.setText(borrow.getBODeId());
                txtrid.setText(borrow.getRegId());
                txtBID.setText(borrow.getBookID());
                txtISBN.setText(borrow.getISBN());
                txtLanguage.setText(borrow.getLanguage());
                txtIssueDate.setText(borrow.getIssueDate());
                txtDueToReturn.setText(borrow.getDueToReturn());
                txtReturnDate.setText(borrow.getReturnDate());
                txtExpireDates.setText(borrow.getExpiringDate());
                txtFine.setText(borrow.getFine()+"");
            }
            txtReturnDate.setText(LocalDate.now().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printOnAction(ActionEvent actionEvent) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/reports/BorrowReport.jrxml");
            JasperReport jr= JasperCompileManager.compileReport(is);
            HashMap hm=new HashMap();
            hm.put("BoDeId",txtbodeid.getText());
            hm.put("RegId",txtrid.getText());
            hm.put("BID",txtBID.getText());
            hm.put("ISBN",txtISBN.getText());
            hm.put("Language",txtLanguage.getText());
            hm.put("IssueDate",txtIssueDate.getText());
            hm.put("DueReturn",txtDueToReturn.getText());
            hm.put("ReturnDate",txtReturnDate.getText());
            hm.put("ExpringDate",txtExpireDates.getText());
            hm.put("FineTotPrice",txtFine.getText());


            JasperPrint jp= JasperFillManager.fillReport(jr,hm, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jp,false);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
