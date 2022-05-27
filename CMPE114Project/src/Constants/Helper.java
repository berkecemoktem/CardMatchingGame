package Constants;
import javax.swing.JOptionPane;

//This class provides us to use some constant messages we use frequently.
//Since, we use them frequently they were built as static

public class Helper {
	
	public static String loginSuccessful = "Login is successful. Welcome, ";
	public static String nicknameEmpty = "Nickname field cannot be empty!";
	public static String charNumNotInInterval = "Number of characters must be between 3 and 12";
	public static String notOnlyLetters = "Nickname cannot contain elements except from characters";
	
	public static void loginSuccessfulMessage(String userName) {
		 JOptionPane.showMessageDialog(null, loginSuccessful + " " + userName);
	}
	public static void nicknameIsEmptyMesage() {
		 JOptionPane.showMessageDialog(null, nicknameEmpty);
	}
	public static void charNumNotInIntervalMesage() {
		 JOptionPane.showMessageDialog(null, charNumNotInInterval);
	}
	public static void notOnlyCharactersMesage() {
		 JOptionPane.showMessageDialog(null, notOnlyLetters);
	}
}
