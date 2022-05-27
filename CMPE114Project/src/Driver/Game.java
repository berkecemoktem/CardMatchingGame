package Driver;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import View.Board;
import jaco.mp3.player.MP3Player;

//includes main method to drive the project
public class Game{
    public static void main(String[] args){
        
    	Board board = new Board();
    	board.setPreferredSize(new Dimension(500,500)); 
    	board.setLocation(500, 250);
    	board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	board.pack();
    	board.setVisible(true);
    	
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}   
}