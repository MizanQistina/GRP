package com.dental.Result;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Result {

	private PixelCalculation pixelCalculate;
	private Area area;
	private int totalPixel;
	private float totalArea;	

	public Result() throws IOException {
		
		BufferedImage address, clustered;
		int width, height, totalPixels = 0;
	
		address = ImageIO.read(new File("resource/clustered.jpg"));
		width = address.getWidth();
		height = address.getHeight();
	    clustered = new BufferedImage(width,height,address.getType());
	    
	    pixelCalculate = new PixelCalculation(width, height, address);
	    totalPixel = pixelCalculate.pixelCalculation();
	    
	    area = new Area(totalPixel, width*height);
	    totalArea = area.calculateTotalArea();
	    
	    ImageIO.write(address,"jpg",new File("resource/test.jpg"));
	    System.out.println(totalPixel + "\n" + totalArea);
	}
	
	public int getTotalPixel() {
		return totalPixel;
	}
	public float getTotalArea() {
		return totalArea;
	}
}
