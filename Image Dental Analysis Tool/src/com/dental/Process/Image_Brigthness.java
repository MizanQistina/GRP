package com.dental.Process;

import org.opencv.core.Mat;

public class Image_Brigthness {

	private Mat dest;
	private Mat original_Image;

	private static double alpha = 1;
	private static double beta = -50;
	
	public Image_Brigthness(Mat image) {
		this.original_Image = image;
	}
   
	public Mat imageSharpening() {
		
		dest = new Mat(original_Image.rows(),original_Image.cols(),original_Image.type());
		
		// Adjust the image brightness
		original_Image.convertTo(dest, -1, alpha, beta); 
		
		return dest;
	}
}
