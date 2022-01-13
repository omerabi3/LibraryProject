package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginPageController;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class StudentDetailsView extends JFrame {
	//Attributes.
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblEmail;
	private JLabel lblLastName;
	private JLabel lblStudentName;
	private JButton button;
	private JLabel lblStudentId;
	private JLabel lblPassword;
	private JLabel lblStudentInformation;
	private JButton btnSave;
	private JCheckBox chckbxEdit;
	private LoginPageController baseController;
	private int studentID;
	//
	//Constructor
	public StudentDetailsView(LoginPageController baseController,int studentID) {
		this.baseController=baseController;
		this.studentID=studentID;
		setupFrame();
		lblEmail = new JLabel("E-mail");
		lblLastName = new JLabel("Last Name");
		lblStudentName = new JLabel("First Name");
		button = new JButton("Back");
		lblStudentId = new JLabel("Student ID");
		lblPassword = new JLabel("Password");
		lblStudentInformation = new JLabel("Student Information");
		btnSave = new JButton("Save");
		chckbxEdit = new JCheckBox("Edit");
		textField = new JTextField();
		textField_1 = new JTextField();
		textField_2 = new JTextField();
		textField_3 = new JTextField();
		textField_4 = new JTextField();
		setupPanel();
		setupLayout();
		setupListeners();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
		setTextBoxes();
	}
	//
	private void setTextBoxes()//Fills textfields with logged student credentials.
	{
		textField.setText(Integer.toString(studentID));
		textField_1.setText(baseController.getLibrary().getStudentList()[studentID-1].getStudentFirstName());
		textField_2.setText(baseController.getLibrary().getStudentList()[studentID-1].getStudentLastName());
		textField_3.setText(baseController.getLibrary().getStudentList()[studentID-1].getStudentEmail());
		textField_4.setText(baseController.getLibrary().getStudentList()[studentID-1].getStudentPassword());
	}
	private void setupFrame()//Setups the views Frame.
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 471);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void setupLayout()//Setups the views Layout.
	{
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(0, 401, 87, 32);
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentId.setBounds(52, 88, 87, 47);
		textField.setText("0");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(20, 129, 135, 20);
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentName.setBounds(214, 88, 121, 47);
		textField_1.setText((String) null);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(204, 129, 141, 20);
		textField_2.setText("0");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(20, 200, 135, 20);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(52, 159, 87, 47);
		textField_3.setText((String) null);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(204, 206, 141, 20);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(248, 173, 87, 47);
		textField_4.setText((String) null);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(20, 260, 135, 20);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(51, 219, 104, 47);
		lblStudentInformation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentInformation.setBounds(113, 30, 159, 47);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(124, 307, 126, 41);
		chckbxEdit.setBounds(214, 259, 97, 23);
		btnSave.setVisible(false);
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(button);
		contentPane.add(lblStudentId);
		contentPane.add(textField);
		contentPane.add(lblStudentName);
		contentPane.add(textField_1);
		contentPane.add(textField_2);
		contentPane.add(lblLastName);
		contentPane.add(textField_3);
		contentPane.add(lblEmail);
		contentPane.add(textField_4);
		contentPane.add(lblPassword);
		contentPane.add(lblStudentInformation);
		contentPane.add(btnSave);
		contentPane.add(chckbxEdit);
	}
	public void closeForm()//Closes this form and disposes it.
	{
		this.dispose();
	}
	private void setupTextsToTrue()//Sets all textfields to true - edit on
	{
		btnSave.setVisible(true);
		textField_1.setEditable(true);
		textField_2.setEditable(true);
		textField_3.setEditable(true);
		textField_4.setEditable(true);
	}
	private void setupTextsToFalse()//Sets all textfields to false - edit off
	{
		btnSave.setVisible(false);
		textField_1.setEditable(false);
		textField_2.setEditable(false);
		textField_3.setEditable(false);
		textField_4.setEditable(false);
	}
	private void setupListeners()//Setups the views listeners.
	{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentsListView studentsViewList = new StudentsListView(baseController);
				closeForm();
			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName,lastName,email,password;
				firstName=textField_1.getText();
				lastName=textField_2.getText();
				email=textField_3.getText();
				password=textField_4.getText();
				 if (JOptionPane.showConfirmDialog(null, "Would you like to confirm the changes?", "WARNING",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
				 {
					 baseController.getLibrary().updateStudentCredentials(studentID, firstName, lastName, email, password);
					 StudentsListView studentsViewList = new StudentsListView(baseController);
					 closeForm();
				 } 
			}
		});
		chckbxEdit.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbxEdit.isSelected())
				{
					setupTextsToTrue();
				}
				else
				{
					setupTextsToFalse();
				}
			}
		});
	}

}
