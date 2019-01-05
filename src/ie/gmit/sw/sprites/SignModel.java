package ie.gmit.sw.sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SignModel {
private static SignModel instance = new SignModel();
	
	private static BufferedImage image;

	
	private SignModel() {
		try {
			image = ImageIO.read(new File("./resources/images/objects/0002.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static BufferedImage getImage() {
		return image;
	}
	
	public static SignModel getInstance() {
		if (instance == null) {
			instance = new SignModel();
		}
		
		return instance;
	}
}
