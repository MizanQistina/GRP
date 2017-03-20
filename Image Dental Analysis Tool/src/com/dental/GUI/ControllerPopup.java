package com.dental.GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControllerPopup implements Initializable {

	@FXML
	private HBox Preview = new HBox();
	
	@FXML
	private Menu help = new Menu("Help");
	
	@FXML
	private Menu file = new Menu("File");
	
	@FXML
	private MenuBar menuBar = new MenuBar();
	
	@FXML
	private Button btnBack = new Button();
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		File file = new File("resource/segmented.jpg");
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
		    fr.close();
		}catch(FileNotFoundException e)
		{
			System.out.println("File doesn't exist");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// To display all MenuItems under File when it is clicked
	@FXML
	private void onClickFile() {
		MenuItem itmSave = new MenuItem("Save");
		file.getItems().addAll(itmSave);
		menuBar.getMenus().addAll(file);
	}
	
	// To display MenuItems in Help option ('About' in this case)
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
	
	@FXML
	private void onClickBack() throws IOException {
		
		Stage stage; 
	    Parent root;
	    stage=(Stage)btnBack.getScene().getWindow();
	    root = FXMLLoader.load(getClass().getResource("GUI_Result.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}
	
	@FXML
	private void onClickExit() throws IOException{
		Files.deleteIfExists(Paths.get("resource/saved.jpg"));
		Files.deleteIfExists(Paths.get("resource/segmented.jpg"));
		Platform.exit();
		System.exit(0);
	}

}