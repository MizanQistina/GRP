package com.dental.Process;

import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class LoadImage {

	private static Mat newImage;
	private PreProcessing dest;
	
	public LoadImage(File SelectedFile){
		
		String address = SelectedFile.toString();
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		newImage = Highgui.imread(address,Highgui.CV_LOAD_IMAGE_COLOR);
		
		dest = new PreProcessing(newImage);
		
		// Check project file to see the preprocessed image
		Highgui.imwrite("resource/preprocess.jpg",dest.preProcessing());
	}
}
