package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.LoginPageController;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
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

import javax.swing.JFrame;
public class ViewLoansList extends JFrame {
	//Attributes.
	private JPanel contentPane;
	private JButton button;
	private JTextPane textPane;
	private JLabel lblBookId;
	private JTextPane textPane_2;
	private JLabel lblStudentId;
	private JLabel label_4;
	private LoginPageController baseController;
	private JTable table;
	private String[] columns = {"Book Id", "Student ID","Loan Date","Is Active"};
	private Object[][] row= new Object[100][4];
	private JScrollPane pane;
	private DefaultTableModel model;
	private JButton button_1;
	//
	
	//Constructor
	public ViewLoansList(LoginPageController baseController) {
		this.baseController=baseController;
		setupFrame();
		table = new JTable();
		button = new JButton("Back");
		textPane = new JTextPane();
		lblBookId = new JLabel("Book ID :");
		textPane_2 = new JTextPane();
		lblStudentId = new JLabel("Student ID :");
		label_4 = new JLabel("Loan List");
		button_1 = new JButton("Open Loan");
		setupPanel();
		setupLayout();
		setupListeners();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
		fillTable();
	}
	//
	private void fillTable() // Fills the table with loans list
	{
		pane = new JScrollPane (table);
		pane.setBounds(40, 108, 525, 221);
		row=baseController.createLoanArray();
	    model = (DefaultTableModel) table.getModel();
		model.setDataVector(row, columns);
		Font font = new Font("",1,16);
		table.setFont(font);
		contentPane.add(pane);
		removeEmptyRows();
		table.setDefaultEditor(Object.class, null);
	}
	private void setupFrame()//Setups the views Frame.
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 442);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void setupLayout()//Setups the views Layout.
	{
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(58, 139, 509, 176);
		button.setBounds(10, 376, 89, 23);
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(418, 77, 87, 20);
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBookId.setBounds(89, 69, 76, 28);
		textPane_2.setBackground(Color.LIGHT_GRAY);
		textPane_2.setBounds(175, 77, 87, 20);
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentId.setBounds(308, 69, 100, 28);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(262, 11, 121, 28);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(235, 340, 128, 27);
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(button);
		contentPane.add(table);
		contentPane.add(textPane);
		contentPane.add(lblBookId);
		contentPane.add(textPane_2);
		contentPane.add(lblStudentId);
		contentPane.add(label_4);
		contentPane.add(button_1);
	}
	private void setupListeners()//Setups the views listeners.
	{
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				int bookID;
				int studentID;
				String loanDate;
				if(i>=0)
				{
					bookID=Integer.parseInt(model.getValueAt(i, 0).toString());
					studentID=Integer.parseInt(model.getValueAt(i, 1).toString());
					loanDate=model.getValueAt(i, 2).toString();
					LoanDetailsView loanDetailsView = new LoanDetailsView(baseController,bookID,studentID,loanDate);
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
					model.setDataVector(baseController.updateLoanTable(text,0,row), columns);
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
				model.setDataVector(baseController.updateLoanTable(text,1,row), columns);
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
