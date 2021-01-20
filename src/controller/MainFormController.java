package controller;

import com.jfoenix.controls.JFXPasswordField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MainFormController {
    public TextField txtemail;
    public Button btnlogin;
    public Label txtdate;
    public JFXPasswordField txtPW;
    public Label lblTime;

    public void genarateOrderDate() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String orderDate = sdf.format(date);
        txtdate.setText(orderDate);

    }
    public void setLblTime(){
        Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO,event -> {
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("hh:mm");
            lblTime.setText(LocalDateTime.now().format(formatter));}),
                new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    public void initialize() throws Exception {
        genarateOrderDate();
        setLblTime();
    }
        public void btnLogin(ActionEvent actionEvent) throws IOException {
        String email = txtemail.getText().trim();
        String password = txtPW.getText().trim();

        if (email.length()>0 && password.length()>0){

            if (email.equalsIgnoreCase("library@gmail.com")
                    && password.equalsIgnoreCase("library")){


                URL resource = this.getClass().
                        getResource("/view/DashBoardForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene= new Scene(load);
                Stage stage= new Stage();
                stage.setScene(scene);
                stage.show();
                txtemail.clear();
                txtPW.clear();

            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again !!!!",
                        ButtonType.OK,ButtonType.NO).show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty !!!!",
                    ButtonType.OK,ButtonType.NO).show();
        }

    }

    public void logingOnAction(ActionEvent actionEvent) throws IOException {
       /* if (Pattern.compile("^[a-z]{1,20}(@)[a-z]{1,20}.[a-z]{1,20}$").matcher(txtemail.getText()).matches()){

        }else {
            txtemail.setFocusColor(Paint.valueOf("red"));
            txtemail.requestFocus();
        }*/
        String email = txtemail.getText().trim();
        String password = txtPW.getText().trim();

        if (email.length()>0 && password.length()>0){

            if (email.equalsIgnoreCase("library@gmail.com")
                    && password.equalsIgnoreCase("library")){


                URL resource = this.getClass().
                        getResource("/view/DashBoardForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene= new Scene(load);
                Stage stage= new Stage();
                stage.setScene(scene);
                stage.show();
                txtemail.clear();
                txtPW.clear();

            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again !!!!",
                        ButtonType.OK,ButtonType.NO).show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty !!!!",
                    ButtonType.OK,ButtonType.NO).show();
        }
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }
}
