package controller;

import com.jfoenix.controls.JFXButton;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class ReportFormController {
    public AnchorPane root;
    public JFXButton btnReport;
    public JFXButton btnHome;
    public JFXButton btnincomeReport;
    public JFXButton btnmemberreport;
    public JFXButton btnbookreport;
    public JFXButton btngurrant;
    public JFXButton btnmonthlyincome;

    public void reportOnAction(ActionEvent actionEvent) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/reports/dailyBorrowReport.jasper");
            JasperPrint jp= JasperFillManager.fillReport(is,null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jp,false);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void HomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml"))));
    }

    public void btnincomeReportOnAction(ActionEvent actionEvent) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/reports/paymentReport.jasper");
            JasperPrint jp= JasperFillManager.fillReport(is,null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jp,false);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnmemberreportOnAction(ActionEvent actionEvent) {
    }

    public void btnbookreportOnAction(ActionEvent actionEvent) {
    }

    public void btngurrantreportOnAction(ActionEvent actionEvent) {
    }

    public void incomemonthlyOnAction(ActionEvent actionEvent) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/reports/monthlyPayment.jasper");
            JasperPrint jp= JasperFillManager.fillReport(is,null, DBConnection.getInstance().getConnection());
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
