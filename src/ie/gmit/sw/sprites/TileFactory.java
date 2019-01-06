package ie.gmit.sw.sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import ie.gmit.sw.ImageLoader;

// Singleton

/**
 * A singleton class.Instead of loading data every time it is loaded into memory
 * once and shared between consumers.
 * 
 * @author Kevin Barry
 */
public class TileFactory {

	// An eagar instantiation.
	private static TileFactory instance = new TileFactory();
	private static Map<String, BufferedImage> imageMap;

	/**
	 * Constructs a <code>TileFactory</code>. Maps images to a key for reuse.
	 */
	private TileFactory() {
		imageMap = new HashMap<>();

		try {
			// flyweight pattern: intrinsic state
			imageMap.put("stoneImage", ImageLoader.loadImage("./resources/images/ground/0001.png"));
			imageMap.put("grassImage", ImageLoader.loadImage("./resources/images/ground/0000.png"));
			imageMap.put("waterImage", ImageLoader.loadImage("./resources/images/ground/0004.png"));
			imageMap.put("sandImage", ImageLoader.loadImage("./resources/images/ground/0003.png"));
			imageMap.put("dirtImage", ImageLoader.loadImage("./resources/images/ground/0006.png"));
			imageMap.put("coastImage", ImageLoader.loadImage("./resources/images/ground/0005.png"));
			imageMap.put("fineStoneImage", ImageLoader.loadImage("./resources/images/ground/0007.png"));
			imageMap.put("mossStoneImage", ImageLoader.loadImage("./resources/images/ground/0002.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return a instance of TileFactory.
	 */
	public static TileFactory getInstance() {
		return instance;
	}

	/**
	 * Uses the imageMap to retrieve an instance of the specified tile type.
	 * 
	 * @param tileName A key string mapped to a tile.
	 * @return A tile object.
	 */
	public static Tile getTileInstance(String tileName) throws Exception {
		Tile tile = new Tile();
		// set image
		tile.image = imageMap.get(tileName);
		return tile;
	}

}
