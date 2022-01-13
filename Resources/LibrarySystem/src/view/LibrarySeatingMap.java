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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class LibrarySeatingMap extends JFrame{

	//Attributes.
	private JPanel contentPane;
	private LoginPageController baseController;
	private JLabel label;
	private JButton button;
	private JLabel lblNewLabel;
	private ImageIcon tableIcon;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel[] chairLabels;
	//

	//Constructor
	public LibrarySeatingMap(LoginPageController baseController) {
		this.baseController=baseController;
		setupFrame();
		label = new JLabel("Library Map");
		button = new JButton("Back");
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		label_1 = new JLabel("");
		label_2 = new JLabel("");
		setupPanel();
		setupLayout();
		if(baseController.isCallListeners())
		{
			setupListeners();
			baseController.setCallListeners(false);
		}
		setupButtonListeners();
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Set the form to be in center
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//Set the form to be in center
	}
	//
	private void setupFrame()//Setups the views Frame.
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 567);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
	}
	private void setupPanel()//Setups the views panel.
	{
		int i;
		chairLabels=baseController.getLibrary().getLibraryMap().getSeatLabels();
        for (i=0;i<9;i++){
            getContentPane().add(chairLabels[i]);
        }
		contentPane.add(label);
		contentPane.add(button);
		contentPane.add(lblNewLabel);
		contentPane.add(label_1);
		contentPane.add(label_2);
		
	}
	private void setupLayout()//Setups the views Layout.
	{
		tableIcon = new ImageIcon(new ImageIcon("Pictures/table.png").getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(tableIcon);
		label_1.setIcon(tableIcon);
		label_2.setIcon(tableIcon);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(417, 11, 104, 28);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(58, 150, 402, 99);
		label_1.setBounds(508, 150, 407, 99);
		label_2.setBounds(263, 357, 414, 99);
		button.setBounds(0, 0, 89, 23);
	}
	private void setupButtonListeners()//setups the button listerners indiviudally to avoid reference conflict of the seat images.
	{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				 if(baseController.getActiveStudent()==null)
				 {
						LibririanMenuView libririanMenuView = new LibririanMenuView(baseController);
						closeForm();
				 }
				 else
				 {
						UserMenuView userMenuView = new UserMenuView(baseController);
						closeForm();
				 }
			}
		});
	}
	private void setupListeners()//Setups the views listeners.
	{
		chairLabels[0].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().changeHoverPic(0);
			}
			public void mouseExited(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().exitHoverPic(0);
			}
			 public void mouseClicked(MouseEvent e)  
		   {  
				 if(baseController.getActiveStudent()==null)
				 {
					 baseController.checkReservedSeat(0);
					 baseController.cancelReservedSeat(0);
				 }
				 else
				 {
					 baseController.reserveSeat(0);
				 }
		   }  
		});
		chairLabels[1].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().changeHoverPic(1);
			}
			public void mouseExited(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().exitHoverPic(1);
			}
			 public void mouseClicked(MouseEvent e)  
			   {  
				 if(baseController.getActiveStudent()==null)
				 {
					 baseController.checkReservedSeat(1);
					 baseController.cancelReservedSeat(1);
				 }
				 else
				 {
					 baseController.reserveSeat(1);
				 }
			   }  
		});
		chairLabels[2].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().changeHoverPic(2);
			}
			public void mouseExited(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().exitHoverPic(2);
			}
			 public void mouseClicked(MouseEvent e)  
			   {  
				 if(baseController.getActiveStudent()==null)
				 {
					 baseController.checkReservedSeat(2);
					 baseController.cancelReservedSeat(2);
				 }
				 else
				 {
					 baseController.reserveSeat(2);
				 }
			   }   
		});
		chairLabels[3].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().changeHoverPic(3);
			}
			public void mouseExited(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().exitHoverPic(3);
			}
			 public void mouseClicked(MouseEvent e)  
			   {  
				 if(baseController.getActiveStudent()==null)
				 {
					 baseController.checkReservedSeat(3);
					 baseController.cancelReservedSeat(3);
				 }
				 else
				 {
					 baseController.reserveSeat(3);
				 }
			   }  
		});
		chairLabels[4].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().changeHoverPic(4);
			}
			public void mouseExited(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().exitHoverPic(4);
			}
			 public void mouseClicked(MouseEvent e)  
			   {  
				 if(baseController.getActiveStudent()==null)
				 {
					 baseController.checkReservedSeat(4);
					 baseController.cancelReservedSeat(4);
				 }
				 else
				 {
					 baseController.reserveSeat(4);
				 }
			   }  
		});
		chairLabels[5].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().changeHoverPic(5);
			}
			public void mouseExited(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().exitHoverPic(5);
			}
			 public void mouseClicked(MouseEvent e)  
			   {  
				 if(baseController.getActiveStudent()==null)
				 {
					 baseController.checkReservedSeat(5);
					 baseController.cancelReservedSeat(5);
				 }
				 else
				 {
					 baseController.reserveSeat(5);
				 }
			   }  
		});
		chairLabels[6].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().changeHoverPic(6);
			}
			public void mouseExited(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().exitHoverPic(6);
			}
			 public void mouseClicked(MouseEvent e)  
			   {  
				 if(baseController.getActiveStudent()==null)
				 {
					 baseController.checkReservedSeat(6);
					 baseController.cancelReservedSeat(6);
				 }
				 else
				 {
					 baseController.reserveSeat(6);
				 }
			   }  
		});
		chairLabels[7].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().changeHoverPic(7);
			}
			public void mouseExited(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().exitHoverPic(7);
			}
			 public void mouseClicked(MouseEvent e)  
			   {  
				 if(baseController.getActiveStudent()==null)
				 {
					 baseController.checkReservedSeat(7);
					 baseController.cancelReservedSeat(7);
				 }
				 else
				 {
					 baseController.reserveSeat(7);
				 }
			   }  
		});
		chairLabels[8].addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().changeHoverPic(8);
			}
			public void mouseExited(MouseEvent e) {
				baseController.getLibrary().getLibraryMap().exitHoverPic(8);
			}
			 public void mouseClicked(MouseEvent e)  
			   {  
				 if(baseController.getActiveStudent()==null)
				 {
					 baseController.checkReservedSeat(8);
					 baseController.cancelReservedSeat(8);
				 }
				 else
				 {
					 baseController.reserveSeat(8);
				 }
			   }   
		});	
	}
	public void closeForm()//Closes this form and disposes it.
	{
		this.dispose();
	}


}
