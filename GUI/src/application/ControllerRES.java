package application;

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

public class ControllerRES 
{
	public class ControllerIMG implements Initializable {
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	@FXML
	Button Resultsbtn = new Button();

	@FXML
	void onClickResults()
		{		
		}	
	
	@FXML
	Button Back = new Button();

	@FXML
	void onClickBack() throws IOException
		{
		Stage stage; 
	    Parent root;
	    stage=(Stage)Back.getScene().getWindow();
	    root = FXMLLoader.load(getClass().getResource("UIenc.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
		}
	
	
	
	
	

}
