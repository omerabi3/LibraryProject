package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginPageController;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JFrame;
public class UserMenuView extends JFrame {
	//Attributes.
	private JPanel contentPane;
	private LoginPageController baseController;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	//

	//Constructor
	public UserMenuView(LoginPageController baseController) {
		this.baseController=baseController;
		setupFrame();
		label = new JLabel("Hello ");
		label_1 = new JLabel((String) null);
		label_2 = new JLabel("Student Interface");
		button = new JButton("Loan New Book");
		button_1 = new JButton("Reserve Library Seat");
		button_2 = new JButton("Return Book");
		button_3 = new JButton("My Profile");
		button_4 = new JButton("Sign out");
		setupPanel();
		setupLayout();
		setupListeners();
		label.setText(baseController.getStudent().getStudentFirstName());
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
	}
	//
	
	private void setupFrame()//Setups the views Frame.
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 353);
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
		contentPane.add(label_2);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(button_3);
		contentPane.add(button_4);
		
	}
	private void setupLayout()//Setups the views Layout.
	{
		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBounds(33, 0, 59, 41);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(90, 15, 137, 14);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(142, 30, 233, 41);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(67, 97, 151, 70);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(67, 199, 369, 41);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBounds(285, 97, 151, 70);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_3.setBounds(399, 287, 118, 27);
		button_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_4.setBounds(0, 284, 93, 34);
	}
	private void setupListeners()//Setups the views listeners.
	{
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				baseController.getAppFrame().setVisible(true);
				baseController.getActiveStudent().setIsLogged(0);
				baseController.setActiveStudent();
				closeForm();
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				UserPersonalView userPersonalView = new UserPersonalView(baseController);
				closeForm();
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				ReturnBookView returnBookView = new ReturnBookView(baseController);
				closeForm();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				LoanNewBookView loanNewBook = new LoanNewBookView(baseController);
				closeForm();
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				LibrarySeatingMap librarySeatingMap = new LibrarySeatingMap(baseController);
				closeForm();
			}
		});
	}
	public void hideForm()//Hides the current form by turning its visibile feature to false.
	{
		this.setVisible(false);
	}
	public void closeForm()//Closes this form and disposes it.
	{
		this.dispose();
	}

}
