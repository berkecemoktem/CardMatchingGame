package Model;

import javax.swing.JTextField;

//this is a service offering some method for user entity.
//user controller class implements this interface

public interface IUserService {
	public boolean checkLoginIfSuccessful(JTextField textField);
}
