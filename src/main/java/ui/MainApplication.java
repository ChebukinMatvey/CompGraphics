package main.java.ui;




import java.io.*;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApplication extends Application {

	
	
	public static void main(String[] args) {
//		System.out.println(System.getProperty("user.dir"));
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		String path="src/main/java/resources/mainform.fxml";
		InputStream is=new FileInputStream(path);
		loader.setController(new MainFormController(primaryStage));
		AnchorPane root=loader.load(is);
		
		Scene scene= new Scene(root,root.getPrefWidth(),root.getPrefHeight());
		
		primaryStage.setScene(scene);
		
		primaryStage.show();

	}

			


}
