package controller;

import bo.BoFactory;
import bo.custom.PaymentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.BooksDTO;
import dto.PaymentDTO;
import dto.PaymentDTO;
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
import view.tm.PaymentTM;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ManagePaymentsFormController {
    public AnchorPane root;
    public JFXButton btnHome;
    public JFXButton btnUpdate;
    public JFXButton btnSaveOnActiion;
    public JFXTextField txtPayId;
    public JFXTextField txtAmount;
    public JFXTextField txtPDate;
    public JFXTextField txtType;
    public JFXTextField txtRegid;
    public TableView <PaymentTM> tblPayments;
    public TableColumn colPayID;
    public TableColumn colAmount;
    public TableColumn colType;
    public TableColumn colOperator;
    public TableColumn colRegId;
    public TableColumn colPayDate;
    private PaymentBO bo;

    public void initialize()throws Exception{
        bo= BoFactory.getInstance().getBo(BoFactory.BOType.PAYMENT);
        colPayID.setCellValueFactory(new PropertyValueFactory<>("PayID"));
        colRegId.setCellValueFactory(new PropertyValueFactory<>("RegId"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        colPayDate.setCellValueFactory(new PropertyValueFactory<>("PDate"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colOperator.setCellValueFactory(new PropertyValueFactory<>("btn"));

        tblPayments.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });
        txtPDate.setText(LocalDate.now().toString());
        loadAllPayment();


    }
    private void setData(PaymentTM tm) {
        txtPayId.setText(tm.getPayID());
        txtRegid.setText(tm.getRegId());
        txtAmount.setText(tm.getAmount());
        txtPDate.setText(tm.getPDate());
        txtType.setText(tm.getType());
    }
    ObservableList<PaymentTM> tmList = FXCollections.observableArrayList();

    private void loadAllPayment() throws Exception {
        tmList.clear();
        List<PaymentDTO> allPayment = bo.getAllPayment();
        for (PaymentDTO payment : allPayment
        ) {
            Button btn = new Button("Delete");
            PaymentTM tm=new PaymentTM(payment.getPayID(),
                    payment.getRegId(),payment.getAmount(),payment.getPDate(),payment.getPayType(),btn);
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
                        if (bo.deletePayment(tm.getPayID())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllPayment();
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
        tblPayments.setItems(tmList);


    }

    public void HomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml"))));
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        try {
            boolean isUpdated = bo.updatePayment(
                    new PaymentDTO(txtPayId.getText(),txtRegid.getText(),txtAmount.getText(),txtPDate.getText(),txtType.getText()));
            if (isUpdated) {
                loadAllPayment();
                new Alert(Alert.AlertType.CONFIRMATION, "Updated Successfully",ButtonType.OK).show();
                loadAllPayment();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION, "Updated Fail !",ButtonType.OK).show();
                System.out.println(isUpdated);
            }
        }catch ( NullPointerException ex){

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clear(){
        txtPayId.clear();
        txtRegid.clear();
        txtAmount.clear();
        txtPDate.clear();
        txtType.clear();

    }
    public void SaveOnActiion(ActionEvent actionEvent) {
        try {
            boolean isSaved = bo.savePayment(new PaymentDTO(txtPayId.getText(),txtRegid.getText(),txtAmount.getText(),txtPDate.getText(),txtType.getText()));
            System.out.println(isSaved);
            loadAllPayment();
            clear();
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"New Payment IsAdded").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getDataOnAction(ActionEvent actionEvent) {
        PaymentDTO payment = null;
        try {
            payment = bo.gettPayment(txtPayId.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (payment != null) {
            txtPayId.setText(payment.getPayID());
            txtRegid.setText(payment.getRegId());
            txtAmount.setText(payment.getAmount());
            txtPDate.setText(payment.getPDate());
            txtType.setText(payment.getPayType());

        }
    }
}
