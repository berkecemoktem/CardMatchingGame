package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Constants.Helper;
import Controller.UserController;
import Model.User;
import jaco.mp3.player.MP3Player;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.UIManager;
import javax.swing.JToolBar;
import java.awt.Font;

//This is a login page asks for user nickname and calls necessary methods to validate.

public class LoginGUI extends JFrame {

	User user;
	private JPanel contentPane;
	public JTextField nickname_text;
	JFrame gameFrame = new JFrame();
	private JTextField txtHowToPlay;
	

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setTitle("Card Memory Game");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public LoginGUI() {
		UserController userController = new UserController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nickname: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(101, 112, 103, 13);
		contentPane.add(lblNewLabel_1);
		
	    nickname_text = new JTextField();
		nickname_text.setBounds(101, 135, 103, 19);
		contentPane.add(nickname_text);
		nickname_text.setColumns(10);
		
		JButton btn_start = new JButton("Start");
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userController.checkLoginIfSuccessful(nickname_text)) {//validation for nickname
					
					user = new User(nickname_text.getText().toString());
					dispose();
					Board board = new Board();
			    	board.setPreferredSize(new Dimension(500,500)); 
			    	board.setLocation(500, 250);
			    	board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    	board.pack();
			    	board.setVisible(true);
				}		 
				
			}
		});
		btn_start.setBounds(81, 176, 141, 21);
		contentPane.add(btn_start);
		
		txtHowToPlay = new JTextField();
		txtHowToPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try{
					URI uri= new URI("https://www.helpmykidlearn.ie/activities/5-7/detail/memory-card-game");
					java.awt.Desktop.getDesktop().browse(uri);
				}

				catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		txtHowToPlay.setText("Click and learn how to play it!");
		txtHowToPlay.setColumns(10);
		txtHowToPlay.setBounds(124, 494, 164, 19);
		txtHowToPlay.setEditable(false);//user cannot edit it.
		contentPane.add(txtHowToPlay);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\oktem\\Desktop\\loginPage.jpg"));
		lblNewLabel.setBounds(0, 0, 300, 513);
		contentPane.add(lblNewLabel);
		
		
}
	/*public User sendUserToBoardFrame() {
		return user;
	}*/
}
