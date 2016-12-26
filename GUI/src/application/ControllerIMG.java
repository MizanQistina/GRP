package application;

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
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerIMG extends Main implements Initializable {


@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	
}



@FXML
Button Browsebtn = new Button();

@FXML
void onClickBrowse()
	{		
	FileChooser chooser = new FileChooser();
    chooser.setTitle("Choose image");
    File file = chooser.showOpenDialog(new Stage());
	}

@FXML
Button Uploadbtn = new Button();

@FXML
void onClickUpload()
	{	
	}	

@FXML
Button Nextbtn = new Button();

@FXML
void onClickNext() throws IOException
	{	
	Stage stage; 
    Parent root;
    stage=(Stage) Nextbtn.getScene().getWindow();
    root = FXMLLoader.load(getClass().getResource("UIenc.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
	}
	}	
	
	

	
	
	
	
	
	
	
	
	
	
	
	

