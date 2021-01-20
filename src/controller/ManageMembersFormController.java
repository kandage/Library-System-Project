package controller;

import bo.BoFactory;
import bo.custom.MembersBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.MembersDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.regex.Pattern;

public class ManageMembersFormController {

    public JFXButton btnHome;
    public AnchorPane root;
    public JFXButton btnViewAllStudents;
    public JFXTextField txtMID;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtDOB;
    public JFXTextField txtMobile;
    public JFXTextField txtAddress;
    public JFXButton btnSaveOnActiion;
    public JFXButton btnClear;
    private MembersBO bo;
    public void initialize()throws Exception{
        bo= BoFactory.getInstance().getBo(BoFactory.BOType.MEMBERS);
    }

    public void HomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml"))));
    }

    public void ViewAllStudentOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ViewAllMembersForm.fxml"))));
    }
    public void SaveOnActiion(ActionEvent actionEvent) throws Exception {
        if(Pattern.compile("^(M)\\d{1,4}$").matcher(txtMID.getText()).matches()){
            if (Pattern.compile("^[A-z, /]*\\b$").matcher(txtName.getText()).matches()) {
                if (Pattern.compile("^[a-z]{1,20}(@)[a-z]{1,20}.[a-z]{1,20}$").matcher(txtEmail.getText()).matches()){
                    if(Pattern.compile("^\\d{1,4}-\\d{1,2}-\\d{1,2}$").matcher(txtDOB.getText()).matches()){
                        if(Pattern.compile("^\\d{10}$").matcher(txtMobile.getText()).matches()){
                            if(Pattern.compile("^[A-z,|0-9:./]*\\b$").matcher(txtAddress.getText()).matches()){
                                boolean isSaved = bo.saveMembers(new MembersDTO(txtMID.getText(),txtName.getText(),txtEmail.getText(),
                                        txtDOB.getText(),
                                        txtMobile.getText(),txtAddress.getText()));
                                clearFealds();
                                if (isSaved){
                                    new Alert(Alert.AlertType.CONFIRMATION,"New Member Is Added").show();
                                }else {
                                    new Alert(Alert.AlertType.CONFIRMATION,"Added Success Faill").show();
                                }
                            }else {
                                txtAddress.setFocusColor(Paint.valueOf("red"));
                                txtAddress.requestFocus();
                            }
                        }else {
                            txtMobile.setFocusColor(Paint.valueOf("red"));
                            txtMobile.requestFocus();
                        }
                    }else {
                        txtDOB.setFocusColor(Paint.valueOf("red"));
                        txtDOB.requestFocus();
                    }

                }else {
                    txtEmail.setFocusColor(Paint.valueOf("red"));
                    txtEmail.requestFocus();
                }

            }else {
                txtName.setFocusColor(Paint.valueOf("red"));
                txtName.requestFocus();
            }

        }else {
            txtMID.setFocusColor(Paint.valueOf("red"));
            txtMID.requestFocus();
        }

    }

    private void clearFealds() {
        txtMID.clear();
        txtName.clear();
        txtEmail.clear();
        txtDOB.clear();
        txtMobile.clear();
        txtAddress.clear();
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        txtMID.clear();
        txtName.clear();
        txtEmail.clear();
        txtDOB.clear();
        txtMobile.clear();
        txtAddress.clear();
    }
}
