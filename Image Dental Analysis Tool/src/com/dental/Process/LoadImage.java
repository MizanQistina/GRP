package com.dental.Process;

import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class LoadImage {

	private static Mat newImage;
	
	public LoadImage(File SelectedFile){
		
		String address = SelectedFile.toString();
		System.out.println(address);
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		newImage = Highgui.imread(address,Highgui.CV_LOAD_IMAGE_COLOR);
		
		PreProcessing dest = new PreProcessing(newImage);
		
		// Check project file to see the preprocessed image
		Highgui.imwrite("preprocess.jpg",dest.preProcessing());
		
	}
}
