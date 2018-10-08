package main.java.engine.imageOperations;

import java.io.IOException;

import main.java.engine.objects.Chanel;
import main.java.engine.objects.Pixel;
import main.java.logger.Logger;
import main.java.logger.MassegeLevel;
import main.java.engine.objects.Image;


// Statistical color correction 
public class ColorCorrection implements Operation {

	private Image src;
	private Image dest;
	
	
	public ColorCorrection(Image src,Image dest) {
		this.src=src;
		this.dest=dest;
	}
	
	
	private  double getMean(Image img,int chanel) {
		double mean=0;
		long  n=img.pixelsCount();
		for(Pixel c:img.getPixels())
			mean+=c.getPixelColorByChanel(chanel);
		return mean / n ;
	}
	
	private double getDispersion(Image img,int chanel,double mean) {
		double dispersion=0;
		long  n=img.pixelsCount();
		for(Pixel c:img.getPixels())
			dispersion+=Math.pow((c.getPixelColorByChanel(chanel) - mean), 2);
		return Math.sqrt(dispersion/n);
	}
	
	
	public Image doOperation() {
		Image result=null;
		try {
			result = new Image(dest.getImagePath());
		} catch (IOException e) {
			Logger.printMassege("Exception trying to copy dest img in collor transfer operation:" + e.getMessage(), MassegeLevel.Error);
		}
		
		double srcRedMean=getMean(src, Chanel.Red);
		double srcGreenMean=getMean(src, Chanel.Green);
		double srcBlueMean=getMean(src, Chanel.Blue);
		
		double destRedMean=getMean(dest, Chanel.Red);
		double destGreenMean=getMean(dest, Chanel.Green);
		double destBlueMean=getMean(dest, Chanel.Blue);
		
		double srcRedDispersion=getDispersion(src, Chanel.Red, srcRedMean);
		double srcGreenDispersion=getDispersion(src, Chanel.Green, srcGreenMean);
		double srcBlueDispersion=getDispersion(src, Chanel.Blue, srcBlueMean);
		
		double destRedDispersion=getDispersion(dest, Chanel.Red, destRedMean);
		double destGreenDispersion=getDispersion(dest, Chanel.Green, destGreenMean);
		double destBlueDispersion=getDispersion(dest, Chanel.Blue, destBlueMean);
				
		for(int i=0;i<dest.pixelsCount();i++){
			result.getPixels()[i].setR(getValue(dest.getPixels()[i].getR() ,srcRedMean,  srcRedDispersion, destRedMean,destRedDispersion));
			result.getPixels()[i].setG(getValue(dest.getPixels()[i].getG() , srcGreenMean,  srcGreenDispersion, destGreenMean,destGreenDispersion));
			result.getPixels()[i].setB(getValue(dest.getPixels()[i].getB() , srcBlueMean,  srcBlueDispersion, destBlueMean,destBlueDispersion));
		}
		return result;
	}

	
	
	private int getValue(int color,double srcMean, double srcDispersion, double destMean, double destDispersion) {
		double newColor=(srcMean+(color-destMean)*srcDispersion/destDispersion);
		return (int) Math.abs(newColor);
	}

		
	
	
	
	
}
