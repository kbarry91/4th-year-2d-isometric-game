package ie.gmit.sw.sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HoleModel {
private static HoleModel instance = new HoleModel();
	
	private static BufferedImage image;

	
	private HoleModel() {
		try {
			image = ImageIO.read(new File("./resources/images/objects/0009.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static BufferedImage getImage() {
		return image;
	}
	
	public static HoleModel getInstance() {
		if (instance == null) {
			instance = new HoleModel();
		}
		
		return instance;
	}
}
