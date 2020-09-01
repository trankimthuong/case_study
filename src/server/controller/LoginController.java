package server.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import server.entities.AdminAccount;
import server.entities.GetData;

import java.io.IOException;
import java.util.ArrayList;



public class LoginController {
    GetData dataServer = new GetData();
    ArrayList<AdminAccount> adminAccounts = dataServer.getAdminAccount();
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;


    public void submitLogin(ActionEvent event) throws IOException {
        String userName = "\"" + txtUserName.getText() + "\"";
        String password = "\"" + txtPassword.getText() + "\"";
        boolean checkAccountServer = false;
        for (AdminAccount adminAccount: adminAccounts) {
            if(adminAccount.getName().equals(userName) && adminAccount.getPassword().equals(password)){
                checkAccountServer = true;
                break;
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(checkAccountServer) {
            changeDashboardView(event);
        }
        else {
            alert.setHeaderText("ERROR");
            alert.setContentText("Error!!! please check username and password");
            alert.show();
        }

    }

    public void changeDashboardView(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\view\\dashboard.fxml"));
        Parent dashboardView = loader.load();
        Scene scene = new Scene(dashboardView);
        stage.setTitle("Dashboard");
        stage.setScene(scene);
    }

    public void submitForgot(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("LOL");
        alert.setHeaderText("SonMC said: ");
        alert.setContentText("bố mày lạy mày...tài khoản còn quên...ca này từ chối hiểu");
        alert.show();
    }
}
