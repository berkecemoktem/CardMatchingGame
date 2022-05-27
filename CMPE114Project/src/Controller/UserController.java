package Controller;


import javax.swing.JTextField;

import Constants.Helper;
import Model.IUserService;

//this is a business class for user entity
public class UserController implements IUserService {

	//Validation rules of all possible scenarios for nickname.
	@Override
	public boolean checkLoginIfSuccessful(JTextField textField) {
		if(textField.getText().toString().length() == 0) {
			Helper.nicknameIsEmptyMesage();
			return false;
		}
		if(!(textField.getText().matches("[a-zA-Z]+"))) {
			Helper.notOnlyCharactersMesage();
			return false;
		}
		else {
			if((textField.getText().toString().length()) < 3 || (textField.getText().toString().length() > 12)) {
				Helper.charNumNotInIntervalMesage();
				return false;
			} 
			else { //

				Helper.loginSuccessfulMessage(textField.getText());
				return true;
			}
		}
	}

}



	
		

