package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LoginPageController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ActiveLoansView extends JFrame{
	//Attributes
	private JPanel contentPane;
	private JLabel lblActiveLoans;
	private JButton button;
	private LoginPageController baseController;
	private JScrollPane pane;
	private DefaultTableModel model;
	private String[] columns = {"Book Id", "Book Name","Book Genere","Book Author"};
	private Object[][] row= new Object[100][4];
	private JTable table;
	//
	
	//Constructor
	public ActiveLoansView(LoginPageController baseController) {
		this.baseController=baseController;
		setupFrame();
	    lblActiveLoans = new JLabel("Active Loans");
	    button = new JButton("Back");
	    table = new JTable();
		setupPanel();
		setupLayout();
		setupListeners();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
		fillTable();

	}
	//
	
	private void fillTable() // Fills the table inside the view with the loans of the student.
	{
		pane = new JScrollPane (table);
		pane.setBounds(10, 60, 619, 332);
		row=baseController.createReturnBookArray();
	    model = (DefaultTableModel) table.getModel();
		model.setDataVector(row, columns);
		Font font = new Font("",1,14);
		table.setFont(font);
		contentPane.add(pane);
		removeEmptyRows();
		table.setDefaultEditor(Object.class, null);
	}
	private void setupFrame() // Setups the views Frame.
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void setupLayout()//Setups the views Layout.
	{
		lblActiveLoans.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblActiveLoans.setBounds(258, 23, 128, 37);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(0, 423, 89, 23);
		table.setBounds(20, 60, 462, 352);
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(lblActiveLoans);
		contentPane.add(button);
		contentPane.add(table);
	}
	private void setupListeners()//Setups the views listeners.
	{
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				UserPersonalView userPersonalView = new UserPersonalView(baseController);
				closeForm();
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
