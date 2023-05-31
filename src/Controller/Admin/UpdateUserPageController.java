/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.User;
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


public class UpdateUserPageController implements Initializable {
    private User oldUser;
    
    @FXML
    private TextField usernameTF;
    private TextField passwordTF;
    private TextField emailTF;
    private ToggleGroup genderGroup;
    private RadioButton femaleRadio;
    private ToggleGroup roleGroup;
    private RadioButton adminRadio;
    @FXML
    private Button updateUserBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField userIdTF;
    @FXML
    private TextField creationDateTF;
    @FXML
    private TextField balanceTF;
    @FXML
    private TextField currencyTF;
    @FXML
    private TextField accountNumberTF;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        this.oldUser = Controller.Admin.UsersManagmentController.selectedUserToUpdate;
        
        usernameTF.setText(oldUser.getUsername());
        emailTF.setText(oldUser.getEmail());
        passwordTF.setText(oldUser.getPassword());
        
        if (oldUser.getGender().equals("female")) {
            genderGroup.selectToggle(femaleRadio);
        }
        
        if (oldUser.getRole().equals("admin")) {
            roleGroup.selectToggle(adminRadio);
        }
    }    

    @FXML
    private void updateUser(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        String email = emailTF.getText();
        String gender = ((RadioButton)genderGroup.getSelectedToggle()).getText();
        String role = ((RadioButton)roleGroup.getSelectedToggle()).getText();
        
        User newUser = new User(username,password,email,gender,role);
        
        newUser.setId(oldUser.getId());
        
        newUser.update();
        
        Controller.Admin.UsersManagmentController.updateStage.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User updated");
        alert.setContentText("User updated");
        alert.showAndWait();
    }

    @FXML
    private void cancelCreation(ActionEvent event) {
       Controller.Admin.UsersManagmentController.updateStage.close(); 
    }
    
}