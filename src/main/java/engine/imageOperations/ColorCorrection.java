package main.java.engine.imageOperations;

import main.java.engine.objects.Chanel;
import main.java.engine.objects.Color;
import main.java.engine.objects.Image;


// Статистическая цветокоррекция 
public class ColorCorrection {

	private static double getMean(Image img,int index) {
		double mean=0;
		long  n=img.colorCount();
		for(Color c:img.getColors())
			mean+=c.getColorByIndex(index);
		return mean / n ;
	}
	
	private static double getDispersion(Image img,int index,double mean) {
		double dispersion=0;
		long  n=img.colorCount();
		for(Color c:img.getColors())
			dispersion+=Math.pow((c.getColorByIndex(index) - mean), 2);
		return Math.sqrt(dispersion/n);
	}
	
	public static void doCorrection(Image src,Image dest) {
		
		
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
		
		for(int i=0;i<dest.colorCount();i++){
			dest.getColors()[i].setR(getValue(dest.getColors()[i].getR() ,srcRedMean,  srcRedDispersion, destRedMean,destRedDispersion));
			dest.getColors()[i].setG(getValue(dest.getColors()[i].getG() , srcGreenMean,  srcGreenDispersion, destGreenMean,destGreenDispersion));
			dest.getColors()[i].setB(getValue(dest.getColors()[i].getB() , srcBlueMean,  srcBlueDispersion, destBlueMean,destBlueDispersion));
		}
	}

	private static short getValue(int color,double srcMean, double srcDispersion, double destMean, double destDispersion) {
		double newColor=(srcMean+(color-destMean)*srcDispersion/destDispersion);
		return (short)newColor;
	}
	
	
	
	
	
}
