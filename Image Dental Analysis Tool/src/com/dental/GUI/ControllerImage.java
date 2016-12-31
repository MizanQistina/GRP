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
	void onClickBrowse() throws IOException
	{		
	FileChooser chooser = new FileChooser();
    	chooser.setTitle("Choose image");
    	chooser.getExtensionFilters().add(
    	new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")//File format restrictions
    	);             		
    	File Selectedfile = chooser.showOpenDialog(new Stage());
    	BufferedImage bimg = ImageIO.read(Selectedfile);//Taking file and storing it as image
    	int width          = bimg.getWidth();			//getting dimensions of the image	
    	int height         = bimg.getHeight();
    	System.out.println("The width of the image is:"+width+"The height of the image is:"+height);//For developer reference
    	if(width>1366&&height>768||width>1366||height>768)//Check if the image size is acceptable
    		{
    		Alert alert = new Alert(AlertType.ERROR);//Alert box appears when if statement is true    		
    		alert.setTitle("Error");
    		alert.setHeaderText("Uploaded Failed");
    		alert.setContentText("Upload image less than 1.1 mbs");
    		alert.showAndWait();
    		}
    	else // If file is of appropriate dimensions run the following code
    		{
    		Image image = SwingFXUtils.toFXImage(bimg, null);//converting buffered image into an Image so javafx methods work
    		ImageView imageView = new ImageView();
    		imageView.setImage(image);
    		imageView.setFitWidth(300);//only imageView is resized to fit not the original "image"
    		imageView.setPreserveRatio(true);//making sure previewed image is not too big for screen
    		imageView.setSmooth(true);
    		imageView.setCache(true);
    		imageView.setX(120);
    		Preview.getChildren().add(imageView);//prints out image inside Hbox "Preview"
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