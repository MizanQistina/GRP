package com.dental.GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

import com.dental.Process.LoadImage;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.layout.HBox;

public class ControllerImage extends Main implements Initializable {

	@FXML
	private Slider sharpSlider;
	
	@FXML
	private Slider brightSlider;
	
	@FXML
	Button btnEnhance = new Button();
		
	@FXML
	HBox Preview = new HBox();
	
	@FXML
	Button btnNext = new Button();
	
	@FXML
	MenuBar menuBar = new MenuBar();
	
	@FXML
	Menu file = new Menu("File");
	
	@FXML
	Menu help = new Menu("Help");
	
	@FXML
	MenuItem itmOpen = new MenuItem();
	
	@FXML
	MenuItem itmClose = new MenuItem();
	
	@FXML
	MenuItem itmExit = new MenuItem();
	
	@FXML
	MenuItem itmAbout = new MenuItem();
	
	@FXML
	ImageView imageView = new ImageView();
	
	private File Selectedfile;
	private boolean isEnhanced=false;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Listen for Sharpness slider value changes
		sharpSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				System.out.println("Sharpness Slider Changed (newValue: " + newValue.intValue() + ")\n");
			}
		});
		
		// Listen for Brightness slider value changes
		brightSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				System.out.println("Brightness Slider Changed (newValue: " + newValue.intValue() + ")\n");
			}
		});
		File file = new File("resource/saved.jpg");
		FileReader fr = null;
		try	
		{
			fr = new FileReader(file);
			Image image = new Image(file.toURI().toString());
		    ImageView iv = new ImageView(image);
		    iv.setFitWidth(300);
		    iv.setPreserveRatio(true);
			iv.setSmooth(true);
			iv.setCache(true);
			iv.setX(120);
		    Preview.getChildren().add(iv);
		    if(!iv.isCache())
		    {
				btnNext.setStyle("-fx-background-color: #a8a8a8");
				btnNext.setDisable(true);

				System.out.println("File doesn't display");
		    }
		    
		}catch(FileNotFoundException e)
		{
			btnNext.setStyle("-fx-background-color: #a8a8a8");
			btnNext.setDisable(true);

			System.out.println("File doesn't exist");
		}
	}	
		
	@FXML
	private void onClickOpen() throws IOException {		
		
		FileChooser chooser = new FileChooser();
	    chooser.setTitle("Choose image");
	    
	    // File format restrictions - .png, .jpg, .jpeg
	    chooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg") );             		
	    Selectedfile = chooser.showOpenDialog(new Stage());
	    
	    // Taking file and storing it as image
	    BufferedImage bimg = ImageIO.read(Selectedfile);
	    
		try {
		    // retrieve image
		    BufferedImage bi = bimg;
		    File outputfile = new File("resource/saved.jpg");
		    ImageIO.write(bi, "jpg", outputfile);
		    
			btnNext.setStyle("-fx-background-color: #1ed7cb");
			btnNext.setDisable(false);
		} catch (IOException e) {
			btnNext.setStyle("-fx-background-color: #a8a8a8");
			btnNext.setDisable(true);
		}
	    
	    // Getting dimensions of the image
	    int width          = bimg.getWidth();				
	    int height         = bimg.getHeight();
	    
	    
	    // Check if the image size is acceptable
	    if(width>1366&&height>768||width>1366||height>768) {
	    	
	    	// Alert box appears when if statement is true 
	    	Alert alert = new Alert(AlertType.ERROR);   		
	    	alert.setTitle("Error");
	    	alert.setHeaderText("Uploaded Failed");
	    	alert.setContentText("Upload image less than 1.1 mbs");
	    	alert.showAndWait();
	    }
	    	
	    // If file is of appropriate dimensions run the following code
	   	else {
	    		
	   		// Converting buffered image into an Image so JavaFX methods work
	   		Image image = SwingFXUtils.toFXImage(bimg, null);
	   		imageView.setImage(image);
	   		
	   		// Only ImageView is resized to fit not the original "image"
	   		imageView.setFitWidth(300);
	   		
	   		// Making sure previewed image is not too big for screen
	   		imageView.setPreserveRatio(true);
	   		imageView.setSmooth(true);
	   		imageView.setCache(true);
	   		imageView.setX(120);
	   		
	   		// Prints out image inside HBox "Preview"
	   		Preview.getChildren().add(imageView);
	   } 
	}
	
	@FXML
	private void onClickClose() throws IOException {
		 Path fileToDeletePath = Paths.get("resource/saved.jpg");
		 Files.delete(fileToDeletePath);
		 imageView.setImage(null);
		 Preview.getChildren().clear();
	}
	
	@FXML
	private void onClickEnchance() {		
		new LoadImage(getSelectedfile());
		isEnhanced=true;
		File file = new File("resource/preprocess.jpg");
		FileReader fr = null;
		try	
		{
			fr = new FileReader(file);
			Image image = new Image(file.toURI().toString());
		    ImageView iv = new ImageView(image);
		    iv.setFitWidth(300);
		    iv.setPreserveRatio(true);
			iv.setSmooth(true);
			iv.setCache(true);
			iv.setX(120);
			Preview.getChildren().clear();
			Preview.getChildren().add(iv);
		    
		    
		    if(!iv.isCache())
		    {
				btnNext.setStyle("-fx-background-color: #a8a8a8");
				btnNext.setDisable(true);

				System.out.println("File doesn't display");
		    }
		    
		}catch(FileNotFoundException e)
		{
			btnNext.setStyle("-fx-background-color: #a8a8a8");
			btnNext.setDisable(true);

			System.out.println("File doesn't exist");
		}
	}
	
	@FXML
	private void onClickNext() throws IOException {	
	
		Stage stage; 
	    Parent root;
	    stage=(Stage) btnNext.getScene().getWindow();	    
	    root = FXMLLoader.load(getClass().getResource("GUI_Result.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
    }


	//To display all MenuItems under File when it is clicked
	@FXML
	private void onClickFile() {
		MenuItem itmOpen = new MenuItem("Open");
		MenuItem itmClose = new MenuItem("Close");
		MenuItem itmExit = new MenuItem("Exit");
		file.getItems().addAll(itmOpen, itmClose, itmExit);
		menuBar.getMenus().addAll(file);
	}
	
	//To display MenuItems in Help option ('About' in this case)
	@FXML 
	private void onClickHelp() {
		MenuItem itmAbout = new MenuItem("About");
		help.getItems().addAll(itmAbout);
		menuBar.getMenus().addAll(help);
		// Display copyright information when 'Help' is clicked
		Alert alert = new Alert(AlertType.INFORMATION);
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	alert.setTitle("Help");
    	alert.setHeaderText("Automated Image Dental Analysis");
    	alert.setContentText("Version 1.0 - Last Updated March 2017\n\n"
    			+ "Copyright 2017 Group 2 UNMC.\n "
    			+ "All rights reserved.\n\n"
    			+ "This software is made possible by OpenCV and Scene Builder.\n");
    	alert.showAndWait();
	}
	
	//When EXIT in File is clicked, the entire application is closed
	@FXML 
	private void onClickExit() {
		Platform.exit();
	}
	
	public File getSelectedfile() {
		return Selectedfile;
		
	}
}


