package MethodsOfImages;

import java.io.IOException;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImagesCorrodingToGray {

	public static String GrayCorroding(String string, int i) throws IOException {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//		String string="D:\\Config\\57421470783112381.jpg";
		Mat sourceImage = Imgcodecs.imread(string);

        Mat structImage = Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE,new Size(30,30));
        Mat outImage = new Mat();

        Imgproc.erode(sourceImage,outImage,structImage);
		String url;
		if (i == 1) {
			// �ȸ�ʴ������
			// ����ͼƬ D:\Config\57421470783112381\601.jpg
			url = ImagesSaving.ImagesNameToSaving(string, 601);
		} else {
			// �����ͺ�ʴ
			// ����ͼƬ D:\Config\57421470783112381\6.jpg
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
