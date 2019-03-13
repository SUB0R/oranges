package Check;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import MethodsOfImages.ImagesName;

public class Edge {
	public static String Edge(String string) throws IOException {  
		BufferedImage originalPic = ImageIO.read(new File(string));
        int imageWidth = originalPic.getWidth();  
        int imageHeight = originalPic.getHeight();  
  
        BufferedImage newPic = new BufferedImage(imageWidth, imageHeight,  
                BufferedImage.TYPE_3BYTE_BGR);  
  
        float[] elements = { 0.0f, -1.0f, 0.0f, -1.0f, 4.0f, -1.0f, 0.0f,  
                -1.0f, 0.0f };  
  
        // AffineTransform at = new AffineTransform();  
        Kernel kernel = new Kernel(3, 3, elements);  
        ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);  
        cop.filter(originalPic, newPic);  
        
        String[] strings=ImagesName.ImagesFormat(string);
        String url = ImagesName.setImagesName(strings, 7);
  		
        ImageIO.write(newPic,"jpg",new File(url));
        return url;
    }  
}
