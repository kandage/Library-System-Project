package controller;

import bo.BoFactory;
import bo.custom.BooksBO;
import bo.custom.MembersBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DashBoardFormController {
    public AnchorPane root;
    public JFXButton btnManageBook;
    public JFXButton btnManageStudent;
    public JFXButton btnManagePayment;
    public JFXButton btnLogOut;
    public JFXButton btnGuarantee;
    public JFXDatePicker reportDate;
    public Label lblBookCount;
    public Label lblDate;
    public Label lblTime;
    public Label lblMembersCount;
    public JFXButton btnRegistration;
    public JFXButton btnReports;
    public JFXButton btnsetting;
    public Label lblmenu;
    public Label lbldescription;
    public ImageView imagebook;
    public ImageView imagemember;
    public ImageView imagepayment;
    public ImageView imageguarantee;
    public ImageView imagereports;

    BooksBO booksBO= BoFactory.getInstance().getBo(BoFactory.BOType.BOOKS);
    MembersBO membersBO=BoFactory.getInstance().getBo(BoFactory.BOType.MEMBERS);
    public void initialize(){
        setLblTime();
        try {
            lblBookCount.setText(String.valueOf(booksBO.getBookCount()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            lblMembersCount.setText(String.valueOf(membersBO.getMembersCount()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        genarateOrderDate();
        reportDate.setValue(LocalDate.now());
    }

    public void ManageBookOnAction(ActionEvent actionEvent) throws IOException {
        initUI("ManageBookForm.fxml");
    }
    public void genarateOrderDate() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String orderDate = sdf.format(date);
        lblDate.setText(orderDate);

    }
    public void setLblTime(){
        Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO, event -> {
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("hh:mm");
            lblTime.setText(LocalDateTime.now().format(formatter));}),
                new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void initUI(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/" + location)));
    }

    public void ManageStudentOnAction(ActionEvent actionEvent) throws IOException {
        initUI("ManageMembersForm.fxml");
    }

    public void ManagePaymentOnAction(ActionEvent actionEvent) throws IOException {
        initUI("ManagePaymentsForm.fxml");
    }

    public void LogOutOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void ManageGuaranteeOnAction(ActionEvent actionEvent) throws IOException {
        initUI("ManageGuranteeForm.fxml");
    }

    public void SaveOnAction(ActionEvent actionEvent) throws IOException {
        initUI("AddRegistration.fxml");
    }

    public void reportOnAction(ActionEvent actionEvent) throws IOException {
        initUI("ReportForm.fxml");
    }

    public void btnsettingOnAction(ActionEvent actionEvent) throws IOException {
        initUI("AddRegistration.fxml");
    }

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView){
            ImageView icon = (ImageView) mouseEvent.getSource();

            switch(icon.getId()){
                case "imagebook":
                    lblmenu.setText("Manage Customers");
                    lbldescription.setText("Click to add, edit, delete, search or view Books");
                    break;
                case "imagemember":
                    lblmenu.setText("Manage Items");
                    lbldescription.setText("Click to add, edit, delete, search or view Members");
                    break;
                case "imagepayment":
                    lblmenu.setText("Place Orders");
                    lbldescription.setText("Click to add, edit, delete, search or view Payments");
                    break;
                case "imageguarantee":
                    lblmenu.setText("Search Orders");
                    lbldescription.setText("Click to add, edit, delete, search or view Guarantee");
                    break;
                case "imagereports":
                    lblmenu.setText("Search Reports");
                    lbldescription.setText("Click The Button To Search And Print Reports");
                    break;
            }

        }
    }

    public void playMouseExitAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView){
            ImageView icon = (ImageView) mouseEvent.getSource();
            icon.setEffect(null);
            lblmenu.setText("Welcome");
            lbldescription.setText("Please select one of above main operations to proceed");
        }
    }
}
