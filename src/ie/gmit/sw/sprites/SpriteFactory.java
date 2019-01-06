package ie.gmit.sw.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import ie.gmit.sw.ImageManager;

/**
 * A singleton class factory class. Instead of loading data every time it is
 * loaded into memory once and shared between consumers.
 * 
 * @author Kevin Barry
 */
public class SpriteFactory {
	// eagar instantiation
	private static SpriteFactory instance = new SpriteFactory();
	private static Map<String, BufferedImage> imageMap;

	/**
	 * Constructs a <code>SpriteFactory</code>. Maps images to a key for reuse.
	 */
	private SpriteFactory() {
		imageMap = new HashMap<>();

		try {
			imageMap.put("treeImage", ImageManager.loadImage("./resources/images/objects/0005.png"));
			imageMap.put("signImage", ImageManager.loadImage("./resources/images/objects/0002.png"));
			imageMap.put("chestImage", ImageManager.loadImage("./resources/images/objects/0003.png"));
			imageMap.put("holeImage", ImageManager.loadImage("./resources/images/objects/0009.png"));
			imageMap.put("blankImage", ImageManager.loadImage("./resources/images/objects/0000.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return An instance of Spritefactory.
	 */
	public static SpriteFactory getInstance() {
		return instance;
	}

	/**
	 * Creates and draws a player sprite.
	 * 
	 * @return An instance of a PlayerSprite.
	 */
	public static PlayerSprite playerInstance() throws Exception {

		PlayerSprite player = new PlayerSprite();

		player.drawSprite(ImageManager.loadImages("./resources/images/sprites/default", null));

		return player;
	}

	/**
	 * Creates and draws a player sprite.
	 * 
	 * @return An instance of a PlayerSprite.
	 */
	public static PlayerSprite player1Instance() throws Exception {

		PlayerSprite player = new PlayerSprite();

		player.drawSprite(ImageManager.loadImages("./resources/images/sprites/default", null));

		return player;
	}

	/**
	 * Creates and draws a player sprite.
	 * 
	 * @return An instance of a PlayerSprite.
	 */
	public static PlayerSprite player2Instance() throws Exception {

		PlayerSprite player = new PlayerSprite();

		player.drawSprite(ImageManager.loadImages("./resources/images/sprites/person", null));

		return player;
	}

	/**
	 * Creates and draws a knight sprite.
	 * 
	 * @return An instance of a KnightSprite.
	 */
	public static PlayerSprite knightInstance() throws Exception {

		PlayerSprite player = new PlayerSprite();

		player.setName("Knight 1");
		player.setPosition(new Point(0, 0));
		player.drawSprite(ImageManager.loadImages("./resources/images/sprites/knight", null));

		return player;
	}

	/**
	 * Retrieve an instance of a <code>TreeSprite</code>.
	 * 
	 * @return A tree object.
	 */
	public static TreeSprite treeInstance() throws Exception {
		TreeSprite tree = new TreeSprite();
		// set image
		tree.image = imageMap.get("treeImage");
		return tree;
	}

	/**
	 * Retrieve an instance of a <code>BlankSprite</code>.
	 * 
	 * @return A BlankSprite object.
	 */
	public static BlankSprite blankInstance() throws Exception {
		BlankSprite blank = new BlankSprite();
		// set image
		blank.image = imageMap.get("blankImage");
		return blank;
	}

	/**
	 * Retrieve an instance of a <code>HoleSprite</code>.
	 * 
	 * @return A HoleSprite object.
	 */
	public static HoleSprite holeInstance() throws Exception {
		HoleSprite hole = new HoleSprite();
		// set image
		hole.image = imageMap.get("holeImage");
		return hole;
	}

	/**
	 * Retrieve an instance of a <code>ChestSprite</code>.
	 * 
	 * @return A ChestSprite object.
	 */
	public static ChestSprite chestInstance() throws Exception {
		ChestSprite chest = new ChestSprite();
		// set image
		chest.image = imageMap.get("chestImage");
		return chest;
	}

	/**
	 * Retrieve an instance of a <code>SignSprite</code>.
	 * 
	 * @return A SignSprite object.
	 */
	public static SignSprite signInstance() throws Exception {
		SignSprite sign = new SignSprite();
		// set image
		sign.image = imageMap.get("signImage");
		return sign;
	}

}
