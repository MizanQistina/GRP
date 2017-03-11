package com.dental.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.dental.ClusterAlgorithm.ClusteringAlgorithm;
import com.dental.Result.Result;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
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
	
	@FXML
	TextArea totalPixel = new TextArea();
	
	@FXML
	TextArea totalArea = new TextArea();
	
	@FXML
	LineChart<Integer, Integer> lineChart;
	
	private HashMap<Integer, Integer> graph;
	
	public class ControllerImage implements Initializable {
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
		}
	}

	@FXML
	private void onClickResults() throws IOException {	
		new ClusteringAlgorithm();
		Result newResult = new Result();
		totalPixel.setText(Integer.toString((int)newResult.getTotalPixel()));
		totalArea.setText(String.format("%.2f", newResult.getTotalArea()));	
		graph = newResult.getPixelCalculate().getHashMap_Data();
		plotGraph();
	}
	
	@SuppressWarnings("rawtypes")
	public void plotGraph(){
		XYChart.Series<Integer, Integer> series = new XYChart.Series<Integer, Integer>();
		Set set = graph.entrySet();
	    Iterator i = set.iterator();
	    
	    while(i.hasNext()) {
	        Map.Entry me = (Map.Entry)i.next();
	        System.out.print(me.getKey() + ": ");
	        System.out.println(me.getValue());
	        
	        series.getData().add(new XYChart.Data<Integer, Integer>((int)me.getKey(),(int)me.getValue()));
	     }
	    System.out.println();
		
		lineChart.getData().add(series);
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
