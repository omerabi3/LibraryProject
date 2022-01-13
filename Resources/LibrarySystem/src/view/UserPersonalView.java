package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginPageController;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
public class UserPersonalView extends JFrame {
	//Attributes.
	private JPanel contentPane;
	private LoginPageController baseController;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	//
	
	//Constructor
	public UserPersonalView(LoginPageController baseController) {
		this.baseController=baseController;
		setupFrame();
		label = new JLabel("User Personal Details");
		label_1 = new JLabel("Email:");
		label_2 = new JLabel("email");
		button = new JButton("History Loans");
		button_1 = new JButton("Active Loans");
		button_2 = new JButton("Back");
		label_3 = new JLabel("Last Name:");
		label_4 = new JLabel("last_name");
		label_5 = new JLabel("first_name");
		label_6 = new JLabel("First Name:");
		label_5.setText(baseController.getStudent().getStudentFirstName());
		label_4.setText(baseController.getStudent().getStudentLastName());
		label_2.setText(baseController.getStudent().getStudentEmail());
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
		setBounds(100, 100, 452, 361);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void setupLayout()//Setups the views Layout.
	{
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(105, 31, 192, 14);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(229, 78, 60, 14);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(299, 75, 140, 20);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(229, 182, 150, 54);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(26, 182, 142, 54);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBounds(0, 291, 89, 27);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(10, 119, 85, 14);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(105, 119, 96, 20);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(105, 75, 96, 20);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(6, 78, 89, 14);
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(label_3);
		contentPane.add(label_4);
		contentPane.add(label_5);
		contentPane.add(label_6);
	}
	private void setupListeners()//Setups the views listeners.
	{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoryLoansView historyLoansView = new HistoryLoansView(baseController);
				closeForm();
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserMenuView userMenuView = new UserMenuView(baseController);
				closeForm();
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				ActiveLoansView activeLoansView = new ActiveLoansView(baseController);
				closeForm();
			}
			
		});
	}
	public void closeForm()//Closes this form and disposes it.
	{
		this.dispose();
	}

}
