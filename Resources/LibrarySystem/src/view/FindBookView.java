package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.LoginPageController;

import javax.swing.JFrame;
public class FindBookView extends JFrame {
	//Attributes
	private JPanel contentPane;
	private JTable table;
	private LoginPageController baseController;
	private JLabel label;
	private JLabel label_1;
	private JTextPane textPane;
	private JButton button;
	private JButton button_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextPane textPane_1;
	private JTextPane textPane_2;
	private String[] columns = {"Book Id", "Book Name","Book Genere","Book Author"};
	private Object[][] row= new Object[100][4];
	private JScrollPane pane;
	private DefaultTableModel model;
	//
	
	//Constructor
	public FindBookView(LoginPageController baseController) {
		this.baseController=baseController;
		setupFrame();
		label = new JLabel("Find Book");
		label_1 = new JLabel("Book ID :");
		textPane = new JTextPane();
		button = new JButton("Back");
		button_1 = new JButton("Confirm");
		label_2 = new JLabel("Book Author :");
		label_3 = new JLabel("Book Name :");
		textPane_1 = new JTextPane();
		textPane_2 = new JTextPane();
		table = new JTable();
		setupPanel();
		setupLayout();
		setupListeners();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
		fillTable();
	}
	private void fillTable() // Fills the table with the book array.
	{
		pane = new JScrollPane (table);
		pane.setBounds(34, 159, 525, 164);
		row=baseController.createBookArray();
	    model = (DefaultTableModel) table.getModel();
		model.setDataVector(row, columns);
		Font font = new Font("",1,14);
		table.setFont(font);
		contentPane.add(pane);
		removeEmptyRows();
		table.setDefaultEditor(Object.class, null);
	}
	
	private void setupFrame()//Setups the views Frame.
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 440);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void setupLayout()//Setups the views Layout.
	{
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(235, 32, 97, 24);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(38, 79, 81, 17);
		textPane.setForeground(Color.DARK_GRAY);
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(370, 76, 110, 20);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(10, 358, 87, 32);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(222, 328, 126, 34);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(38, 153, 525, 164);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(260, 122, 110, 17);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(260, 79, 110, 17);
		textPane_1.setBackground(Color.LIGHT_GRAY);
		textPane_1.setBounds(370, 119, 110, 20);
		textPane_2.setBackground(Color.LIGHT_GRAY);
		textPane_2.setBounds(114, 76, 110, 20);
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(textPane);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(table);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(textPane_1);
		contentPane.add(textPane_2);
	}
	private void setupListeners()//Setups the views listeners.
	{
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				int bookID;
				if(i>=0)
				{
					bookID=Integer.parseInt(model.getValueAt(i, 0).toString());
					//JOptionPane.showMessageDialog(null, bookID);
					BookInfoView bookInfoView = new BookInfoView(baseController,bookID);
					closeForm();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Choose a listing from the table.");
				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				LibririanMenuView libririanMenuView = new LibririanMenuView(baseController);
				closeForm();
			}
		});
		textPane_2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String text = textPane_2.getText();
				if(text.equals(""))
				{
					model.setDataVector(row, columns);	
				}
				else
				{
					textPane.setText("");
					textPane_1.setText("");
					model.setDataVector(baseController.updateSearchTable(text,0,row), columns);
				}
				removeEmptyRows();
			}
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
		textPane.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String text = textPane.getText();
				if(text.equals(""))
				{
					model.setDataVector(row, columns);
				}
				else
				{
				textPane_2.setText("");
				textPane_1.setText("");
				model.setDataVector(baseController.updateSearchTable(text,1,row), columns);
				}
				removeEmptyRows();
			}
		});
		textPane_1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String text = textPane_1.getText();
				if(text.equals(""))
				{
					model.setDataVector(row, columns);
				}
				else
				{
				textPane.setText("");
				textPane_2.setText("");
				model.setDataVector(baseController.updateSearchTable(text,3,row), columns);
				}
				removeEmptyRows();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			      if ((c >= '0') && (c <= '9') ) {
			        getToolkit().beep();
			        e.consume();
			      }
			}
		});
	}
	private void removeEmptyRows()
	{
		for(int i=model.getRowCount()-1;i>=0;i--)
		{
			if(model.getValueAt(i, 0)==null) {
				model.removeRow(i);
			}
		}
	}
	public void closeForm()//Closes this form and disposes it.
	{
		this.dispose();
	}


}
