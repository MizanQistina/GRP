package com.dental.Result;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Result {

	private PixelCalculation pixelCalculate;
	private Area area;
	
	public Result() throws IOException {
		
		BufferedImage address, clustered;
		int width, height, totalPixels = 0;
	
		address = ImageIO.read(new File("resource/clustered.jpg"));
		width = address.getWidth();
		height = address.getHeight();
	    clustered = new BufferedImage(width,height,address.getType());
	    
	    pixelCalculate = new PixelCalculation(width, height, address);
	    int totalPixel = pixelCalculate.pixelCalculation();
	    
	    area = new Area(totalPixel, width*height);
	    int totalArea = area.calculateTotalArea();
	    
	    ImageIO.write(address,"jpg",new File("resource/test.jpg"));
	    System.out.println(totalPixel + "\n" + totalArea);
	}
}
