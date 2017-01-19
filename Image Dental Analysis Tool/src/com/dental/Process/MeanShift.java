package com.dental.Process;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.TermCriteria;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class MeanShift {

public static void main( String[] args ) {
		
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		Mat original_Image = Highgui.imread("preprocess.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
		Mat dest = new Mat(original_Image.rows(),original_Image.cols(),original_Image.type());
		Imgproc.pyrMeanShiftFiltering(original_Image, dest, 10.0, 30.0,1,new TermCriteria(TermCriteria.MAX_ITER|TermCriteria.EPS, 50, 0.001));
		Highgui.imwrite("meanshift.jpg", dest);
	}
}
