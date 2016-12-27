package com.dental.Process;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class Image_Sharpening {
	
	private Mat dest;
	private Mat original_Image;
	
	public Image_Sharpening(Mat image){
		this.original_Image = image;
	}
	
	public Mat imageSharpening(){
		dest = new Mat(original_Image.rows(),original_Image.cols(),original_Image.type());
		Imgproc.GaussianBlur(original_Image, dest, new Size(0,0),101);
		Core.addWeighted(original_Image, 1.5, dest, -0.5, 0, dest);
		
		return dest;
		
	}
}
