package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.LoginPageController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
public class ReturnBookView extends JFrame {
	//Attributes.
	private JPanel contentPane;
	private JTable table;
	private LoginPageController baseController;
	private JLabel label;
	private JButton button;
	private JButton button_1;
	private String[] columns = {"Book Id", "Book Name","Book Genere","Book Author"};
	private Object[][] row= new Object[100][4];
	private JScrollPane pane;
	private DefaultTableModel model;
	//
	
	//Constructor
	public ReturnBookView(LoginPageController baseController) {
		this.baseController=baseController;
		setupFrame();
		table = new JTable();
		label = new JLabel("Return Book");
		button = new JButton("Confirm");
		button_1 = new JButton("Back");
		setupPanel();
		setupLayout();
		setupListeners();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
		fillTable();
	}
	//
	
	private void fillTable()//fills table with books of specified student.
	{
		pane = new JScrollPane (table);
		pane.setBounds(10, 70, 529, 217);
		row=baseController.createReturnBookArray();
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
		setBounds(100, 100, 571, 410);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void setupLayout()//Setups the views Layout.
	{
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(10, 70, 529, 217);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(208, 45, 114, 14);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(208, 298, 114, 23);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(10, 348, 89, 23);
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(table);
		contentPane.add(label);
		contentPane.add(button);
		contentPane.add(button_1);
	}
	private void setupListeners()//Setups the views listeners.
	{
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				UserMenuView userMenuView = new UserMenuView(baseController);
				closeForm();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				int i = table.getSelectedRow();
				int bookID;
				if(i>=0)
				{
					bookID=Integer.parseInt(model.getValueAt(i, 0).toString());
					baseController.returnALoan(bookID);	
					UserMenuView userMenuView = new UserMenuView(baseController);
					closeForm();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Choose a listing from the table.");
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
