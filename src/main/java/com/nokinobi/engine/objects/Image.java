package com.nokinobi.engine.objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;


public class Image extends javafx.scene.image.Image {

	private Pixel[] pixels;
	private String imagePath;
	
	
	
	
	public Image(String url) throws IOException {
		super(new FileInputStream(url));
		initPixels();
		imagePath=url;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	private void initPixels() {
		int w=(int) getWidth();
		int h=(int) getHeight();
		int pixelIndex=0,red=0,green=0,blue=0;
		pixels=new Pixel[w*h];
		int argb=0;
		PixelReader pxReader=getPixelReader();
		for(int i=0;i<h;i++)
			for(int j=0;j<w;j++){
				argb=pxReader.getArgb(j, i);
				red= (argb & 0x00ff0000) >> 16;
				green=(argb & 0x0000ff00) >> 8;
				blue= (argb & 0x000000ff);
				pixels[pixelIndex++]=new Pixel(red,green,blue);
			}
	}


	public long pixelsCount() {
		return (long) (getWidth()*getHeight());
	}


	public Pixel[] getPixels() {
		return pixels;
	}

	public void saveToFile(String out, String format) throws IOException {
		WritableImage img=setPixels();
		ImageIO.write(SwingFXUtils.fromFXImage(img, null), format, new FileOutputStream(out));
	}

	public WritableImage setPixels() {
		int w=(int) getWidth();
		int h=(int) getHeight();
		int pixelIndex=0;
		WritableImage wImage=new WritableImage(w, h);
		for(int i=0;i<h;i++)
			for(int j=0;j<w;j++){
				int alpha=0xff000000;
				int red=pixels[pixelIndex].getR()  << 16 ;
				int green=pixels[pixelIndex].getG()<< 8 ;
				int blue=pixels[pixelIndex].getB();
				wImage.getPixelWriter().setArgb(j, i, alpha|red|green|blue);
				pixelIndex++;
			}
		return wImage;
	}

	public void setPixels(Pixel[] pixs) {
		this.pixels=pixs;
	}


	
	
	
	
	
}
