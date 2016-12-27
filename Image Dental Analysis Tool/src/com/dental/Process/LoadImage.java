package com.dental.Process;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class LoadImage {

public static void main( String[] args ){
		
		String address = "";//enter address to the uploaded image here
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		Mat m = Highgui.imread(address,Highgui.CV_LOAD_IMAGE_COLOR);
	  
		System.out.println(m.size());
		System.out.println(m.height());
		System.out.println(m.width());
	}
}
