package Check;

import java.io.IOException;

import MethodsOfImages.ImagesCorroding;
import MethodsOfImages.ImagesExpanding;

public class Kaiyunsuan {

	public static String Kaiyunsuan(String string) throws IOException {
		
		String url;
		url=ImagesCorroding.Corroding(string, 1);
		url=ImagesExpanding.Expanding(url, 0);
		return url;
	}
}
