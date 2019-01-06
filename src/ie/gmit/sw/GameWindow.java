package ie.gmit.sw;

import java.awt.*;
import java.awt.event.KeyListener;

import javax.swing.*;

import ie.gmit.sw.sprites.ObjectSprite;
import ie.gmit.sw.sprites.PlayerSprite;
import ie.gmit.sw.sprites.Point;
import ie.gmit.sw.sprites.SpriteFactory;
import ie.gmit.sw.sprites.Spriteable;
import ie.gmit.sw.sprites.TileFactory;

public class GameWindow {
	/*
	 * This matrix represents the isometric game model, with each number mapping to
	 * an image in the images/ground/ directory.
	 */
//	private int[][] model = { 
//			{ 1, 0, 0, 0, 0, 0 , 0, 0, 0, 2},
//			{ 0, 1, 0, 0, 0, 0 , 0, 0, 0, 2},
//			{ 0, 0, 2, 0, 0, 0 , 0, 0, 0, 2},
//			{ 0, 0, 0, 1, 0, 0 , 0, 0, 0, 2},
//			{ 2, 2, 2, 2, 1, 0 , 0, 0, 0, 2},
//			{ 3, 3, 3, 3, 1, 1 , 1, 0, 0, 1},
//			{ 5, 5, 5, 5, 3, 3 , 1, 0, 0, 1},
//			{ 4, 4, 4, 5, 3, 3 , 1, 0, 0, 0},
//			{ 4, 4, 4, 4, 5, 3 , 1, TileFactory.getTileInstance("dirtImage"), TileFactory.getTileInstance("dirtImage"), TileFactory.getTileInstance("dirtImage")},
//			{ 4, 4, 4, 4, 4, 3 , 1, 7, 7, 7}
//	};
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

	// This matrix is a representation of where objects (things) in the game are
	// placed
//	private int[][] objects = { 
//			{ 0, 0, 0, 5, 5, 5 , 5, 5, 5, 0},
//			{ 5, 0, 0, 0, 5, 5 , 5, 5, 5, 0},
//			{ 5, 5, 0, 0, 0, 5 , 5, 5, 5, 9},
//			{ 5, 5, 2, 0, 0, 0 , 5, 5, 5, 0},
//			{ 0, 0, 0, 0, 0, 0 , 0, 5, 5, 0},
//			{ 0, 0, 0, 0, 0, 0 , 0, 0, 5, 0},
//			{ 0, 0, 0, 0, 0, 3 , 0, 0, 0, 0},
//			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
//			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
//			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0}
//	};
//	

//	Flyweight & Factory patterns
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
					SpriteFactory.airInstance(), SpriteFactory.airInstance(), SpriteFactory.treeInstance(),
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

	private ImageManager img;
	private PlayerSprite player;
	private String playerSelect;
	private String playerName;

	public GameWindow() throws Exception {

		img = new ImageManager();

		// prompt pop up boxes to input player setup
		playerSelect = MenuDialogs.playerSelect();
		playerName = MenuDialogs.playerName();

		System.out.println("DEBUG : Player Select :" + playerSelect);
		System.out.println("DEBUG : Player Name :" + playerName);

		// switch player sprite based on user input
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
		MenuDialogs.showInfo("Change Direction : Arrow keys\nMove Player      : X\nCollect Chest    : C\nEnter end hole  : C","Controls");

//		JOptionPane.showMessageDialog(null,
//				"hi " + playerName + "! ,Get ready to play using the " + playerSelect + " Character",
//				"Welcome " + player.getName(), JOptionPane.INFORMATION_MESSAGE);

		GameView view = new GameView(model, objects, player);
		EventManager manager = new EventManager(player,objects);
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