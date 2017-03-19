package com.dental.ClusterAlgorithm;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class ClusteringAlgorithm {
	
	private Mat preprocessImage;
	private MeanShift meanShift;
	//private KMeans kMeans;
	
	public ClusteringAlgorithm(){
		
		String address = "resource/saved.jpg";
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		preprocessImage = Highgui.imread(address,Highgui.CV_LOAD_IMAGE_COLOR);
		
		meanShift = new MeanShift(preprocessImage);
		//kMeans = new KMeans(preprocessImage);
		
		// Check project file to see the clustered image
		Highgui.imwrite("resource/clustered.jpg",meanShift.meanShift());
		// Highgui.imwrite("resource/clustered.jpg",kMeans.kMeans());	
	}
}
