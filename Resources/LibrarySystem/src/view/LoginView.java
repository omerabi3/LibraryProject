package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginPageController;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
public class LoginView extends JFrame {
	//Attributes.
	private JPanel contentPane;
	private JPasswordField passwordField;
	private LoginPageController baseController;
	private JLabel label;
	private JLabel label_1;
	private JTextPane textPane;
	private JLabel label_2;
	private JButton button;
	private JButton button_1;
	private JLabel label_3;
	private JLabel lblLibraryManagmentSystem;
	private JButton btnExit;
	//
	//Constructor
	public LoginView(LoginPageController baseController) {
		this.baseController=baseController;
		setupFrame();
		lblLibraryManagmentSystem = new JLabel("Library Managment System");
		label = new JLabel("Login Page");
		label_1 = new JLabel("User Name :");
		textPane = new JTextPane();
		label_2 = new JLabel("Password :");
		button = new JButton("Sign in");
		button_1 = new JButton("About");
		btnExit = new JButton("Exit");
		label_3 = new JLabel("");
		passwordField = new JPasswordField();
		setupPanel();
		setupLayout();
		setupListeners();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
	}
	//
	
	private void setupFrame()//Setups the views Frame.
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(textPane);
		contentPane.add(passwordField);
		contentPane.add(label_2);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(label_3);
		contentPane.add(lblLibraryManagmentSystem);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnExit.setBounds(0, 330, 96, 39);
		contentPane.add(btnExit);
	}
	private void setupLayout()//Setups the views Layout.
	{
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(118, 78, 173, 59);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(64, 148, 135, 21);
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(184, 148, 183, 28);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(184, 202, 183, 28);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(64, 199, 117, 27);
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBounds(194, 252, 173, 39);
		button_1.setBounds(605, 346, 89, 23);
		label_3.setForeground(Color.WHITE);
		label_3.setBackground(new Color(0, 0, 0, 0));
		label_3.setBounds(413, 69, 216, 222);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("Pictures/librarySystem.png").getImage().getScaledInstance(217, 207, Image.SCALE_DEFAULT));
		label_3.setIcon(imageIcon);
		lblLibraryManagmentSystem.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblLibraryManagmentSystem.setBounds(151, 19, 406, 39);
	}
	public void hideForm()//Closes this form and disposes it.
	{
		this.setVisible(false);
	}
	private void setupListeners()//Setups the views listeners.
	{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				String userName = textPane.getText();
				String password = passwordField.getText();
				textPane.setText("");
				passwordField.setText("");
				if(baseController.signIn(userName, password))
				{
					hideForm();
				}
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeForm();
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutView aboutView = new AboutView(baseController);
				hideForm();
			}
		});
	}
	public void closeForm()//Closes this form and disposes it.
	{
		this.dispose();
	}
}
