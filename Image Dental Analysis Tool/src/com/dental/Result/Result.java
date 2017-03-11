package com.dental.Result;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Result {

	private PixelCalculation pixelCalculate;
	private Area area;
	private float totalPixel;
	private float totalArea;	

	public Result() throws IOException {
		
		BufferedImage address;
		int width, height;
	
		address = ImageIO.read(new File("resource/clustered.jpg"));
		width = address.getWidth();
		height = address.getHeight();
	    new BufferedImage(width,height,address.getType());
	    
	    pixelCalculate = new PixelCalculation(width, height, address);
	    totalPixel = pixelCalculate.pixelCalculation();
	    
	    area = new Area(totalPixel, width*height);
	    totalArea = area.calculateTotalArea();
	    
	    ImageIO.write(address,"jpg",new File("resource/test.jpg"));
	}
	
	public PixelCalculation getPixelCalculate() {
		return pixelCalculate;
	}

	public float getTotalPixel() {
		return totalPixel;
	}
	public float getTotalArea() {
		return totalArea;
	}
}
