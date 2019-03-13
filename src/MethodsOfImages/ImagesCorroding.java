package MethodsOfImages;

import java.io.IOException;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImagesCorroding {

	public static String Corroding(String string, int i) throws IOException {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//		String string="D:\\Config\\57421470783112381.jpg";
		Mat sourceImage = Imgcodecs.imread(string);
		// Mat sourceImage = Imgcodecs.imread(test_file_path +
		// "/5cent.jpg",Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);

		// size 越小，腐蚀的单位越小，图片越接近原图
		Mat structImage = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(30, 30));
		Mat outImage = new Mat();
		// 开始腐蚀
		Imgproc.erode(sourceImage, outImage, structImage);
		String url;
		if (i == 1) {
			// 先腐蚀后膨胀
			// 保存图片 D:\Config\57421470783112381\301.jpg
			url = ImagesSaving.ImagesNameToSaving(string, 101);
		} else {
			// 先膨胀后腐蚀
			// 保存图片 D:\Config\57421470783112381\3.jpg
			String[] strings = ImagesName.ImagesFormat(string);
			strings[0] = strings[0].substring(0, strings[0].length() - 2);
			url = strings[0] + "." + strings[1];
			System.out.println(url);
			Imgcodecs imageCodecs = new Imgcodecs();
			imageCodecs.imwrite(url, outImage);
		}
		Imgcodecs imageCodecs = new Imgcodecs();
		imageCodecs.imwrite(url, outImage);
		return url;
	}
}
