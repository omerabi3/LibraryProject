package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LoginPageController;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentsListView extends JFrame{
	//Attributes.
	private JPanel contentPane;
	private LoginPageController baseController;
	private JLabel lblStudentName;
	private JLabel lblStudentList;
	private JLabel lblStudentId;
	private JButton button_1;
	private JTextPane textPane;
	private JTextPane textPane_1;
	private JButton button;
	private String[] columns = {"Student ID", "First Name","Last Name","Email"};
	private Object[][] row= new Object[100][4];
	private JScrollPane pane;
	private DefaultTableModel model;
	private JTable table;
	//
	
	//Constructor
	public StudentsListView(LoginPageController baseController) {
		this.baseController=baseController;
		setupFrame();
		lblStudentName = new JLabel("Student Name :");
		lblStudentList = new JLabel("Student List");
		lblStudentId = new JLabel("Student ID :");
		button_1 = new JButton("Confirm");
		textPane = new JTextPane();
		table = new JTable();
		textPane_1 = new JTextPane();
		button = new JButton("Back");
		setupPanel();
		setupLayout();
		setupListeners();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
		fillTable();
	}
	//
	private void fillTable()//fills table with student list information.
	{
		pane = new JScrollPane (table);
		pane.setBounds(34, 159, 525, 164);
		row=baseController.createUsersArray();
	    model = (DefaultTableModel) table.getModel();
		model.setDataVector(row, columns);
		Font font = new Font("",1,14);
		table.setFont(font);
		contentPane.add(pane);
		removeEmptyRows();
		table.setDefaultEditor(Object.class, null);
	}
	
	private void setupLayout()//Setups the views Layout.
	{
		lblStudentList.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentList.setBounds(212, 27, 97, 24);
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentId.setBounds(34, 84, 110, 17);
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(136, 81, 110, 20);
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentName.setBounds(265, 81, 126, 17);
		textPane_1.setForeground(Color.DARK_GRAY);
		textPane_1.setBackground(Color.LIGHT_GRAY);
		textPane_1.setBounds(391, 81, 110, 20);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(0, 397, 87, 32);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(225, 353, 126, 34);
		table.setBounds(38, 108, 506, 250);
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(lblStudentList);
		contentPane.add(lblStudentId);
		contentPane.add(textPane);
		contentPane.add(lblStudentName);
		contentPane.add(textPane_1);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(table);

	}
	private void setupListeners()//Setups the views listeners.
	{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibririanMenuView libririanMenuView = new LibririanMenuView(baseController);
				closeForm();
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
				textPane_1.setText("");
				model.setDataVector(baseController.updateUserSearchTable(text,0,row), columns);
				}
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
				model.setDataVector(baseController.updateUserSearchTable(text,1,row), columns);
				}
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
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				int studentID;
				if(i>=0)
				{
					studentID=Integer.parseInt(model.getValueAt(i, 0).toString());
					StudentDetailsView studentDetailsView = new StudentDetailsView(baseController,studentID);
					closeForm();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Choose a listing from the table.");
				}
			}
			
		});
	}
	private void setupFrame()//Setups the views Frame.
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 468);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
