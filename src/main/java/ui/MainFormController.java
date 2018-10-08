package main.java.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class MainFormController {

    @FXML
    private Button loadImageButton;
    

    @FXML
    private Canvas imageCanvas;


    @FXML
    void loadImageButtomClicked(MouseEvent event) throws FileNotFoundException {
    	System.out.println("click");
    	GraphicsContext gc = imageCanvas.getGraphicsContext2D();
    	Image i=new  javafx.scene.image.Image(new FileInputStream("D:/test.png"));
		
    	gc.drawImage(i, 0, 0,imageCanvas.getWidth(),imageCanvas.getHeight());
    }

}

