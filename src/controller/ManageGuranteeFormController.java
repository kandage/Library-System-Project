package controller;

import bo.BoFactory;
import bo.custom.GuaranteeBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.BooksDTO;
import dto.GuaranteeDTO;
import entity.Guarantee;
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
import view.tm.GuaranteeTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ManageGuranteeFormController {
    public AnchorPane root;
    public JFXButton btnHome;
    public JFXButton btnSave;
    public JFXTextField txtName;
    public JFXTextField txtGtype;
    public JFXTextField txtMobile;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public TableView <GuaranteeTM>tblGuarantee;
    public TableColumn colGID;
    public TableColumn colName;
    public TableColumn colGType;
    public TableColumn colMobile;
    public TableColumn colAddress;
    public TableColumn colEmail;
    public TableColumn colOperator;
    public TableColumn colRegID;
    public JFXTextField txtGID;
    public JFXTextField txtRegID;
    public JFXButton btnUpdate;

    private GuaranteeBO bo;

    public void initialize()throws Exception{
        bo= BoFactory.getInstance().getBo(BoFactory.BOType.GUARANTEE);
        colGID.setCellValueFactory(new PropertyValueFactory<>("GID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colGType.setCellValueFactory(new PropertyValueFactory<>("GType"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colOperator.setCellValueFactory(new PropertyValueFactory<>("btn"));
        colRegID.setCellValueFactory(new PropertyValueFactory<>("RegID"));


        tblGuarantee.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });
        loadAllGuarantee();
    }

    private void setData(GuaranteeTM tm) {
        txtGID.setText(tm.getGID());
        txtName.setText(tm.getGName());
        txtGtype.setText(tm.getGType());
        txtMobile.setText(tm.getMobile());
        txtAddress.setText(tm.getAddress());
        txtEmail.setText(tm.getEmail());
        txtRegID.setText(tm.getRegId());
    }
    ObservableList<GuaranteeTM> tmList = FXCollections.observableArrayList();
    private void loadAllGuarantee() throws Exception {
        tmList.clear();
        List<GuaranteeDTO> AllGuarantee = bo.getAllGuarantee();
        for (GuaranteeDTO guarantee : AllGuarantee
        ) {
            Button btn = new Button("Delete");
            GuaranteeTM tm = new GuaranteeTM(
                    guarantee.getGID(),guarantee.getRegID(),
                    guarantee.getGName(),guarantee.getGType(),
                    guarantee.getMobile(),guarantee.getAddress(),guarantee.getEmail(),btn
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
                        if (bo.deleteGuarantee(tm.getGID())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllGuarantee();
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
        tblGuarantee.setItems(tmList);


    }

    public void HomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml"))));
    }

    public void SaveOnActiion(ActionEvent actionEvent) {
        boolean isSaved= false;
        try {
            isSaved = bo.saveGuarantee(new GuaranteeDTO(txtGID.getText(),txtRegID.getText(),txtName.getText(),txtGtype.getText(),txtMobile.getText(),txtAddress.getText(),txtEmail.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(isSaved);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"New Member Is Added").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Added  Faill").show();
        }
    }

    public void UpdateOnActiion(ActionEvent actionEvent) {
        try {
            boolean isUpdated = bo.updateGuarantee(
                    new GuaranteeDTO(txtGID.getText(),txtRegID.getText(),txtName.getText(),txtGtype.getText(),txtMobile.getText(),txtAddress.getText(),txtEmail.getText()));
            if (isUpdated) {
                loadAllGuarantee();
                new Alert(Alert.AlertType.CONFIRMATION, "Updated Successfully",ButtonType.OK).show();
                loadAllGuarantee();
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
        GuaranteeDTO guarantee = bo.getGuarantee(txtGID.getText());
        if (guarantee != null) {
            txtGID.setText(guarantee.getGID());
            txtRegID.setText(guarantee.getRegID());
            txtName.setText(guarantee.getGName());
            txtGtype.setText(guarantee.getGType());
            txtMobile.setText(guarantee.getMobile());
            txtAddress.setText(guarantee.getAddress());
            txtEmail.setText(guarantee.getEmail());
        }
    }
}
