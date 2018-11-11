package com.nokinobi.ui.lab4;


import java.io.FileInputStream;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApplication extends Application {
    public MainApplication() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        String path = "src/main/java/resources/mainform2.fxml";
        InputStream is = new FileInputStream(path);
        AnchorPane root = loader.load(is);
        Scene scene = new Scene(root, root.getPrefWidth(), root.getPrefHeight());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
