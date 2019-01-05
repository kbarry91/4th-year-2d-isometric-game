package ie.gmit.sw;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ie.gmit.sw.sprites.Direction;
import ie.gmit.sw.sprites.PlayerSprite;

public class EventManager implements KeyListener{

	private PlayerSprite player;
	
	public EventManager(PlayerSprite player) {
		this.player = player;
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
		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			System.out.println("Move");
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
