package com.dental.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerEnhance {
	
	@FXML
	Button btnEnhance = new Button();
	
	@FXML
	Button btnNext = new Button();
	
	@FXML
	Button btnBack = new Button();

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
}
