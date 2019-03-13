package MethodsOfImages;

import java.io.IOException;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImagesExpandingToGray {

	public static String GrayExpanding(String string, int i) throws IOException {

//		String string="D:\\Config\\57421470783112381\\301.jpg";
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat sourceImage = Imgcodecs.imread(string);

        Mat outImage = new Mat();
        //ÕºœÒ∏Ø ¥
        Mat structImage = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(30,30));
        Imgproc.dilate(sourceImage, outImage, structImage);
		String url;
		if (i == 1) {
			// œ»≈Ú’Õ∫Û∏Ø ¥
			// ±£¥ÊÕº∆¨ D:\Config\57421470783112381\601.jpg
			url = ImagesSaving.ImagesNameToSaving(string, 601);
			Imgcodecs imageCodecs = new Imgcodecs();
			imageCodecs.imwrite(url, outImage);
		} else {
			// œ»∏Ø ¥∫Û≈Ú’Õ
			// ±£¥ÊÕº∆¨ D:\Config\57421470783112381\6.jpg
			String[] strings = ImagesName.ImagesFormat(string);
			strings[0] = strings[0].substring(0, strings[0].length() - 2);
			url = strings[0] + "." + strings[1];
			System.out.println(url);
			Imgcodecs imageCodecs = new Imgcodecs();
			imageCodecs.imwrite(url, outImage);
		}
		return url;
	}
}
