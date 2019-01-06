package ie.gmit.sw;

import javax.swing.JOptionPane;
import ie.gmit.sw.sprites.PlayerSprite;

/*
 * A class to abstract all dialog box actions from gameview.
 * 
 * @author Kevin Barry
 */
public class MenuDialogs {

	/**
	 * Pops up a dialog to prompt input of player sprite.
	 * 
	 * @return A string containing the player type sprite.
	 */
	public static String playerSelect() {
		String defaultValue = "Type1";
		Object[] selectionValues = { "Type1", "Type2" };
		String initialSelection = "Type1";
		Object selection = JOptionPane.showInputDialog(null, "Select a character?", "Character Select",
				JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		System.out.println(selection);
		if ((String) selection == null)
			return defaultValue;
		return (String) selection;
	}

	/**
	 * Pops up a dialog to prompt input of player name.
	 * 
	 * @return A string containing the name of the player.
	 */
	public static String playerName() {
		String defaultValue = "Player1";
		String name = JOptionPane.showInputDialog("Enter your name?", "Player1");
		if (name == null)
			return defaultValue;
		return name;
	}

	/**
	 * Displays a pop up box of information.
	 * 
	 * @param player The player object.
	 * @param p      The name of the player sprite type.
	 */
	public static void showInfo(PlayerSprite player, String p) {
		JOptionPane.showMessageDialog(null,
				"hi " + player.getName() + "!, Get ready to play using the " + p
						+ " Character\nAim : Collect all chests and proceed to hole",
				"Instructions", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Displays a pop up box of information.
	 * 
	 * @param message The message to display.
	 * @param header  The header for the pop up dialog box.
	 */
	public static void showInfo(String message, String header) {
		JOptionPane.showMessageDialog(null, message, header, JOptionPane.INFORMATION_MESSAGE);
	}

}
