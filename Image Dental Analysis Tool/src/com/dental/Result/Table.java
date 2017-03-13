package com.dental.Result;

import javafx.beans.property.SimpleIntegerProperty;

public class Table {

	private final SimpleIntegerProperty percentage;
	private final SimpleIntegerProperty pixelCount;
	
	public Table(int percentage, int pixelCount){
		this.percentage = new SimpleIntegerProperty(percentage);
		this.pixelCount = new SimpleIntegerProperty(pixelCount);
	}
	
	public Integer getPercentage(){
		return percentage.get();
	}
	
	public void setPercentage(Integer v){
		percentage.set(v);
	}
	
	public Integer getPixelCount(){
		return pixelCount.get();
	}
	
	public void setPixelCount(Integer v){
		pixelCount.set(v);
	}
}
