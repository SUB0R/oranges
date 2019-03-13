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

	// ��һ���DƬ
	@FXML
	public void LastImage(ActionEvent event) throws IOException {
		// �õ��ļ��A�ĈDƬ
		String[] strings=ImagesGeting.GetImages(str);
		// �и��ļ������õ�·��
		String[] strSpilt=ImagesName.ImagesFormat(str);
		if(num>1) {
			num--;
			// ����ͼƬ�ĵ�ַ��ʹ����������ʾ
			String string=strSpilt[0]+"\\"+strings[num-1];
			ImagesToShowing(string);
			System.out.println(string);
		}
	}
	
	// ��һ���DƬ
	@FXML
	public void NextImage(ActionEvent event) throws IOException {
		
		// �õ��ļ��A�ĈDƬ
		String[] strings=ImagesGeting.GetImages(str);
		// �и��ļ������õ�·��
		String[] strSpilt=ImagesName.ImagesFormat(str);
		//����ʾ���ź��ԭͼ
		if(num==0) {
			num++;
		}
		if(num<strings.length) {
			num++;
			// ����ͼƬ�ĵ�ַ��ʹ����������ʾ
			String string=strSpilt[0]+"\\"+strings[num-1];
			ImagesToShowing(string);
			System.out.println(string);
		}
	}
	
	// ͼƬ����ʶ�𣩵�ѡ����չʾ
	@FXML
	public void ChoosingImages(ActionEvent event) throws Exception {
		// �õ�ͼƬ���Ե�ַ
		str=ImagesChooser.imagesChooser();
		if(str!=null) {
			// ����ͬ�����ļ���
			ImagesSaving.FolderCreating(str);
			num=0;
			// ͼƬ��ʾ
			String string=ImagesToShowing(str);
			// ������
			string =Kaiyunsuan.Kaiyunsuan(string);
//			//Ԥ���Ҷ�ͼΪԭͼ
			string = Gray.Gray(string);
			//��
			string = Sharpen.Sharpen(string);
			// ������
			string = Biyunsuan.Biyunsuan(string);
			//��Ե���
			string = Edge.Edge(string);
		}
	
	}
	
	// ��ʾͼƬ
	public String ImagesToShowing(String string) throws IOException {
		
		if(num==0) {
			//ԭͼ����
			String string1 = ImagesZooming.Zooming(string);
			String string2 = ImagesName.toShowing(string1);
			Image image = new Image(string2);
			imv.setImage(image);
			return string1;
		}else {
			//���ͼ
			String string3 = ImagesName.toShowing(string);
			Image image = new Image(string3);
			imv.setImage(image);
			return string3;
		}
	}
	
}
