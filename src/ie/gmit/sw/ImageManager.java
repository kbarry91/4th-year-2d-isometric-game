package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ImageManager {

	public ImageManager() {
		super();
	}

	public static BufferedImage[] loadImages(String directory, BufferedImage[] img) throws Exception {

		File dir = new File(directory);
		File[] files = dir.listFiles();
		Arrays.sort(files, (s, t) -> s.getName().compareTo(t.getName()));

		img = new BufferedImage[files.length];
		for (int i = 0; i < files.length; i++) {
			img[i] = ImageIO.read(files[i]);
		}
		return img;
	}

	public static BufferedImage loadImage(String img) throws IOException {
		return ImageIO.read(new File(img));

	}
}
