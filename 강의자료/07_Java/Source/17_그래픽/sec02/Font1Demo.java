package sec02;

import java.awt.GraphicsEnvironment;

public class Font1Demo {
	public static void main(String[] args) {
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		String[] fontNames = e.getAvailableFontFamilyNames();
		
		for (String s : fontNames)
			System.out.println(s);
	}
}