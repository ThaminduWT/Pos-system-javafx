package com.pos.controller;

import com.pos.db.LoggedUserData;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane context;
    public void initialize(){
        //System.out.println(LoggedUserData.email);
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(
                new Scene(
                        FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))
                )
        );
    }

    public void printLoggedUserEmail(String email){
        System.out.println(email);
    }


    public void logoutOnAction(ActionEvent actionEvent) {
    }

    public void openCustomerFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CustomerForm");
    }

    public void openProductFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ProductForm");
    }

    public void openPlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        setUi("PlaceOrderForm");
    }

    public void openUserFormOnAction(ActionEvent actionEvent) {

    }

    public void openOrderHistoryOnAction(ActionEvent actionEvent) throws IOException {
        setUi("OrderHistoryForm");
    }

    public void openStatisticsOnAction(ActionEvent actionEvent) throws IOException {
        setUi("StatisticsForm");
    }

    public void openActivitiesOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ActivityForm");
    }
}
