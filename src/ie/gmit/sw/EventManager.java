package ie.gmit.sw;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import ie.gmit.sw.sprites.Chest;
import ie.gmit.sw.sprites.Direction;
import ie.gmit.sw.sprites.ObjectSprite;
import ie.gmit.sw.sprites.PlayerSprite;

public class EventManager implements KeyListener{

	private PlayerSprite player;
	private ObjectSprite[][] objects;
	
	public EventManager(PlayerSprite player,ObjectSprite[][] objects) {
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
		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			System.out.println("Move");
			player.move();
			// Check if player lands on grid square with chest
			if(objects[player.getPosition().getY()][+player.getPosition().getX()] instanceof Chest) {
				System.out.println("PLayer collided with chest");
				MenuDialogs.showInfo("Player collided with chest");
			}
		} else {
			return;
		}
		//System.out.println("Debug: EventManger playerpos:x:"+player.getPosition().getX()+" y:"+player.getPosition().getY());
//	 if (objects[player.getPosition().getX()][+player.getPosition().getY()]) {
//		 
//	 }
		//System.out.println("Obtype:"+objects[player.getPosition().getY()][+player.getPosition().getX()].getClass());
	}
	
	public void keyReleased(KeyEvent e) {
	} // Ignore
	
	public void keyTyped(KeyEvent e) {
	} // Ignore
}
