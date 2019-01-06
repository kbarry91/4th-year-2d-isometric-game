package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;

import ie.gmit.sw.sprites.ObjectSprite;
import ie.gmit.sw.sprites.PlayerSprite;
import ie.gmit.sw.sprites.Point;
import ie.gmit.sw.sprites.Spriteable;

import javax.imageio.*;
import java.io.*;
import java.util.*;

/*
 * This is a God class and is doing way too much. The instance variables cover everything from isometric to 
 * Cartesian drawing and the class has methods for loading images and converting from one coordinate space to
 * another.
 * 
 */
public class GameView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 777L;

	private static GameView myInstance;

	private PlayerSprite player;
	private ImageManager img;
	private Iso iso;
	private EventManager manager;
	private boolean endMessagePrompt=false;
	private Timer timer; // Controls the repaint interval.

	// Do we really need two models like this?
	private ObjectSprite[][] matrix;
//	private int[][] things;
	private ObjectSprite[][] things;

	private BufferedImage[] tiles; // Note that all images, including sprites, have dimensions of 128 x 64. This
									// make painting much simpler.
	private BufferedImage[] objects; // Taller sprites can be created, by using two tiles (head torso, lower body and
										// legs) and improve animations
	private Color[] cartesian = { Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW,
			Color.PINK, Color.BLACK }; // This is a 2D representation

	private boolean isIsometric = true; // Toggle between 2D and Isometric (Z key)

	public GameView() {
		super();
	}

//	public GameView(int[][] matrix, int[][] things, PlayerSprite player) throws Exception {
	public GameView(ObjectSprite[][] matrix, ObjectSprite[][] things, PlayerSprite player) throws Exception {
		this.player = player;
		img = new ImageManager();
		iso = new Iso();

		init();
		this.matrix = matrix;

		this.things = things;

		setBackground(Color.WHITE);
		setDoubleBuffered(true); // Each image is buffered twice to avoid tearing / stutter

		timer = new Timer(100, this); // calls the actionPerformed() method every 100ms
		timer.start(); // Start the timer
	}

	public static GameView getInstance() {
		if (myInstance == null) {
			myInstance = new GameView();
		}
		return myInstance;
	}

	private void init() throws Exception {
		tiles = img.loadImages("./resources/images/ground", tiles);
		objects = img.loadImages("./resources/images/objects", objects);
	}

	public void toggleView() {
		System.out.println("Toggle View!");
		this.isIsometric = !isIsometric;
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) { // This is called each time the timer reaches zero
		
		if (player.getChestsCollected()==3 && !endMessagePrompt) {
			MenuDialogs.showInfo("All chests collected!\n Proceed to hole to finish level","Game Progress ");
			endMessagePrompt=true;
			
			
		}
		if (player.isEndPointActivated()) {
			MenuDialogs.showInfo("Congratulations "+player.getName()+" Level complete!","Game Progress ");

			System.exit(0);
		}
		
		this.repaint();// calls paintcomponent from this class not jpanel
	}

	public void paintComponent(Graphics g) { // This method needs to execute quickly...

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int imageIndex = -1, x1 = 0, y1 = 0;
		Point point;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				// imageIndex = matrix[row][col];

				// if (imageIndex >= 0 && imageIndex < tiles.length) {
				// Paint the ground tiles
				if (isIsometric) {
					x1 = iso.getIsoX(col, row);
					y1 = iso.getIsoY(col, row);

					// g2.drawImage(tiles[Properties.getDefaultImageIndex()], x1, y1, null);
					// if (imageIndex > Properties.getDefaultImageIndex()) {
					// g2.drawImage(tiles[imageIndex], x1, y1, null);
					// }
					g2.drawImage(matrix[row][col].getImage(), x1, y1, null);
				} else {
					x1 = col * Properties.getTileWidth();
					y1 = row * Properties.getTileHeight();
					
					if (imageIndex < cartesian.length) {
						g2.setColor(cartesian[imageIndex]);
					} else {
						g2.setColor(Color.WHITE);
					}

					g2.fillRect(x1, y1, Properties.getTileWidth(), Properties.getTileWidth());
				}
				// Paint the object or things on the ground
//					imageIndex = things[row][col];
//					g2.drawImage(objects[imageIndex], x1, y1, null);

				g2.drawImage(things[row][col].getImage(), x1, y1, null);

				// }
			}
		}

		// Paint the player on the ground
		point = iso.getIso(player.getPosition().getX(), player.getPosition().getY());
		g2.drawImage(player.getImage(), point.getX(), point.getY(), null);
	}
}