package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginPageController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutView extends JFrame {
	//Attributes.
	private LoginPageController baseController;
	private JPanel contentPane;
	private JLabel lblAbout;
	private JLabel lblThisSoftwareWas;
	private JLabel lblLogInAs;
	private JLabel lblLogInAs_1;
	private JLabel lblAlex;
	private JLabel lblSnir;
	private JLabel lblOmer;
	private JLabel lblEugene;
	private JLabel lblAnat;
	private JLabel lblMichael;
	private JButton button;
	//

	//Constructor
	public AboutView(LoginPageController baseController) {
		setupFrame();
		this.baseController=baseController;
		lblAbout = new JLabel("About");
		lblThisSoftwareWas = new JLabel("This software was desigend for a course in H.I.T");
		lblLogInAs = new JLabel("Log in as a student :");
		lblLogInAs_1 = new JLabel("Log in as a librarian:");
		lblAlex = new JLabel("Alex - 1:1");
		lblSnir = new JLabel("Snir - 2:2");
		lblOmer = new JLabel("Omer - 3:3");
		lblEugene = new JLabel("Eugene - 4:4");
		lblAnat = new JLabel("Anat - 5:5");
		lblMichael = new JLabel("Michael - 6:6");
		button = new JButton("Back");
		setupPanel();
		setupLayout();
		setupListeners();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
	}
	//
	
	//Setups the views Frame.
	public void setupFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 329);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	//
	//Setups the views Layout.
	public void setupLayout()
	{
		lblAbout.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAbout.setBounds(183, 11, 97, 24);
		lblThisSoftwareWas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThisSoftwareWas.setBounds(30, 56, 389, 24);
		lblLogInAs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogInAs.setBounds(28, 91, 152, 24);
		lblLogInAs_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogInAs_1.setBounds(257, 91, 177, 24);
		lblAlex.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAlex.setBounds(56, 126, 97, 24);
		lblSnir.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSnir.setBounds(56, 161, 97, 24);
		lblOmer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOmer.setBounds(56, 199, 97, 24);
		lblEugene.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEugene.setBounds(286, 126, 97, 24);
		lblAnat.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAnat.setBounds(286, 161, 97, 24);
		lblMichael.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMichael.setBounds(286, 199, 115, 24);
		button.setBounds(0, 267, 89, 23);
		
	}
	//
	//Setups the views panel.
	public void setupPanel()
	{
		contentPane.add(lblAbout);
		contentPane.add(lblThisSoftwareWas);
		contentPane.add(lblLogInAs);
		contentPane.add(lblLogInAs_1);
		contentPane.add(lblAlex);
		contentPane.add(lblSnir);	
		contentPane.add(lblOmer);
		contentPane.add(lblEugene);
		contentPane.add(lblAnat);
		contentPane.add(lblMichael);
		contentPane.add(button);
	}
	//
	//Setups the views listeners.
	public void setupListeners()
	{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baseController.getAppFrame().setVisible(true);
				closeForm();
			}
		});
	}
	//
	//Closes this form and disposes it.
	public void closeForm()
	{
		this.dispose();
	}

}
