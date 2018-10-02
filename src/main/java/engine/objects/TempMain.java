package main.java.engine.objects;

import java.io.IOException;

import main.java.engine.imageOperations.ColorCorrection;
import main.java.logger.*;

public class TempMain {
	
	public static void main(String[] args) {
		String src="D:\\test.png";
		String dest="D:\\dest.png";
		
		Image srcImg = null;
		Image destImg = null;
		try {
			srcImg=new Image(src);
			destImg=new Image(dest);
		} catch (IOException e) {
			Logger.printMassege(e.getMessage(), MassegeLevel.Warning);
		}
		
		
		ColorCorrection.doCorrection(srcImg, destImg);
		
		
		destImg.saveToFile(dest, "PNG");
		
		
	}
}
