package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;

import ie.gmit.sw.sprites.ObjectSprite;
import ie.gmit.sw.sprites.PlayerSprite;
import ie.gmit.sw.sprites.Point;

/*
 * Controls manipulation of game view including action events and painting components to view.
 * 
 * @author Kevin Barry
 */
public class GameView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 777L;

	private static GameView myInstance;
	private PlayerSprite player;
	private Isometric iso;
	private boolean endMessagePrompt = false;
	public boolean removedSprite = false;
	private Timer timer; // Controls the repaint interval.

	private ObjectSprite[][] matrix;
	private ObjectSprite[][] things;

	private BufferedImage[] tiles; // Note that all images, including sprites, have dimensions of 128 x 64. This
									// make painting much simpler.
	private BufferedImage[] objects;
	private Color[] cartesian = { Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW,
			Color.PINK, Color.BLACK }; // This is a 2D representation

	private boolean isIsometric = true; // Toggle between 2D and Isometric (Z key)

	public GameView() {
		super();
	}

	/**
	 * Creates a new <code>GameView</code>.
	 *
	 * @param matrix Model for tiles.
	 * @param things Model for objects.
	 * @param player A PlayerSprite object.
	 * @throws Exception
	 */
	public GameView(ObjectSprite[][] matrix, ObjectSprite[][] things, PlayerSprite player) throws Exception {
		this.player = player;
		iso = new Isometric();

		init();
		this.matrix = matrix;
		this.things = things;

		setBackground(Color.WHITE);
		setDoubleBuffered(true); // Each image is buffered twice to avoid tearing / stutter

		timer = new Timer(100, this); // calls the actionPerformed() method every 100ms
		timer.start(); // Start the timer
	}

	/**
	 * 
	 * @return An instance of GameView.
	 */
	public static GameView getInstance() {
		if (myInstance == null) {
			myInstance = new GameView();
		}
		return myInstance;
	}

	private void init() throws Exception {
		tiles = ImageManager.loadImages("./resources/images/ground", tiles);
		objects = ImageManager.loadImages("./resources/images/objects", objects);
	}

	/**
	 * Toggles the view to or from isometric.
	 */
	public void toggleView() {
		System.out.println("Toggle View!");
		this.isIsometric = !isIsometric;
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) { // This is called each time the timer reaches zero

		if (player.getChestsCollected() == 3 && !endMessagePrompt) {
			MenuDialogs.showInfo("All chests collected!\n Proceed to hole to finish level", "Game Progress ");
			endMessagePrompt = true;
		}

		if (player.isEndPointActivated()) {
			// play sound effect
			SoundEffect.APPLAUSE.play();
			MenuDialogs.showInfo("Congratulations " + player.getName() + " Level complete!", "Game Progress ");
			System.exit(0);
		}

		this.repaint();// calls paint component from this class not jpanel
	}

	/**
	 * Paints the graphics.
	 * 
	 * @param g A graphic component.
	 */
	public void paintComponent(Graphics g) { // This method needs to execute quickly...

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int imageIndex = -1, x1 = 0, y1 = 0;
		Point point;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {

				// Paint the ground tiles
				if (isIsometric) {
					x1 = iso.getIsoX(col, row);
					y1 = iso.getIsoY(col, row);

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

				g2.drawImage(things[row][col].getImage(), x1, y1, null);

			}
		}

		// Paint the player on the ground
		point = iso.getIso(player.getPosition().getX(), player.getPosition().getY());
		g2.drawImage(player.getImage(), point.getX(), point.getY(), null);
	}
}