package Check;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import MethodsOfImages.ImagesName;

public class Sharpen {
	public static String Sharpen(String string) throws IOException{  
		BufferedImage originalPic = ImageIO.read(new File(string));
        int imageWidth = originalPic.getWidth();  
        int imageHeight = originalPic.getHeight();  
  
        BufferedImage newPic = new BufferedImage(imageWidth, imageHeight,  
                BufferedImage.TYPE_3BYTE_BGR);  
        float[] data =  
        { -1.0f, -1.0f, -1.0f, -1.0f, 10.0f, -1.0f, -1.0f, -1.0f, -1.0f };  
  
        Kernel kernel = new Kernel(3, 3, data);  
        ConvolveOp co = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);  
        co.filter(originalPic, newPic);  
        
        String[] strings=ImagesName.ImagesFormat(string);
        String url = ImagesName.setImagesName(strings, 3);
  		
        ImageIO.write(newPic,"jpg",new File(url));
        return url;
    }  
}
