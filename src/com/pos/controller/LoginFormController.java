package com.pos.controller;

import com.pos.db.DatabaseAccessCode;
import com.pos.db.LoggedUserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public AnchorPane context;
    public TextField txtEmail;
    public PasswordField txtPassword;

    public void openSignupFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignupForm");
    }

    private void setUi(String location) throws IOException {

        FXMLLoader loader =
                new FXMLLoader(getClass()
                        .getResource("../view/"+location+".fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) context.getScene().getWindow();
        DashboardFormController controller = loader.getController();
        controller.printLoggedUserEmail(txtEmail.getText());
        stage.setScene(scene);
    }

    public void openDashboardOnAction(ActionEvent actionEvent) throws IOException {
        try{
            if(DatabaseAccessCode.loginUser(txtEmail.getText(),txtPassword.getText())){
                LoggedUserData.email=txtEmail.getText();
                new Alert(Alert.AlertType.INFORMATION, "Logged..").show();
                setUi("DashboardForm");
            }else{
                new Alert(Alert.AlertType.WARNING, "email or password incorrect!").show();
            }
        }catch (ClassNotFoundException | SQLException | IOException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }
}
