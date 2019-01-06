package ie.gmit.sw;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ie.gmit.sw.sprites.ChestSprite;
import ie.gmit.sw.sprites.Direction;
import ie.gmit.sw.sprites.HoleSprite;
import ie.gmit.sw.sprites.ObjectSprite;
import ie.gmit.sw.sprites.PlayerSprite;
import ie.gmit.sw.sprites.SpriteFactory;

public class EventManager implements KeyListener {

	private PlayerSprite player;
	private ObjectSprite[][] objects;

	public EventManager(PlayerSprite player, ObjectSprite[][] objects) {
		this.player = player;
		this.objects = objects;
	}

//	public void actionPerformed(ActionEvent e) { //This is called each time the timer reaches zero
////		this.repaint();
//	}
//	
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
			// Player has landed on chest grid
			if (objects[player.getPosition().getY()][+player.getPosition().getX()] instanceof ChestSprite) {
				MenuDialogs.showInfo("Player collected chest :" + (player.getChestsCollected() + 1) + "/3",
						"Game Progress ");
				player.setChestsCollected(player.getChestsCollected() + 1);
				// remove chest from game
				try {
					objects[player.getPosition().getY()][+player.getPosition().getX()] = SpriteFactory.airInstance();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			// If player presses C while on hole and all chests collected
			if (objects[player.getPosition().getY()][player.getPosition().getX()] instanceof HoleSprite) {
				if (player.getChestsCollected() == 3)
					player.setEndPointActivated(true);
				else {
					MenuDialogs.showInfo("Collect all Chests and return to complete level", "Game Progress");
				}

			}

		} else if (e.getKeyCode() == KeyEvent.VK_X)

		{
			System.out.println("Move");
			player.move();
			// Check if player lands on grid square with chest

		} else {
			return;
		}
		// System.out.println("Debug: EventManger
		// playerpos:x:"+player.getPosition().getX()+" y:"+player.getPosition().getY());
//	 if (objects[player.getPosition().getX()][+player.getPosition().getY()]) {
//		 
//	 }
		// System.out.println("Obtype:"+objects[player.getPosition().getY()][+player.getPosition().getX()].getClass());
	}

	public void keyReleased(KeyEvent e) {
	} // Ignore

	public void keyTyped(KeyEvent e) {
	} // Ignore
}
