package Model;

import javax.swing.JTextField;

import View.LoginGUI;

//represents the user who plays the game

public class User {

	private String nickname;
	public int score = 0; //initially set to zero.
	

	public User() {
		super();
		
	}



	public User(String nickname) {
		super();
		this.nickname = nickname;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	@Override
	public String toString() {
		return   nickname;
	}

	
	
}
