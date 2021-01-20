package controller;

import bo.BoFactory;
import bo.custom.BooksBO;
import bo.custom.RegistrationBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.BooksDTO;
import dto.RegistrationDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

public class RegistrationFormController {

    public JFXButton btnSave;
    public JFXTextField txtregid;
    public JFXTextField txtmid;
    public JFXTextField txtregdate;
    public AnchorPane root;
    private RegistrationBO bo;

    public void initialize()throws Exception{
        bo= BoFactory.getInstance().getBo(BoFactory.BOType.REGISTRATION);
    }
    public void SaveOnActiion(ActionEvent actionEvent) {
        boolean isSaved= false;
        try {
            isSaved = bo.saveRegistration(new RegistrationDTO(txtregid.getText(),txtmid.getText(),txtregdate.getText()));
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"New Registration Is Added").show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"Added  Faill").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(isSaved);

    }
}
