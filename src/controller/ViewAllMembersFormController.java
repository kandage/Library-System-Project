package controller;

import bo.BoFactory;
import bo.custom.MembersBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.MembersDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.MembersTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ViewAllMembersFormController {

    public AnchorPane root;
    public JFXButton btnBack;
    public TableView<MembersTM> tblMembers;
    public TableColumn colMID;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colDOB;
    public TableColumn colMobile;
    public TableColumn colAddress;
    public TableColumn colOperator;
    public JFXTextField txtMID;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtDOB;
    public JFXTextField txtMobile;
    public JFXTextField txtAddress;
    private MembersBO bo;
    public void initialize()throws Exception{
        bo= BoFactory.getInstance().getBo(BoFactory.BOType.MEMBERS);
        colMID.setCellValueFactory(new PropertyValueFactory("MID"));
        colName.setCellValueFactory(new PropertyValueFactory("Name"));
        colEmail.setCellValueFactory(new PropertyValueFactory("Email"));
        colDOB.setCellValueFactory(new PropertyValueFactory("DOB"));
        colMobile.setCellValueFactory(new PropertyValueFactory("Mobile"));
        colAddress.setCellValueFactory(new PropertyValueFactory("Address"));
        colOperator.setCellValueFactory(new PropertyValueFactory("btn"));
        loadAllMembers();
        tblMembers.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });

}

    private void setData(MembersTM tm) {
        txtMID.setText(tm.getMID());
        txtName.setText(tm.getName());
        txtEmail.setText(tm.getEmail());
        txtDOB.setText(tm.getEmail());
        txtMobile.setText(tm.getMobile());
        txtAddress.setText(tm.getAddress());

    }
    ObservableList<MembersTM> tmList = FXCollections.observableArrayList();
    private void loadAllMembers() throws Exception {
        tmList.clear();
        List<MembersDTO> allMembers = bo.getAllMembers();
        for (MembersDTO members : allMembers
        ) {
            Button btn = new Button("Delete");
            MembersTM tm = new MembersTM(members.getMID(),members.getName(),members.getEmail(),
                    members.getDOB(),members.getMobile(),members.getAddress(),btn);
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
                        if (bo.deleteMembers(tm.getMID())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllMembers();
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
        //System.out.println(tmList);
        tblMembers.setItems(tmList);

        for (int i = 0; i <tmList.size() -5; i++) {
            System.out.println(tmList);
        }


    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        try {
            boolean isUpdated = bo.updateMembers(
                    new MembersDTO(txtMID.getText(),txtName.getText(),txtEmail.getText(),txtDOB.getText(),txtMobile.getText(),txtAddress.getText()));
            if (isUpdated) {
                loadAllMembers();
                new Alert(Alert.AlertType.CONFIRMATION, "Updated Successfully",ButtonType.OK).show();
                loadAllMembers();
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
        MembersDTO members = bo.gettMembers(txtMID.getText());
        if (members != null) {
            txtMID.setText(members.getMID());
            txtName.setText(members.getName());
            txtEmail.setText(members.getEmail());
            txtDOB.setText(members.getDOB());
            txtMobile.setText(members.getMobile());
            txtAddress.setText(members.getAddress());
        }
    }
    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ManageMembersForm.fxml"))));
    }
}
