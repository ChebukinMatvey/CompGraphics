package main.java.engine.objects;

import java.io.IOException;

import main.java.engine.imageOperations.*;
import main.java.logger.*;

public class TempMain {
	
	public static void main(String[] args) throws IOException {
		String src="D:\\test.png";
		String dest="D:\\dest.png";
		
		Image srcImg = null;
		Image destImg = null;
		
		srcImg=new Image(src);
		destImg=new Image(dest);
		//new Image(dest).saveToFile("D:/newfile.png", "PNG");
		Operation op=new ColorCorrection(srcImg, destImg);
		//op.doOperation().saveToFile("D:/newfile.png", "PNG");
	}
}
