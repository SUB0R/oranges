package application;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;

import Check.Binary;
import Check.Biyunsuan;
import Check.Edge;
import Check.Gray;
import Check.Kaiyunsuan;
import Check.Sharpen;
import MethodsOfImages.ImagesGeting;
import MethodsOfImages.ImagesChooser;
import MethodsOfImages.ImagesName;
import MethodsOfImages.ImagesSaving;
import MethodsOfImages.ImagesZooming;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class OrangesGUIController {
	@FXML
	private Button as;
	@FXML
	private ImageView imv;
	@FXML
	private Button next;
	
	private static int num=0;
	private static String str="";

	// 上一張圖片
	@FXML
	public void LastImage(ActionEvent event) throws IOException {
		// 得到文件夾的圖片
		String[] strings=ImagesGeting.GetImages(str);
		// 切割文件名，得到路徑
		String[] strSpilt=ImagesName.ImagesFormat(str);
		if(num>1) {
			num--;
			// 设置图片的地址，使得能用于显示
			String string=strSpilt[0]+"\\"+strings[num-1];
			ImagesToShowing(string);
			System.out.println(string);
		}
	}
	
	// 下一張圖片
	@FXML
	public void NextImage(ActionEvent event) throws IOException {
		
		// 得到文件夾的圖片
		String[] strings=ImagesGeting.GetImages(str);
		// 切割文件名，得到路徑
		String[] strSpilt=ImagesName.ImagesFormat(str);
		//不显示缩放后的原图
		if(num==0) {
			num++;
		}
		if(num<strings.length) {
			num++;
			// 设置图片的地址，使得能用于显示
			String string=strSpilt[0]+"\\"+strings[num-1];
			ImagesToShowing(string);
			System.out.println(string);
		}
	}
	
	// 图片（待识别）的选择与展示
	@FXML
	public void ChoosingImages(ActionEvent event) throws Exception {
		// 得到图片绝对地址
		str=ImagesChooser.imagesChooser();
		if(str!=null) {
			// 创建同级的文件夹
			ImagesSaving.FolderCreating(str);
			num=0;
			// 图片显示
			String string=ImagesToShowing(str);
			// 开运算
			string =Kaiyunsuan.Kaiyunsuan(string);
//			//预备灰度图为原图
			string = Gray.Gray(string);
			//锐化
			string = Sharpen.Sharpen(string);
			// 闭运算
			string = Biyunsuan.Biyunsuan(string);
			//边缘检测
			string = Edge.Edge(string);
		}
	
	}
	
	// 显示图片
	public String ImagesToShowing(String string) throws IOException {
		
		if(num==0) {
			//原图缩放
			String string1 = ImagesZooming.Zooming(string);
			String string2 = ImagesName.toShowing(string1);
			Image image = new Image(string2);
			imv.setImage(image);
			return string1;
		}else {
			//检测图
			String string3 = ImagesName.toShowing(string);
			Image image = new Image(string3);
			imv.setImage(image);
			return string3;
		}
	}
	
}
