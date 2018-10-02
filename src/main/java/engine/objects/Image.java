package main.java.engine.objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.java.logger.Logger;
import main.java.logger.MassegeLevel;


public class Image {
	
	private Color[] colors;
	private BufferedImage bufferedImage;
	private String filePath;
	private int width,height;
	
	public Image(String path)throws IOException {
		filePath=path;
		bufferedImage=ImageIO.read(new File(path));
		initColors();
	}

	
	// Load colors from buffer 
	private void initColors() {
		width =bufferedImage.getWidth();
		height =bufferedImage.getHeight();
		int colorIndex=0;
		colors= new Color[width*height];		// Now we know how much colors is there 
		
		Logger.printMassege("load "+ filePath, MassegeLevel.Info);
		for(int i=0;i<width;i++)
			for(int j=0;j<height;j++)
			{
				int curColor=bufferedImage.getRGB(i,j);
				short red=   (short) ((curColor & 0x00ff0000) >> 16);
				short green= (short) ((curColor & 0x0000ff00) >> 8 );
				short blue=  (short) ((curColor & 0x000000ff));
				colors[colorIndex++]=new Color(red,green,blue);
			}
		Logger.printMassege("Loaded", MassegeLevel.Info);
	}
	
	public Color getColor(int index){
		// illegal index ex 
		return colors[index];
	}
	
	public void saveToFile(String path,String format) {
		File f=new File(path);
		BufferedImage img=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int colorIndex=0;
		for(int i=0;i<width;i++)
			for(int j=0;j<height;j++){
				img.setRGB(i, j,   (this.getColor(colorIndex).getR() << 16) | (this.getColor(colorIndex).getB() << 8) |this.getColor(colorIndex).getB());
				colorIndex++;
			}
		try {
			ImageIO.write(img,format, f);
		} catch (IOException e) {
			Logger.printMassege(e.getMessage(), MassegeLevel.Error);
		}
	}
	
	
	public Color[] getColors() {
		return colors;
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}


	public int colorCount() {
		return width*height;
	}
	
	
	
}
