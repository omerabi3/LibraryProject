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
import javax.swing.*;
public class LibririanMenuView extends JFrame {
	//Attributes.
	private JPanel contentPane;
	private LoginPageController baseController;
	private JLabel label;
	private JLabel label_2;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton btnViewStudentDetails;
	//
	
	//Constructor
	public LibririanMenuView(LoginPageController baseController) {
		this.baseController=baseController;
		setupFrame();
		label = new JLabel("Hello ");
		label_2 = new JLabel("Librarian Interface");
		button = new JButton("Add New Book");
		button_1 = new JButton("View Loans");
		button_2 = new JButton("Show Library Map");
		button_3 = new JButton("Find Book");
		button_4 = new JButton("Sign out");
		btnViewStudentDetails = new JButton("View Student Details");
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
		setBounds(100, 100, 522, 374);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void setupLayout()//Setups the views Layout.
	{
		label.setText(baseController.getLibririan().getLibrarianFirstName());
		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBounds(43, 11, 118, 41);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(160, 47, 233, 41);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(62, 124, 189, 41);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(277, 124, 189, 41);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBounds(277, 201, 189, 41);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_3.setBounds(62, 201, 189, 41);
		button_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_4.setBounds(0, 301, 93, 34);
		btnViewStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnViewStudentDetails.setBounds(304, 308, 202, 27);
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(label);
		contentPane.add(label_2);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(button_3);
		contentPane.add(btnViewStudentDetails);
		contentPane.add(button_4);
	}
	private void setupListeners()//Setups the views listeners.
	{
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				baseController.getAppFrame().setVisible(true);
				baseController.setActiveLibrarian();
				closeForm();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				AddNewBookView addNewBookView = new AddNewBookView(baseController);
				closeForm();
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				ViewLoansList viewLoansList = new ViewLoansList(baseController);
				closeForm();
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				LibrarySeatingMap librarySeatingMap = new LibrarySeatingMap(baseController);
				closeForm();
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				FindBookView findBookView = new FindBookView(baseController);
				closeForm();
			}
		});
		btnViewStudentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentsListView studentsViewList = new StudentsListView(baseController);
				closeForm();
			}
		});
	}
	public void hideForm()//Turns form visiability to false.
	{
		this.setVisible(false);
	}
	public void closeForm()//Closes this form and disposes it.
	{
		this.dispose();
	}


}
