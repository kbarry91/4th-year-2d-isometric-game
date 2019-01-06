package ie.gmit.sw;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ie.gmit.sw.sprites.PlayerSprite;

public class MenuDialogs {

	// private String playerSelection;
	// private String playerName;

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

	public static String playerName() {
		String defaultValue = "Player1";
		String name = JOptionPane.showInputDialog("Enter your name?", "Player1");
		if (name == null)
			return defaultValue;
		return name;
	}

	public static void showInfo(PlayerSprite player, String p) {
		JOptionPane.showMessageDialog(null,
				"hi " + player.getName() + "!, Get ready to play using the " + p
						+ " Character\nAim : Collect all chests and proceed to hole",
				"Instructions", JOptionPane.INFORMATION_MESSAGE);

	}

	public static void showInfo(String message, String header) {
		JOptionPane.showMessageDialog(null, message, header, JOptionPane.INFORMATION_MESSAGE);

	}

}
