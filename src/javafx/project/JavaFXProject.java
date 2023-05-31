/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.project;


import Model.Users;
import Model.UsersJpaController;
import View.ViewManager;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class JavaFXProject extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       ViewManager.openRegisterPage();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
