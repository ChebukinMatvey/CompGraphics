package main.java.engine.objects;

import main.java.logger.Logger;
import main.java.logger.MassegeLevel;

public class Pixel {
	private int R,G,B;

	public Pixel () {}
	
	public Pixel(int r, int g, int b) {
		R = r;
		G = g;
		B = b;
	}

	public int getR() {
		return R;
	}

	public void setR(int r) {
		R = r;
	}

	public int getG() {
		return G;
	}

	public void setG(int g) {
		G = g;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}

	@Override
	public String toString() {
		return "Color [R=" + R + ", G=" + G + ", B=" + B + "]\n";
	}

	public int getPixelColorByChanel(int chanel) {
		if (chanel > 2 && chanel <0)
			Logger.printMassege("Invalid color index", MassegeLevel.Error);
		return chanel == 0 ? R : chanel == 1 ? G : B ;
	}
	
	
	
}
