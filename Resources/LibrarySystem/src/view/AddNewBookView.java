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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class AddNewBookView extends JFrame{
	//Attributes.
	private JPanel contentPane;
	private LoginPageController baseController;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JButton button;
	private JButton button_1;
	//
	
	//Constructor
	public AddNewBookView(LoginPageController baseController) {
		this.baseController=baseController;
		setupFrame();
		label = new JLabel("Book ID");
		label_1 = new JLabel("Book Author");
		label_2 = new JLabel("Add a new Book");
		label_3 = new JLabel("Book Name");
		label_4 = new JLabel("Book Genre");
		label_5 = new JLabel("Book Amount");
		button = new JButton("Add Book");
		button_1 = new JButton("Back");
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			      if ((c >= '0') && (c <= '9') ) {
			        getToolkit().beep();
			        e.consume();
			      }
			}
		});
		textField_5 = new JTextField();
		textField = new JTextField();
		textField.setText("1");
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			      if ((c >= '0') && (c <= '9') ) {
			        getToolkit().beep();
			        e.consume();
			      }
			}
		});
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText(Integer.toString(baseController.getLibrary().getLibraryInventory().getAmountOfBooks()+1));
		setupPanel();
		setupLayout();
		setupListeners();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
	}
	//
	
	private void setupFrame() //Setups the views Frame.
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 410);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void setupLayout()//Setups the views Layout.
	{
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(39, 54, 69, 47);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(39, 103, 104, 47);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(273, 11, 139, 47);
		textField.setColumns(10);
		textField.setBounds(157, 168, 86, 20);
		textField_1.setColumns(10);
		textField_1.setBounds(157, 118, 86, 20);
		textField_2.setColumns(10);
		textField_2.setBounds(157, 69, 86, 20);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(307, 54, 121, 47);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(307, 103, 96, 47);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(37, 153, 130, 47);
		textField_4.setColumns(10);
		textField_4.setBounds(438, 118, 86, 20);
		textField_5.setColumns(10);
		textField_5.setBounds(438, 69, 86, 20);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(270, 228, 114, 32);
		button_1.setBounds(0, 344, 89, 23);
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(textField);
		contentPane.add(textField_1);
		contentPane.add(textField_2);
		contentPane.add(label_3);
		contentPane.add(label_4);
		contentPane.add(label_5);
		contentPane.add(textField_4);
		contentPane.add(textField_5);
		contentPane.add(button);
		contentPane.add(button_1);
	}
	private void setupListeners()//Setups the views listeners.
	{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				int bookID = Integer.parseInt(textField_2.getText());
				String bookName = textField_5.getText();
				String bookAuthor = textField_1.getText();
				String bookGenre = textField_4.getText();
				int bookAmount = Integer.parseInt(textField.getText());
				if(bookName.equals("")||bookAuthor.equals("")||bookGenre.equals("")|bookAmount<1) // checks if all paramaters were filled.
				{
					JOptionPane.showMessageDialog(null, "Fill all the parameters appropriatley.");
					if(bookAmount<1)
					{
						JOptionPane.showMessageDialog(null, "Book amount must be atleast 1.");
					}
				}
				else
				{
					if(baseController.addNewBook(bookID, bookName, bookAuthor, bookGenre, bookAmount))
					{
						textField_4.setText(""); //bookGenre
						textField_5.setText("");  //bookName
						textField.setText(""); //bookAmount
						textField_1.setText(""); //bookAuthor
						textField_2.setText(""); //bookID
					}	
					LibririanMenuView libririanMenuView = new LibririanMenuView(baseController);
					closeForm();			
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibririanMenuView libririanMenuView = new LibririanMenuView(baseController);
				closeForm();
			}
		});
		textField.addKeyListener(new KeyAdapter() {
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
	}
	
	public void closeForm()//Closes this form and disposes it.
	{
		this.dispose();
	}
}
