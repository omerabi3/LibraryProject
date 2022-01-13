package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginPageController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookInfoView extends JFrame {
	//Attributes.
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton button;
	private JLabel label;
	private JLabel lblBookInformation;
	private JLabel lblNewLabel;
	private JLabel label_1;
	private JLabel lblBookAmountAvailable;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private LoginPageController baseController;
	private int bookID;
	private model.Book currentBook;
	private JButton btnDeleteBook;
	private JButton btnConfirmEdit;
	private JCheckBox chckbxClickToEdit;
	//
	
	//Constructor
	public BookInfoView(LoginPageController baseController, int bookID) {
		this.bookID=bookID;
		this.baseController=baseController;
		setupFrame();
		button = new JButton("Back");
		chckbxClickToEdit = new JCheckBox("click to edit");
		label = new JLabel("Book ID");
		lblBookInformation = new JLabel("Book Information");
		lblNewLabel = new JLabel("");
		label_1 = new JLabel("Book Name");
		lblBookAmountAvailable = new JLabel("Book Amount available");
		label_2 = new JLabel("Book Genre");
		label_3 = new JLabel("Book Author");
		label_4 = new JLabel("Book Amount");
		textField_3 = new JTextField();
		textField_4 = new JTextField();
		textField_5 = new JTextField();
		textField_1 = new JTextField();
		textField_2 = new JTextField();
		btnConfirmEdit = new JButton("Confirm Edit");
		textField = new JTextField();
		btnDeleteBook = new JButton("Delete Book");
		setupPanel();
		setupLayout();
		setupListeners();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
		fillBookParameters();
	}
	//
	
	private void fillBookParameters() // Fills the parameters of the selected book into the textfields.
	{
		currentBook=baseController.getLibrary().getLibraryInventory().getBookByID(bookID);
		textField.setText(Integer.toString(currentBook.getBookID()));
		textField_3.setText(currentBook.getBookAuthor());
		textField_5.setText(Integer.toString(currentBook.getBookAmountAvailable()));
		textField_1.setText(currentBook.getBookName());
		textField_2.setText(currentBook.getBookGenre());
		textField_4.setText(Integer.toString(currentBook.getBookAmount()));
		
	}
	private void setupFrame()//Setups the views Frame.
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 424);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void setupLayout()//Setups the views Layout.
	{
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(0, 353, 87, 32);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(98, 58, 69, 47);
		textField.setEditable(false);
		textField_1.setEditable(false);
		textField_2.setEditable(false);
		textField_3.setEditable(false);
		textField_4.setEditable(false);
		textField_5.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(32, 99, 135, 20);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(315, 58, 121, 47);
		textField_1.setColumns(10);
		textField_1.setBounds(270, 99, 141, 20);
		textField_2.setColumns(10);
		textField_2.setBounds(270, 157, 141, 20);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(325, 116, 96, 47);
		textField_3.setColumns(10);
		textField_3.setBounds(32, 157, 135, 20);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(81, 118, 104, 47);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(321, 174, 130, 47);
		textField_4.setColumns(10);
		textField_4.setBounds(270, 211, 141, 20);
		lblBookAmountAvailable.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBookAmountAvailable.setBounds(39, 174, 179, 47);
		textField_5.setColumns(10);
		textField_5.setBounds(32, 211, 135, 20);
		lblBookInformation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBookInformation.setBounds(164, 11, 159, 47);
		lblNewLabel.setBounds(339, 266, 135, 96);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("Pictures/Book.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(imageIcon);
		btnDeleteBook.setForeground(Color.RED);
		btnDeleteBook.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeleteBook.setBounds(0, 0, 121, 32);
		btnConfirmEdit.setForeground(Color.BLACK);
		btnConfirmEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfirmEdit.setBounds(150, 286, 148, 32);
		btnConfirmEdit.setVisible(false);
		chckbxClickToEdit.setBounds(32, 252, 97, 23);
		btnDeleteBook.setVisible(false);
	}
	private void setupListeners() //Setups the views listeners.
	{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindBookView findBookView = new FindBookView(baseController);
				closeForm();
			}
		});
		btnConfirmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookName,bookGenre,bookAuthor;
				int bookAmountAvailable,bookAmount;
				bookName=textField_1.getText();
				bookGenre=textField_2.getText();
				bookAuthor=textField_3.getText();
				bookAmountAvailable=Integer.parseInt(textField_5.getText());
				bookAmount=Integer.parseInt(textField_4.getText());
				baseController.getLibrary().getLibraryInventory().editBookByID(bookID, bookName, bookGenre, bookAuthor, bookAmountAvailable, bookAmount);
				FindBookView findBookView = new FindBookView(baseController);
				closeForm();
			}
		});
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
			}
		});
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
			}
		});
		chckbxClickToEdit.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbxClickToEdit.isSelected())
				{
					setupTextsToTrue();
				}
				else
				{
					setupTextsToFalse();
				}
			}
		});
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baseController.getLibrary().getLibraryInventory().setToNotInStock(bookID);
				FindBookView findBookView = new FindBookView(baseController);
				closeForm();
			}
		});
	}
	private void setupTextsToFalse() // Sets all the textfields to false. - edit off
	{
		btnConfirmEdit.setVisible(false);
		btnDeleteBook.setVisible(false);
		textField_1.setEditable(false);
		textField_2.setEditable(false);
		textField_3.setEditable(false);
		textField_4.setEditable(false);
		textField_5.setEditable(false);
	}
	private void setupTextsToTrue()// Sets all the textfields to true. - edit onn
	{
		btnConfirmEdit.setVisible(true);
		btnDeleteBook.setVisible(true);
		textField_1.setEditable(true);
		textField_2.setEditable(true);
		textField_3.setEditable(true);
		textField_4.setEditable(true);
		textField_5.setEditable(true);
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(button);
		contentPane.add(label);
		contentPane.add(textField);
		contentPane.add(label_1);
		contentPane.add(textField_1);
		contentPane.add(textField_2);
		contentPane.add(label_2);
		contentPane.add(textField_3);
		contentPane.add(label_3);
		contentPane.add(label_4);
		contentPane.add(textField_4);
		contentPane.add(lblBookAmountAvailable);
		contentPane.add(lblBookInformation);
		contentPane.add(textField_5);
		contentPane.add(lblNewLabel);
		contentPane.add(btnDeleteBook);
		contentPane.add(btnConfirmEdit);
		contentPane.add(chckbxClickToEdit);
	}
	public void closeForm()//Closes this form and disposes it.
	{
		this.dispose();
	}

}
