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
		
		Highgui.imwrite("sharped.jpg",dest.imageSharpening());
		//check project file to see the enhance image

	}
}
