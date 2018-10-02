package main.java.ui;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainFormController {
	
	@FXML
	   private Button loadButton;
	@FXML
		private Canvas canvas;

	

	public MainFormController() {
		
	}


	@FXML
    void loadClicked(MouseEvent event) {
		System.out.println("clicked");
//		canvas.getGraphicsContext2D();
    }
	
	
}
