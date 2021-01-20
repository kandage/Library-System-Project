package controller;

import bo.BoFactory;
import bo.custom.AddRegistrationBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.AddRegDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class AddRegistrationFormController {
    public JFXTextField txtRegID;
    public JFXTextField GMobile;
    public JFXTextField GAddress;
    public JFXTextField GEmail;
    public JFXTextField txtRegDate;
    public AnchorPane btnRegister;
    public AnchorPane root;
    public JFXButton btnBack;
    @FXML
    private JFXTextField txtMID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtDOB;

    @FXML
    private JFXTextField txtMobile;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtPayID;

    @FXML
    private JFXTextField txtAmount;

    @FXML
    private JFXTextField txtPDate;

    @FXML
    private JFXTextField txtType;

    @FXML
    private JFXTextField txtGID;

    @FXML
    private JFXTextField txtGName;

    @FXML
    private JFXTextField GType;

    @FXML
    private JFXTextField txtREGID;
    public void initialize(){
        txtRegDate.setText(LocalDate.now().toString());
    }
    AddRegistrationBo aRBo = BoFactory.getInstance().getBo(BoFactory.BOType.ADDREG);

    public void RegistrationOnAction(MouseEvent mouseEvent) {
        
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(Pattern.compile("^(R)\\d{1,3}$").matcher(txtRegID.getText()).matches()){
            if(Pattern.compile("^(M)\\d{1,4}$").matcher(txtMID.getText()).matches()){
                if(Pattern.compile("^\\d{1,4}-\\d{1,2}-\\d{1,2}$").matcher(txtRegDate.getText()).matches()){
                    if (Pattern.compile("^[A-z, /]*\\b$").matcher(txtName.getText()).matches()) {
                        if (Pattern.compile("^[a-z]{1,20}(@)[a-z]{1,20}.[a-z]{1,20}$").matcher(txtEmail.getText()).matches()){
                            if(Pattern.compile("^\\d{1,4}-\\d{1,2}-\\d{1,2}$").matcher(txtDOB.getText()).matches()){
                                if(Pattern.compile("^\\d{10}$").matcher(txtMobile.getText()).matches()){
                                    if(Pattern.compile("^[A-z,|0-9:./]*\\b$").matcher(txtAddress.getText()).matches()){
                                        if(Pattern.compile("^(P)\\d{1,3}$").matcher(txtPayID.getText()).matches()){
                                            if (Pattern.compile("^[0-9](.)$").matcher(txtAmount.getText()).matches()) {

                                            }
                                        }else {
                                            txtPayID.setFocusColor(Paint.valueOf("red"));
                                            txtPayID.requestFocus();
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
                    txtRegDate.setFocusColor(Paint.valueOf("red"));
                    txtRegDate.requestFocus();
                }
            }else {
                txtMID.setFocusColor(Paint.valueOf("red"));
                txtMID.requestFocus();
            }
        }else {
            txtRegID.setFocusColor(Paint.valueOf("red"));
            txtRegID.requestFocus();
        }
        String reId = txtRegID.getText();
        String mid = txtMID.getText();
        String regDate = txtRegDate.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String dob = txtDOB.getText();
        String memberMobile = txtMobile.getText();
        String address = txtAddress.getText();
        String payId = txtPayID.getText();
        String amount = txtAmount.getText();
        String pDate = txtPDate.getText();
        String paymentType = txtType.getText();
        String Gid = txtGID.getText();
        String gName = txtGName.getText();
        String gType = GType.getText();
        String gMobile = GMobile.getText();
        String gAddress = GAddress.getText();
        String gEmail = GEmail.getText();

        try {
            aRBo.addReg(new AddRegDto(
                    mid,
                    reId,
                    regDate,
                    name,
                    email,
                    dob,
                    Integer.parseInt(memberMobile),
                    address,payId,Double.parseDouble(amount),
                    pDate, paymentType, Gid, gName, gType, gMobile, gAddress, gEmail
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void BackOnAction(ActionEvent actionEvent) throws IOException {
            Stage stage= (Stage) root.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml"))));
        }
}
