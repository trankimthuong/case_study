package server.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import server.entities.GetData;
import server.entities.Client;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    GetData dataServer = new GetData();
    ArrayList<Client> clientsFromServer = dataServer.getClients();

    @FXML
    private TableView<Client> table;

    @FXML
    private TableColumn<Client, Long> accNumberColumn;
    @FXML
    private TableColumn<Client, String> nameColumn;
    @FXML
    private TableColumn<Client, Double> balanceColumn;
    @FXML
    private TextField txtAccNumber;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtBalance;

    //dung observableList de khi them hoac xoa se tu dong cap nhat!!!!!!!!!
    private ObservableList<Client> clients;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clients = FXCollections.observableArrayList(
            clientsFromServer
        );
        accNumberColumn.setCellValueFactory(new PropertyValueFactory<Client, Long>("accNumber"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        balanceColumn.setCellValueFactory(new PropertyValueFactory<Client, Double>("balance"));

        table.setItems(clients);
    }

    public void add(ActionEvent event){
        Client newStaff = new Client();
        String accNumber = txtAccNumber.getText().trim();
        String name = txtName.getText().trim();
        String balance = txtBalance.getText().trim();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Error");
        if(accNumber.isEmpty() || name.isEmpty() || balance.isEmpty()){
            alert.setContentText("All of textfield shouldn't empty!!!!");
            alert.show();
        }else{
            if(!checkAccNumber(Long.parseLong(accNumber))){
                alert.setContentText("Accnumber already exists");
                alert.show();
            }else{
                newStaff.setAccNumber(Long.parseLong(accNumber));
                newStaff.setName("\"" + name + "\"");
                newStaff.setBalance(Double.parseDouble(balance));
                clients.add(newStaff);
                clientsFromServer.add(newStaff);
            }
        }
    }

    private boolean checkAccNumber(long accNumber){
        for (Client client: clientsFromServer) {
            if(client.getAccNumber() ==  accNumber){
                return false;
            }
        }
        return true;
    }
}
