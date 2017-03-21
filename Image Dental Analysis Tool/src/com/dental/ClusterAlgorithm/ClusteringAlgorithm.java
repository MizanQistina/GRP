package com.dental.ClusterAlgorithm;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class ClusteringAlgorithm {
	
	private Mat preprocessImage;
	private MeanShift meanShift;
	private KMeans kMeans;
	
	public ClusteringAlgorithm(String algorithm){
		
		String address = "resource/saved.jpg";
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		preprocessImage = Highgui.imread(address,Highgui.CV_LOAD_IMAGE_COLOR);
		
		if(algorithm == "Mean Shift"){
			
			// Run Mean Shift on the image
			meanShift = new MeanShift(preprocessImage);
			
			// Create the clustered image
			Highgui.imwrite("resource/clustered.jpg",meanShift.meanShift());
		}else if(algorithm == "K-Means"){
			
			// Run K-Means on the image
			kMeans = new KMeans(preprocessImage);
			
			// Create the clustered image
			Highgui.imwrite("resource/clustered.jpg",kMeans.kMeans());
		}	
	}
}
