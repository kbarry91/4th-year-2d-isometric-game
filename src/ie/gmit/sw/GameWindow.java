package ie.gmit.sw;

import java.awt.*;
import javax.swing.*;
import ie.gmit.sw.sprites.ObjectSprite;
import ie.gmit.sw.sprites.PlayerSprite;
import ie.gmit.sw.sprites.Point;
import ie.gmit.sw.sprites.SpriteFactory;
import ie.gmit.sw.sprites.TileFactory;

/**
 * Represents a GameWindow. This is the main game window that acts as a
 * container for <code>GameView</code>.
 * 
 * @author Kevin Barry
 */
public class GameWindow {

	private PlayerSprite player;
	private String playerSelect;
	private String playerName;

	/*
	 * This matrix represents the isometric game model of tiles demonstrating the
	 * Flyweight and factory pattern.
	 */
	private ObjectSprite[][] model = {
			{ TileFactory.getTileInstance("stoneImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("mossStoneImage") },
			{ TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("stoneImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("mossStoneImage") },
			{ TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("mossStoneImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("mossStoneImage") },
			{ TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("stoneImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("mossStoneImage") },
			{ TileFactory.getTileInstance("mossStoneImage"), TileFactory.getTileInstance("mossStoneImage"),
					TileFactory.getTileInstance("mossStoneImage"), TileFactory.getTileInstance("mossStoneImage"),
					TileFactory.getTileInstance("stoneImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("mossStoneImage") },
			{ TileFactory.getTileInstance("sandImage"), TileFactory.getTileInstance("sandImage"),
					TileFactory.getTileInstance("sandImage"), TileFactory.getTileInstance("sandImage"),
					TileFactory.getTileInstance("stoneImage"), TileFactory.getTileInstance("stoneImage"),
					TileFactory.getTileInstance("stoneImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("stoneImage") },
			{ TileFactory.getTileInstance("coastImage"), TileFactory.getTileInstance("coastImage"),
					TileFactory.getTileInstance("coastImage"), TileFactory.getTileInstance("coastImage"),
					TileFactory.getTileInstance("sandImage"), TileFactory.getTileInstance("sandImage"),
					TileFactory.getTileInstance("stoneImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("stoneImage") },
			{ TileFactory.getTileInstance("waterImage"), TileFactory.getTileInstance("waterImage"),
					TileFactory.getTileInstance("waterImage"), TileFactory.getTileInstance("coastImage"),
					TileFactory.getTileInstance("sandImage"), TileFactory.getTileInstance("sandImage"),
					TileFactory.getTileInstance("stoneImage"), TileFactory.getTileInstance("grassImage"),
					TileFactory.getTileInstance("grassImage"), TileFactory.getTileInstance("grassImage") },
			{ TileFactory.getTileInstance("waterImage"), TileFactory.getTileInstance("waterImage"),
					TileFactory.getTileInstance("waterImage"), TileFactory.getTileInstance("waterImage"),
					TileFactory.getTileInstance("coastImage"), TileFactory.getTileInstance("sandImage"),
					TileFactory.getTileInstance("stoneImage"), TileFactory.getTileInstance("dirtImage"),
					TileFactory.getTileInstance("dirtImage"), TileFactory.getTileInstance("dirtImage") },
			{ TileFactory.getTileInstance("waterImage"), TileFactory.getTileInstance("waterImage"),
					TileFactory.getTileInstance("waterImage"), TileFactory.getTileInstance("waterImage"),
					TileFactory.getTileInstance("waterImage"), TileFactory.getTileInstance("sandImage"),
					TileFactory.getTileInstance("stoneImage"), TileFactory.getTileInstance("fineStoneImage"),
					TileFactory.getTileInstance("fineStoneImage"), TileFactory.getTileInstance("fineStoneImage") } };

	/*
	 * This matrix represents the isometric game model of objects demonstrating the
	 * Flyweight and factory pattern.
	 */
	private ObjectSprite[][] objects = {
			{ SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.treeInstance(), SpriteFactory.treeInstance(), SpriteFactory.treeInstance(),
					SpriteFactory.treeInstance(), SpriteFactory.treeInstance(), SpriteFactory.treeInstance(),
					SpriteFactory.airInstance() },
			{ SpriteFactory.treeInstance(), SpriteFactory.chestInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.treeInstance(), SpriteFactory.treeInstance(),
					SpriteFactory.treeInstance(), SpriteFactory.treeInstance(), SpriteFactory.treeInstance(),
					SpriteFactory.airInstance() },
			{ SpriteFactory.treeInstance(), SpriteFactory.treeInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.treeInstance(),
					SpriteFactory.treeInstance(), SpriteFactory.treeInstance(), SpriteFactory.treeInstance(),
					SpriteFactory.holeInstance() },
			{ SpriteFactory.treeInstance(), SpriteFactory.treeInstance(), SpriteFactory.signInstance(),
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.treeInstance(), SpriteFactory.treeInstance(), SpriteFactory.treeInstance(),
					SpriteFactory.airInstance() },
			{ SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.treeInstance(), SpriteFactory.treeInstance(),
					SpriteFactory.airInstance() },
			{ SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.chestInstance(), SpriteFactory.treeInstance(),
					SpriteFactory.airInstance() },
			{ SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.chestInstance(),
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance() },
			{ SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance() },
			{ SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance() },
			{ SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.airInstance(),
					SpriteFactory.airInstance() } };

	/**
	 * Creates a new <code>GameWindow</code>.
	 *
	 * @throws Exception
	 */
	public GameWindow() throws Exception {

		// img = new ImageManager();

		// prompt pop up boxes to input player setup
		playerSelect = MenuDialogs.playerSelect();
		playerName = MenuDialogs.playerName();

		// Create player object using factory pattern depending on user input.
		switch (playerSelect) {
		case "Type1":
			player = SpriteFactory.player1Instance();
			break;
		case "Type2":
			player = SpriteFactory.player2Instance();
			break;
		default:
			player = SpriteFactory.player1Instance();
			break;

		}

		player.setName(playerName);
		player.setPosition(new Point(0, 0));

		// Show info dialog.
		MenuDialogs.showInfo(player, playerSelect);
		// show controls
		MenuDialogs.showInfo(
				"Change Direction : Arrow keys\nMove Player      : X\nCollect Chest    : C\nEnter end hole  : C",
				"Controls");

		GameView view = new GameView(model, objects, player);
		EventManager manager = new EventManager(player, objects);

		Dimension d = new Dimension(Properties.getDefaultViewSize(), Properties.getDefaultViewSize() / 2);
		view.setPreferredSize(d);
		view.setMinimumSize(d);
		view.setMaximumSize(d);

		JFrame f = new JFrame("GMIT - B.Sc. in Computing (Software Development)");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout());

		f.setVisible(true);

		f.add(view);
		f.addKeyListener(manager);
		f.setSize(1000, 1000);
		f.setLocation(100, 100);
		f.pack();
		f.setVisible(true);
	}
}