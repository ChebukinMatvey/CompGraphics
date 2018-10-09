package main.java.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import main.java.engine.imageOperations.ColorCorrection;
import main.java.engine.imageOperations.Operation;
import main.java.engine.objects.Image;

public class MainFormController {

	private Stage mainStage;
	
    @FXML
    private Button loadFirstImageButton;

    @FXML
    private TextField firstTextPath;

    @FXML
    private Button loadSecondImageButton;

    @FXML
    private TextField secondTextPath;

    @FXML
    private Canvas resultCanvas;
    
    @FXML
    private Button showResultButton;
    
    @FXML
    private Button showFirstImageButton;

    @FXML
    private Button showSecondImageButton;

    public MainFormController(Stage primaryStage) {
		mainStage=primaryStage;
	}

	@FXML
    void loadFirstImageButtomClicked(MouseEvent event) {
    	firstTextPath.setText(showFileChooser());
    	
    	if(!firstTextPath.getText().equals("closed"))
    		showFirstImageButton.setVisible(true);
    	else
    		showFirstImageButton.setVisible(false);
    	
    	if(!firstTextPath.getText().isEmpty() && !secondTextPath.getText().isEmpty() &&
    		!firstTextPath.getText().equals("closed") && !secondTextPath.getText().equals("closed") )
			showResultButton.setVisible(true);
    }
	
	
    
	@FXML
    void loadSecondImageButtomClicked(MouseEvent event) {
		secondTextPath.setText(showFileChooser());
		
		if(!secondTextPath.getText().equals("closed"))
    		showSecondImageButton.setVisible(true);
		else
			showSecondImageButton.setVisible(false);
		
		if(!firstTextPath.getText().isEmpty() && !secondTextPath.getText().isEmpty() &&
	    		!firstTextPath.getText().equals("closed") && !secondTextPath.getText().equals("closed") )
				showResultButton.setVisible(true);
    }
	
	@FXML
    void showResultButtonClicked(MouseEvent event) throws IOException {
		Image src=new Image(firstTextPath.getText());
		Image dest=new Image(secondTextPath.getText());
		Operation colorCorrection=new ColorCorrection(src,dest); 
		resultCanvas.getGraphicsContext2D().drawImage(colorCorrection.doOperation(), 0, 0,resultCanvas.getWidth(),resultCanvas.getHeight());
    }

	 @FXML
    void showFirstImageButtonClicked(MouseEvent event) throws IOException {
		 showNewWindow(firstTextPath.getText());
		 
	}
	 
	@FXML    
	 void showSecondImageButtonClicked(MouseEvent event) throws IOException {
		showNewWindow(secondTextPath.getText());
	 }
	

	 private void showNewWindow(String text) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		Stage stage=new Stage();
		String path="src/main/java/resources/imageform.fxml";
		InputStream is=new FileInputStream(path);
		ImageFormController controller=new ImageFormController(text);
		loader.setController(controller);
		AnchorPane root=loader.load(is);
		Scene scene= new Scene(root,root.getPrefWidth(),root.getPrefHeight());
		stage.setScene(scene);
		controller.initImage();
		stage.show();
		
	}

	
    private String showFileChooser() {
		FileChooser fileChooser=new FileChooser();
		fileChooser.setTitle("File");
		fileChooser.getExtensionFilters().add((new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")));
		File selectedFile = fileChooser.showOpenDialog(mainStage);
		if(selectedFile==null)
			return "closed";
		return  selectedFile.getPath();
	}

}
