package main.java.engine.objects;

import main.java.logger.Logger;
import main.java.logger.MassegeLevel;

public class Color {
	private short R,G,B;

	public Color () {}
	
	public Color(short r, short g, short b) {
		super();
		R = r;
		G = g;
		B = b;
	}

	public short getR() {
		return R;
	}

	public void setR(short r) {
		R = r;
	}

	public short getG() {
		return G;
	}

	public void setG(short g) {
		G = g;
	}

	public short getB() {
		return B;
	}

	public void setB(short b) {
		B = b;
	}

	@Override
	public String toString() {
		return "Color [R=" + R + ", G=" + G + ", B=" + B + "]\n";
	}

	public int getColorByIndex(int index) {
		if (index > 2 && index <0)
			Logger.printMassege("Invalid index", MassegeLevel.Error);
		return index ==0 ? R : index == 1 ? G : B ;
	}
	
	
	
}
