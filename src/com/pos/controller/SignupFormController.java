package com.pos.controller;

import com.pos.db.DatabaseAccessCode;
import com.pos.model.SystemUser;
import com.pos.util.PasswordGenerator;
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
import java.util.UUID;

public class SignupFormController {
    public AnchorPane context;
    public TextField txtFullName;
    public PasswordField txtPassword;
    public TextField txtEmail;
    public TextField txtContactNumber;

    public void openLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(
                new Scene(
                        FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))
                )
        );
    }

    public void registerOnAction(ActionEvent actionEvent) {
        SystemUser user = new SystemUser(
                UUID.randomUUID().toString(),
                txtFullName.getText(),
                txtEmail.getText(),
                txtContactNumber.getText(),
                PasswordGenerator.encrypt(txtPassword.getText())
        );
        try{
            if(DatabaseAccessCode.createUser(user)){
                new Alert(Alert.AlertType.INFORMATION, "User Saved").show();
                setUi("LoginForm");
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again").show();
            }
        }catch (ClassNotFoundException | SQLException | IOException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }
}
