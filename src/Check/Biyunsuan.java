package Check;

import java.io.IOException;

import MethodsOfImages.ImagesCorroding;
import MethodsOfImages.ImagesCorrodingToGray;
import MethodsOfImages.ImagesExpanding;
import MethodsOfImages.ImagesExpandingToGray;

public class Biyunsuan {

	public static String Biyunsuan(String string) throws IOException {
		
		String url;
		url=ImagesExpandingToGray.GrayExpanding(string, 1);
		url=ImagesCorrodingToGray.GrayCorroding(url, 0);
		return url;
	}
}
