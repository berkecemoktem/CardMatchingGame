package View;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import Model.Card;
import Model.IUserService;
import Model.User;
import jaco.mp3.a.F;
import jaco.mp3.player.MP3Player;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

//board is a JFrame
//So, it is a GUI. It contains the list of card and make visible all of the functionality to the user.

public class Board extends JFrame{

	User user;
	private List<Card> cards;
	private Card selectedCard;
	private Card firstSelectedCard;
	private Card secondSelectedCard;
	private Timer t;
	public static String PlayingMusicPath = "C:\\Users\\oktem\\Desktop\\JavaProjects\\CMPE114Project\\src\\jazzMusic.mp3";
	public static String CongSound = "C:\\Users\\oktem\\Desktop\\JavaProjects\\CMPE114Project\\src\\congSound.mp3";
	public static String MatchSound = "C:\\Users\\oktem\\Desktop\\JavaProjects\\CMPE114Project\\src\\matchSound.mp3";
	MP3Player mp3PlayerGame;
	MP3Player mp3PlayerMatch;
	MP3Player mp3PlayerCongrulations;
	
	public Board(){

		user = new User(new LoginGUI().nickname_text.toString());
	
		mp3PlayerGame = new MP3Player((new File(PlayingMusicPath)));

		int music_result = JOptionPane.showConfirmDialog(this, "Play Music?", "Music",JOptionPane.YES_NO_OPTION);
		if(music_result == JOptionPane.YES_OPTION) {		
			mp3PlayerGame.play();
		}

		int pairs = 10;
		List<Card> cardsList = new ArrayList<Card>();
		List<Integer> cardValues = new ArrayList<Integer>();

		//giving the values to the cards(like 1,1    2,2    3,3)
		for (int i = 0; i < pairs; i++){
			cardValues.add(i);
			cardValues.add(i);
		}
		Collections.shuffle(cardValues); //shuffling the cards in order to make it more challenging.

		//setting the ids of cards(we have 20 cards in the end).
		for (int v : cardValues){
			Card c = new Card();
			c.setBackground(Color.BLUE);
			c.setForeground(Color.YELLOW);
			c.setFont(new Font("Arial", Font.PLAIN, 60));
			c.setId(v);
			c.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent ae){	
					selectedCard = c;
					turnOnCard();
				}
			});
			cardsList.add(c);
		}
		this.cards = cardsList;
		
		//timer is set up.
		t = new Timer(750, new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				checkIfMatch();
			}
		});

		t.setRepeats(false);

		//setting up the board.
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(4, 5));
		for (Card c : cards){
			pane.add(c);
		}
		setTitle("CMPE114 GAME PROJECT");
	}

	public void turnOnCard(){
		if (firstSelectedCard == null && secondSelectedCard == null){
			firstSelectedCard = selectedCard;
			firstSelectedCard.setText(String.valueOf(firstSelectedCard.getId()));
		}

		if (firstSelectedCard != null && firstSelectedCard != selectedCard && secondSelectedCard == null){
			secondSelectedCard = selectedCard;
			secondSelectedCard.setText(String.valueOf(secondSelectedCard.getId()));
			t.start();

		}
	}

	public void checkIfMatch(){
		if (firstSelectedCard.getId() == secondSelectedCard.getId()){//match condition
			mp3PlayerMatch = new MP3Player(new File(MatchSound));
			mp3PlayerMatch.play();
			firstSelectedCard.setEnabled(false); //disables the button
			secondSelectedCard.setEnabled(false);
			firstSelectedCard.setMatched(true); //matched.
			secondSelectedCard.setMatched(true);
			user.score += 10;
			if(this.isGameWon()){
				if(user.score > 5) {
					mp3PlayerCongrulations = new MP3Player(new File(CongSound));
					mp3PlayerCongrulations.play();  
					JOptionPane.showMessageDialog(this, "Game is over \n" +
						"Thanks for your effort!  \n"  +
						"score : " + user.score);
				}
				else {
				JOptionPane.showMessageDialog(this, "Game is over \n" +
						"Thanks for your effort!  \n"  +
						"score : " + user.score);
				}
				
				int result = JOptionPane.showConfirmDialog(this, "Play Again?", "Game is over ",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					mp3PlayerGame.stop();
					this.dispose();
					Board board = new Board();
			    	board.setPreferredSize(new Dimension(500,500)); 
			    	board.setLocation(500, 250);
			    	board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    	board.pack();
			    	board.setVisible(true);

				}
				else if(result == JOptionPane.NO_OPTION) {
					this.dispose();	
					System.exit(0);
				}

			}
		}

		else{
			firstSelectedCard.setText(""); //hiding the text
			secondSelectedCard.setText("");
			user.score -= 6;
		}
		firstSelectedCard = null; //reseting first selected card and second selected card.
		secondSelectedCard = null;
	}

	public boolean isGameWon(){
		for(Card c: this.cards){
			if (c.getMatched() == false){
				return false;
			}
		}
		return true;
	}
	

}