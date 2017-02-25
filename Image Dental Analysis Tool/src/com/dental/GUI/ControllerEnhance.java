package com.dental.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class ControllerEnhance {
	
	@FXML
	Button btnEnhance = new Button();
	
	@FXML
	Button btnNext = new Button();
	
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
	
	@FXML
	MenuItem itmAbout = new MenuItem();

	public class ControllerImage implements Initializable {
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
		}	
	}
	
	@FXML
	private void onClickEnchance() {		
		// will be updated
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
	
	//To display all MenuItems under File when it is clicked
	@FXML
	private void onClickFile() {
		MenuItem itmExit = new MenuItem("Exit");
		file.getItems().addAll(itmExit);
		menuBar.getMenus().addAll(file);
}
	//To display all MenuItems under Help when it is clicked
	@FXML 
	private void onClickHelp() {
		MenuItem itmAbout = new MenuItem("About");
		help.getItems().addAll(itmAbout);
		menuBar.getMenus().addAll(help);
	}
	
	//When EXIT in File is clicked, the entire application is closed
	@FXML
	private void onClickExit(){
		Platform.exit();
	}
}
