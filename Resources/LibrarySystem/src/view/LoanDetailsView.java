package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginPageController;
import model.Loan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoanDetailsView extends JFrame{
	//Attributes.
	private JPanel contentPane;
	private LoginPageController baseController;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblStudentName;
	private JLabel lblIsActive;
	private JLabel lblLoanDate;
	private JLabel label;
	private JLabel lblStudentId;
	private JButton button;
	private JLabel lblLoanInformation;
	private JLabel lblStudentId_1;
	private int bookID;
	private int studentID;
	private String loanDate;
	private JButton btnSetToTrue;
	private JButton btnSetToFalse;
	private Loan currentLoan;
	//
	//Constructor
	public LoanDetailsView(LoginPageController baseController,int bookID,int studentID,String loanDate) {
		this.bookID=bookID;
		this.loanDate=loanDate;
		this.studentID=studentID;
		this.baseController=baseController;
		setupFrame();
		lblStudentName = new JLabel("Student Name");
		lblIsActive = new JLabel("Is Active");
		lblLoanDate = new JLabel("Loan Date");
		label = new JLabel("Book ID");
		lblStudentId = new JLabel("Book Name");
		button = new JButton("Back");
		lblLoanInformation = new JLabel("Loan Information");
		lblStudentId_1 = new JLabel("Student ID");
		textField = new JTextField();
		textField_2 = new JTextField();
		textField_1 = new JTextField();
		textField_3 = new JTextField();
		textField_4 = new JTextField();
		textField_5 = new JTextField();
		btnSetToTrue = new JButton("Set To True");
		btnSetToFalse = new JButton("Set To False");
		setupPanel();
		setupLayout();
		setupListeners();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
		setLoanDetails();
	}
	//
	private void setLoanDetails()//Sets the appropriate details to specified loan and updates textfields.
	{
		currentLoan=baseController.getLibrary().getLoan(studentID, bookID, loanDate);
		textField.setText(baseController.getLibrary().getLibraryInventory().getBookByID(bookID).getBookName());//book name
		textField_2.setText(currentLoan.getLoanDate().toString());//loan date
		textField_1.setText(Integer.toString(bookID));//book id
		if(currentLoan.isActiveLoan())
		{
			textField_3.setText("True");//is active
			btnSetToFalse.setEnabled(true);
			btnSetToTrue.setEnabled(false);
			
		}
		else
		{
			textField_3.setText("False");//is active
			btnSetToFalse.setEnabled(false);
			btnSetToTrue.setEnabled(true);
		}
		textField_4.setText(Integer.toString(studentID));//student id
		textField_5.setText(baseController.getLibrary().getStudentList()[studentID-1].getStudentFirstName());//student name
	}
	private void setupFrame()//Setups the views Frame.
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 425);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(label);
		contentPane.add(lblStudentId);
		contentPane.add(textField);
		contentPane.add(textField_1);
		contentPane.add(textField_2);
		contentPane.add(textField_3);
		contentPane.add(lblLoanDate);
		contentPane.add(lblIsActive);
		contentPane.add(button);
		contentPane.add(lblLoanInformation);
		contentPane.add(textField_4);
		contentPane.add(lblStudentId_1);
		contentPane.add(textField_5);
		contentPane.add(lblStudentName);
		contentPane.add(btnSetToTrue);
		contentPane.add(btnSetToFalse);
	}
	private void setupLayout()//Setups the views Layout.
	{
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(52, 95, 69, 47);
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentId.setBounds(245, 95, 121, 47);
		btnSetToTrue.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSetToTrue.setBounds(207, 304, 159, 20);
		btnSetToFalse.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSetToFalse.setBounds(207, 333, 159, 20);
		textField.setText((String) null);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(212, 136, 141, 20);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(20, 136, 135, 20);
		textField_2.setText((String) null);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(20, 273, 135, 20);
		textField_3.setText((String) null);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(212, 273, 141, 20);
		lblLoanDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoanDate.setBounds(51, 232, 104, 47);
		lblIsActive.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIsActive.setBounds(255, 232, 96, 47);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(0, 354, 87, 32);
		lblLoanInformation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoanInformation.setBounds(122, 37, 159, 47);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(20, 213, 135, 20);
		lblStudentId_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentId_1.setBounds(52, 172, 87, 47);
		textField_5.setText((String) null);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(212, 213, 141, 20);
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentName.setBounds(222, 174, 121, 47);
		
	}
	private void setupListeners()//Setups the views listeners.
	{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibririanMenuView libririanMenuView = new LibririanMenuView(baseController);
				closeForm();
			}
		});
		btnSetToTrue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(baseController.getLibrary().getLibraryInventory().getBookByID(currentLoan.getBookID()).getBookAmountAvailable()>0)
				{
					baseController.getLibrary().getLibraryInventory().getBookByID(currentLoan.getBookID()).setBookAmountAvailable(baseController.getLibrary().getLibraryInventory().getBookByID(currentLoan.getBookID()).getBookAmountAvailable() - 1);
					currentLoan.setActiveLoan(true);
					JOptionPane.showMessageDialog(null, "The Book is loaned.");
					LoanDetailsView loanDetailsView = new LoanDetailsView(baseController,bookID,studentID,loanDate);
					closeForm();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Cant set loan to true, the book is out of stock.");
				}

			}
		});
		btnSetToFalse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baseController.getLibrary().returnALoan(studentID, bookID);
				LoanDetailsView loanDetailsView = new LoanDetailsView(baseController,bookID,studentID,loanDate);
				closeForm();
			}
		});
	}
	public void closeForm()//Closes this form and disposes it.
	{
		this.dispose();
	}
}
