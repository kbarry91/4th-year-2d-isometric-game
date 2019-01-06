package ie.gmit.sw;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ie.gmit.sw.sprites.ChestSprite;
import ie.gmit.sw.sprites.HoleSprite;
import ie.gmit.sw.sprites.ObjectSprite;
import ie.gmit.sw.sprites.PlayerSprite;
import ie.gmit.sw.sprites.SpriteFactory;

/*
 * Handles events that occur when a key is pressed.
 * 
 * @author Kevin Barry
 */
public class EventManager implements KeyListener {

	private PlayerSprite player;
	private ObjectSprite[][] objects;

	/**
	 * Creates a new <code>EventManager</code>.
	 *
	 * @param player  The player object.
	 * @param objects Matrix of game objects.
	 */
	public EventManager(PlayerSprite player, ObjectSprite[][] objects) {
		this.player = player;
		this.objects = objects;
	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("Player moving right");
			player.setDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("Player moving left");
			player.setDirection(Direction.LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("Player moving Up");
			player.setDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("Player moving Down");
			player.setDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_Z) {
			GameView view = GameView.getInstance();
			view.toggleView();
		} else if (e.getKeyCode() == KeyEvent.VK_C) {// player has triggered action

			System.out.println("Debug: EventManger: C(attack) pressed");

			// Player has landed on chest grid.
			if (objects[player.getPosition().getY()][+player.getPosition().getX()] instanceof ChestSprite) {
				MenuDialogs.showInfo("Player collected chest :" + (player.getChestsCollected() + 1) + "/3",
						"Game Progress ");
				player.setChestsCollected(player.getChestsCollected() + 1);

				// Remove chest sprite from game.
				try {
					objects[player.getPosition().getY()][+player.getPosition().getX()] = SpriteFactory.blankInstance();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			// If player presses C while on holeSprite.
			if (objects[player.getPosition().getY()][player.getPosition().getX()] instanceof HoleSprite) {

				// If all chests have been collected.
				if (player.getChestsCollected() == 3)
					player.setEndPointActivated(true);
				else {
					MenuDialogs.showInfo("Collect all Chests and return to complete level", "Game Progress");
				}
			}

		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			player.move();
		} else {
			return;
		}
	}

	public void keyReleased(KeyEvent e) {
	} // Ignore

	public void keyTyped(KeyEvent e) {
	} // Ignore
}
