package model;

import java.awt.Image;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LibraryMap {
	//Attributes
	private LibrarySeat[] librarySeats;
	private JLabel[] seatLabels;
	private ImageIcon emptyChair;
	private ImageIcon hoverChair;
	private ImageIcon takenChair;
	//
	//Constructor and appropriate methods.
	public LibraryMap() {
		emptyChair = new ImageIcon(new ImageIcon("Pictures/chairEmpty.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		hoverChair = new ImageIcon(new ImageIcon("Pictures/chairHover.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		takenChair = new ImageIcon(new ImageIcon("Pictures/chairTaken.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		librarySeats=new LibrarySeat[9];
		seatLabels=new JLabel[9];
		generateSeats();
		createSeatLabels();
		setLayout();
	}
	private void createSeatLabels()// Assigns the labels and sets the images appropriatly for the seats.
	{
		seatLabels=new JLabel[9];
		for (int i=0;i<9;i++) 
		{
			seatLabels[i]=new JLabel("");
			seatLabels[i].setToolTipText(Integer.toString(i));
			if(librarySeats[i].isAvailable())
			{
				seatLabels[i].setIcon(emptyChair);
			}
			else
			{
				seatLabels[i].setIcon(emptyChair);
			}

		}
	}
	private void setLayout()// Setting the location of each seat in the library.
	{
		seatLabels[0].setBounds(71, 93, 81, 75);
		seatLabels[1].setBounds(162, 93, 81, 75);
		seatLabels[2].setBounds(254, 93, 81, 75);
		seatLabels[3].setBounds(531, 93, 81, 75);
		seatLabels[4].setBounds(622, 93, 81, 75);
		seatLabels[5].setBounds(714, 93, 81, 75);
		seatLabels[6].setBounds(284, 290, 81, 99);
		seatLabels[7].setBounds(384, 303, 81, 75);
		seatLabels[8].setBounds(483, 303, 81, 75);
	}
	private void generateSeats()//Creates the seats objects.
	{
		int i;
		for(i=0;i<9;i++)
		{
			librarySeats[i]=new LibrarySeat(i);
		}
	}
	//
	
	//Getters and Setters
	public LibrarySeat[] getLibrarySeats() {
		return librarySeats;
	}
	public void setLibrarySeats(LibrarySeat[] librarySeats) {
		this.librarySeats = librarySeats;
	}
	public JLabel[] getSeatLabels() {
		return seatLabels;
	}
	public void setSeatLabels(JLabel[] seatLabels) {
		this.seatLabels = seatLabels;
	}
	//
	
	//Mouse Hover methods
	public void changeHoverPic(int i)//Checks if the seat is reserved or not, and changes the picture appropriatly.
	{
		if(librarySeats[i].isAvailable())
		{
			seatLabels[i].setIcon(hoverChair);
		}
	}
	public void exitHoverPic(int i)//Checks if the seat is reserved or not, and changes the picture appropriatly.
	{
		if(librarySeats[i].isAvailable())
		{
			seatLabels[i].setIcon(emptyChair);
		}
	}
	//
	
	//Class Methods
	public boolean isAllowedToReserve(int studentID)//Checks if the student user can reserve a seat after clicking.
	{
		int i;
		for(i=0;i<9;i++)
		{
			if(librarySeats[i].isAvailable()==false)
			{
				if(librarySeats[i].getStudentID()==studentID)
				{
					JOptionPane.showMessageDialog(null, "You already reserved a seat.");
					return false;
				}
			}
		}
		return true;
	}
	public void reserveSeat(int i,int studentID)//Resrves the seat for the logged in student and sets appropriate icon to the seat.
	{
		if(librarySeats[i].isAvailable())
		{
			if(isAllowedToReserve(studentID))
			{
				librarySeats[i].setAvailable(false);
				librarySeats[i].setChairID(i);
				librarySeats[i].setStudentID(studentID);
				librarySeats[i].setTimeSaved(java.time.LocalTime.now());
				seatLabels[i].setIcon(takenChair);
				JOptionPane.showMessageDialog(null, "You reserved this seat.");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Chair is alredy taken.");
		}
	}
	public boolean checkReservedSeat(int i)//Checks if the seat is reserved.
	{
		if(librarySeats[i].isAvailable())
		{
			JOptionPane.showMessageDialog(null, "Chair is not reserved.");
			return true;
		}
		else
		{	
			return false;
		}
	}
	public void cancelReservedSeat(int i)//Cancels seat reservation.
	{
		librarySeats[i].setAvailable(true);
		JOptionPane.showMessageDialog(null,"The reservation is cancelled.");
	}


}
