package com.dental.GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ControllerImage extends Main implements Initializable {

	@FXML
	Button btnBrowse = new Button();
	
	@FXML
	Button btnUpload = new Button();
	
	@FXML
	Button btnNext = new Button();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}	
		
	@FXML
	void onClickBrowse() throws IOException {		
		
		FileChooser chooser = new FileChooser();
    	chooser.setTitle("Choose image");
    	
    	// File format restrictions - .png, .jpg, .jpeg
    	chooser.getExtensionFilters().add( new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
    	
    	File Selectedfile = chooser.showOpenDialog(new Stage());
    	
    	// Taking file and storing it as image
    	BufferedImage bimg = ImageIO.read(Selectedfile);
    	
    	// Getting dimensions of the image
    	int width          = bimg.getWidth();				
    	int height         = bimg.getHeight();
    	
    	// For developer reference
    	System.out.println("The width of the image is:"+width+"The height of the image is:"+height);
    	
    	// Check if the image size is acceptable
    	if(width>1366&&height>768||width>1366||height>768) {
    		
    		// Alert box appears when if statement is true
    		Alert alert = new Alert(AlertType.ERROR);    		
    		alert.setTitle("Error");
    		alert.setHeaderText("Uploaded Failed");
    		alert.setContentText("Upload image less than 1.1 mbs");
    		alert.showAndWait();
    	}
	}

	@FXML
	private void onClickUpload() {	
		// will be updated
	}	

	@FXML
	private void onClickNext() throws IOException {	
		
		Stage stage; 
	    Parent root;
	    stage=(Stage) btnNext.getScene().getWindow();
	    root = FXMLLoader.load(getClass().getResource("GUI_Enhance.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}
}	