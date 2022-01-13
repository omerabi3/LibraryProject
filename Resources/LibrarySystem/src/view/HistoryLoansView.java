package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LoginPageController;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistoryLoansView extends JFrame {
	//Attributes.
	private JPanel contentPane;
	private LoginPageController baseController;
	private JLabel lblHistoryloans;
	private JButton button;
	private DefaultTableModel model;
	private String[] columns = {"Book Id", "Book Name","Book Genere","Book Author","Loan Date"};
	private Object[][] row= new Object[100][5];
	private JTable table;
	private JScrollPane pane;
	//
	
	//Constructor
	public HistoryLoansView(LoginPageController baseController) {
		this.baseController=baseController;
		setupFrame();
		lblHistoryloans = new JLabel("History Loans");
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
	private void fillTable()//Fills the table with history loans.
	{
		pane = new JScrollPane (table);
		pane.setBounds(20, 60, 586, 352);
		row=baseController.createHistoryLoansArray();
	    model = (DefaultTableModel) table.getModel();
		model.setDataVector(row, columns);
		Font font = new Font("",1,12);
		table.setFont(font);
		contentPane.add(pane);
		removeEmptyRows();
		table.setDefaultEditor(Object.class, null);
	}
	private void setupFrame()//Setups the views Frame.
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void setupLayout()//Setups the views Layout.
	{
		lblHistoryloans.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHistoryloans.setBounds(247, 21, 128, 37);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(0, 423, 89, 23);
		table.setBounds(10, 57, 463, 341);
		
	}
	private void setupPanel()//Setups the views panel.
	{
		contentPane.add(lblHistoryloans);
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
