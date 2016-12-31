package com.dental.Process;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class LoadImage {

	private static Mat newImage;
	
	public static void main( String[] args ){
		
		String address = "";// Enter address to the uploaded image here
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		newImage = Highgui.imread(address,Highgui.CV_LOAD_IMAGE_COLOR);
		
		PreProcessing dest = new PreProcessing(newImage);
		
		// Check project file to see the preprocessed image
		Highgui.imwrite("preprocess.jpg",dest.preProcessing());
		
	}
}
