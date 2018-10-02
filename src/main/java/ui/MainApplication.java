package main.java.ui;




import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainApplication extends Application {

	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("mainform.fxml"));
		Scene scene= new Scene(root,500,600);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();

	}

			


}
