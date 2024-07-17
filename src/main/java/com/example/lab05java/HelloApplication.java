package com.example.lab05java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.google.gson.Gson;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Lab 05");

        Button button = new Button("Click here");
        button.setOnAction(event -> parseJSON());

        VBox vbox = new VBox(button);
        Scene scene = new Scene(vbox,180,120);

        stage.setScene(scene);
        stage.show();
    }

    public void parseJSON() {
        String jsonString="{\"productID\":01,\"productName\":\"pen\",\"orderDate\":\"2024-07-07\",\"manufacturer\":\"GC\"}";
        Gson gson=new Gson();
        Products products=gson.fromJson(jsonString,Products.class);
        System.out.println("Product ID: "+ products.productID);
        System.out.println("Product Name: "+ products.productName);
        System.out.println("Order Date: "+ products.orderDate);
        System.out.println("Manufacturer: "+ products.manufacturer);

        String jsonOutput=gson.toJson(products);
        System.out.println("The output for JSON " + jsonOutput);
    }

    public static void main(String[] args) {
        launch();
    }
}