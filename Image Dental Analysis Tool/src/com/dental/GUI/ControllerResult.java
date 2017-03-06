package com.dental.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.dental.ClusterAlgorithm.ClusteringAlgorithm;
import com.dental.Result.Result;

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
import javafx.stage.Stage;

public class ControllerResult {
	
	@FXML
	Button btnResult = new Button();
	//
	@FXML
	Button btnBack = new Button();
	
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
	
	public class ControllerImage implements Initializable {
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
		}
	}

	@FXML
	private void onClickResults() throws IOException {	
		new ClusteringAlgorithm();
		new Result();
	}	

	@FXML
	private void onClickBack() throws IOException {
		
		Stage stage; 
	    Parent root;
	    stage=(Stage)btnBack.getScene().getWindow();
	    root = FXMLLoader.load(getClass().getResource("GUI_Image.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}
	
	@FXML
	private void onClickExit(){
		System.exit(0);
	}
	
	//To display all MenuItems under File when it is clicked
	@FXML
	private void onClickFile() {
		MenuItem itmExit = new MenuItem("Exit");
		file.getItems().addAll(itmExit);
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
	private void onClickMenuExit(){
		Platform.exit();
	}
}
