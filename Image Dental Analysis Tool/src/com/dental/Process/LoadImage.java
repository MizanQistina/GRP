package com.dental.Process;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class LoadImage {

	private static Mat newImage;
	
	public static void main( String[] args ){
		
		String address = "";//enter address to the uploaded image here
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		newImage = Highgui.imread(address,Highgui.CV_LOAD_IMAGE_COLOR);
		
		Image_Sharpening dest = new Image_Sharpening(newImage);
		
		Image_Brigthness dest1 = new Image_Brigthness(newImage);
		
		//check project file to see the sharpened image
		Highgui.imwrite("sharped.jpg",dest.imageSharpening());
		
		//check project file to see the darkened image
		Highgui.imwrite("darkened.jpg",dest1.imageSharpening());
		
	}
}
