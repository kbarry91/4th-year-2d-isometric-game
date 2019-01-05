package ie.gmit.sw.sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ChestModel {
private static ChestModel instance = new ChestModel();
	
	private static BufferedImage image;

	
	private ChestModel() {
		try {
			image = ImageIO.read(new File("./resources/images/objects/0003.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static BufferedImage getImage() {
		return image;
	}
	
	public static ChestModel getInstance() {
		if (instance == null) {
			instance = new ChestModel();
		}
		
		return instance;
	}
}
