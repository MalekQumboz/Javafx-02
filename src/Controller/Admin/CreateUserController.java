/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.User;
import View.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CreateUserController implements Initializable {

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button saveNewUserBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField usernameTF;
    private TextField passwordTF;
    private TextField emailTF;
    private ToggleGroup genderGroup;
    private ToggleGroup roleGroup;
    @FXML
    private TextField accountNumberTF;
    @FXML
    private TextField balanceTF;
    @FXML
    private TextField creationDateTF;
    @FXML
    private TextField userIdTF;
    @FXML
    private TextField currencyTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToUsersManagment();
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    
    @FXML
    private void saveNewUser(ActionEvent event) throws SQLException, ClassNotFoundException {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        String email = emailTF.getText();
        String gender = ((RadioButton)genderGroup.getSelectedToggle()).getText();
        String role = ((RadioButton)roleGroup.getSelectedToggle()).getText();
        User user = new User(username,password,email,gender,role);
        user.save();
        
        ViewManager.adminPage.changeSceneToUsersManagment();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User inserted");
        alert.setContentText("User inserted");
        alert.showAndWait();
    }

    @FXML
    private void cancelUserCreation(ActionEvent event) {
                ViewManager.adminPage.changeSceneToUsersManagment();

    }
    
}
