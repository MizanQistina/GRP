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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerENC {
	
	public class ControllerIMG implements Initializable {
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	@FXML
	Button Enhancebtn = new Button();

	@FXML
	void onClickEnchance()
		{		
		}
	
	@FXML
	Button Next = new Button();

	@FXML
	void onClickNext() throws IOException
		{		
		Stage stage; 
	    Parent root;
	    stage=(Stage) Next.getScene().getWindow();
	    root = FXMLLoader.load(getClass().getResource("UIres.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
		}
	
	@FXML
	Button Back = new Button();

	@FXML
	void onClickBack() throws IOException
		{		
		Stage stage; 
	    Parent root;
	    stage=(Stage)Back.getScene().getWindow();
	    root = FXMLLoader.load(getClass().getResource("UIimg.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
		}





}
