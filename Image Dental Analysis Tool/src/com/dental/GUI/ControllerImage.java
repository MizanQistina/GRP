package com.dental.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
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
	private void onClickBrowse() {
		
		FileChooser chooser = new FileChooser();
	    chooser.setTitle("Choose image");
	    File file = chooser.showOpenDialog(new Stage());
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