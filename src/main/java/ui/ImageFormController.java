package main.java.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class ImageFormController {

	@FXML
    private Canvas imageCanvas;
	
	private Image image;

	public ImageFormController(String path) throws IOException {
		super();
		image=new Image(new FileInputStream(path)); 
		
	}

	public void initImage() {
		imageCanvas.getGraphicsContext2D().drawImage(image, 0, 0,imageCanvas.getWidth(),imageCanvas.getHeight());
		
	}

	
}
