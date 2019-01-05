package ie.gmit.sw.sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//Flyweight pattern: intrinsic state
public class TreeModel {
	private static TreeModel instance = new TreeModel();
	
	private static BufferedImage image;

	
	private TreeModel() {
		try {
			image = ImageIO.read(new File("./resources/images/objects/0005.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static BufferedImage getImage() {
		return image;
	}
	
	public static TreeModel getInstance() {
		if (instance == null) {
			instance = new TreeModel();
		}
		
		return instance;
	}
	
}
